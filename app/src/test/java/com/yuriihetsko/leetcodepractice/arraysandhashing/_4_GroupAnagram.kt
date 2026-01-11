package com.yuriihetsko.leetcodepractice.arraysandhashing

import org.junit.Assert
import org.junit.Test

class _4_GroupAnagram {

    @Test
    fun testCases12345() {
        Assert.assertEquals(
            listOf(listOf("hat"), listOf("act", "cat"), listOf("stop", "pots", "tops")),
            getGroupedAnagram(
                listOf(
                    "act",
//                    "pots",
//                    "tops",
//                    "cat",
//                    "stop",
//                    "hat",
                )
            )
        )
    }

    // Given an array of strings strs, group all anagrams together into sublists.
    // You may return the output in any order.
    // An anagram is a string that contains the exact same characters as another string,
    // but the order of the characters can be different.
    //
    // Input: strs = ["act","pots","tops","cat","stop","hat"]
    // Output: [["hat"],["act","cat"],["stop","pots","tops"]]
    //
    fun getGroupedAnagram(strsOriginal: List<String>): List<List<String>> {
        val alphabet: String = ('a'..'z').joinToString(separator = "")
        val strSet = strsOriginal.toSet()
        val listOfLists = mutableListOf<List<String>>()

        // Create an int array with 26 items.
        // Count frequency of each letter.
        // This will be the key in hashmap for an unique anagram.
        // For "act" it will be: "abcdefghijklmnopqrstuvwxyz" -> "10100000000000000000100000"

        strSet.forEachIndexed { i, curr ->
            val alphabetMap = hashMapOf<Char, Int>()

            curr.toCharArray().forEach { char ->
                alphabetMap[char] = alphabetMap.getOrElse(char) { 0 } + 1
            }

            println("GETZ.GroupAnagramTest.getGroupedAnagram--> i=$i curr=$curr alphabetMap=${alphabetMap}")
        }

        return listOfLists
    }

    fun isAnagram(str: String, target: String): Boolean {
        val map1 = hashMapOf<Char, Int>()
        val map2 = hashMapOf<Char, Int>()

        str.toCharArray().forEach { char ->
            map1[char] = map1.getOrElse(char) { 0 } + 1
        }

        target.toCharArray().forEach { char ->
            map2[char] = map2.getOrElse(char) { 0 } + 1
        }

        return map1 == map2
    }
}