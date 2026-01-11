package com.yuriihetsko.leetcodepractice.arraysandhashing

import org.junit.Assert
import org.junit.Test

class _49_GroupAnagram {

    @Test
    fun testCases12345() {
        Assert.assertEquals(
            listOf(listOf("hat"), listOf("aaact", "cataa"), listOf("stop", "pots", "tops")),
            getGroupedAnagram(
                listOf(
                    "aaact",
                    "cataa"
//                    "pots",
//                    "tops",
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

    // preFinalHashMap = {30100000000000000000100000 -> ["aact"], ...}
    //
    fun getGroupedAnagram(strsOriginal: List<String>): List<List<String>> {
        val strSet = strsOriginal.toSet()
        val listOfLists = mutableListOf<List<String>>()

        val preFinalMap = hashMapOf<String, List<String>>()

        // Create an int array with 26 items.
        // Count frequency of each letter.
        // This will be the key in hashmap for an unique anagram.
        // For "act" it will be: "abcdefghijklmnopqrstuvwxyz" -> "10100000000000000000100000"

        strSet.forEachIndexed { i, curr ->
            val alphabetMap = linkedMapOf<Char, Int>().apply {
                for (c in 'a'..'z'){
                    this[c] = 0
                }
            }

            curr.toCharArray().forEach { char ->
                alphabetMap[char] = alphabetMap.getOrElse(char) { 0 } + 1
            }

            println("GETZ.GroupAnagramTest.getGroupedAnagram--> i=$i curr=$curr alphabetMap=${alphabetMap}")
            //curr=aact; alphabetMap={a=3, b=0, c=1, d=0, e=0, f=0, g=0, h=0, i=0, j=0, k=0, l=0, m=0, n=0, o=0, p=0, q=0, r=0, s=0, t=1, u=0, v=0, w=0, x=0, y=0, z=0}

            val uniqueKeyForAnagram = alphabetMap.map {
                it.value
            }.joinToString("")

            println("GETZ._49_GroupAnagram.getGroupedAnagram--> uniqueKeyForAnagram=$uniqueKeyForAnagram")

            preFinalMap.put(uniqueKeyForAnagram, )
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