package com.yuriihetsko.leetcodepractice.arraysandhashing

import org.junit.Assert
import org.junit.Test

class _49_GroupAnagram {

    @Test
    fun case1() {
        Assert.assertEquals(
            listOf(
                listOf("hat"),
                listOf("act", "cat"),
                listOf("pots", "tops", "stop")
            ),
            groupAnagrams(
                listOf(
                    "act",
                    "cat",
                    "pots",
                    "tops",
                    "stop",
                    "hat",
                )
            )
        )
    }

    @Test
    fun case2() {
        Assert.assertEquals(
            listOf(listOf("")),
            groupAnagrams(listOf(""))
        )

    }

    @Test
    fun case3() {
        Assert.assertEquals(
            listOf(listOf("", "")),
            groupAnagrams(listOf("", ""))
        )
    }

    @Test
    fun case4() {
        Assert.assertEquals(
            listOf(listOf("bbbbbbbbbbc"), listOf("bdddddddddd")),
            groupAnagrams(listOf("bdddddddddd", "bbbbbbbbbbc"))
        )
    }

    // Given an array of strings strs, group all anagrams together into sublists.
    // You may return the output in any order.
    // An anagram is a string that contains the exact same characters as another string,
    // but the order of the characters can be different.
    //
    // Input: strs = ["act","pots","tops","cat","stop","hat"]
    // Output: [["hat"],["act","cat"],["stop","pots","tops"]]

    // preFinalHashMap = {30100000000000000000100000 -> ["aact"], ...}
    //
    fun groupAnagrams(strs: List<String>): List<List<String>> {
        val finalMap = hashMapOf<String, ArrayList<String>>()

        strs.forEach { curr ->
            val linkedMap = linkedMapOf<Char, Int>().apply {
                for (c in 'a'..'z') {
                    this[c] = 0
                }
            }

            if (curr.isEmpty()) {
                linkedMap['a'] = linkedMap.getOrDefault('a', 0)
            }

            curr.toCharArray().forEach { char ->
                linkedMap[char] = linkedMap.getOrElse(char) { 0 } + 1
            }

            val keyWithZeros = linkedMap.values.joinToString(separator = "#")

            finalMap.getOrPut(keyWithZeros) { arrayListOf() }
                .add(curr)

            println("GETZ._49_GroupAnagram.groupAnagrams--> finalMap=$finalMap")
        }

        return finalMap.values.toList()
    }
}