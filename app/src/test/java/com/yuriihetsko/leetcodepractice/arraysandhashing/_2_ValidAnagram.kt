package com.yuriihetsko.leetcodepractice.arraysandhashing

import org.junit.Assert
import org.junit.Test

class _2_ValidAnagram {

    @Test
    fun validAnagramTest() {
        Assert.assertEquals(true, isAnagram_HashMapsGetOrDefault(s = "carrace", t = "racecar"))
        Assert.assertEquals(true, isAnagram_HashMapsGetOrDefault(s = "anagram", t = "nagaram"))
    }

    // Given two strings s and t,
    // return true if the two strings are anagrams of each other, otherwise return false.
    fun isAnagramBruteForce(s: String, t: String): Boolean {
        val sortedStr1 = s.toCharArray().toString()
        val sortedStr2 = t.toCharArray().toString()

        return sortedStr1 == sortedStr2
    }

    // By the definition of the anagram, we can rearrange the characters.
    // Does the order of characters matter in both the strings? Then what matters?
    fun isAnagram_HashMaps(s: String, t: String): Boolean {
        val map1 = hashMapOf<Char, Int>()
        val map2 = hashMapOf<Char, Int>()

        s.toCharArray().forEach { char ->
            var charValue = map1[char]
            if (charValue == null) {
                map1.put(char, 1)
            } else {
                map1.put(char, ++charValue)
            }
        }

        t.toCharArray().forEach { char ->
            var charValue = map2[char]
            if (charValue == null) {
                map2.put(char, 1)
            } else {
                map2.put(char, ++charValue)
            }
        }

        return map1 == map2
    }

    fun isAnagram_HashMapsGetOrDefault(s: String, t: String): Boolean {
        val map1 = hashMapOf<Char, Int>()
        val map2 = hashMapOf<Char, Int>()

        s.toCharArray().forEach { char ->
            map1[char] = map1.getOrDefault(char, defaultValue = 0) + 1
        }

        t.toCharArray().forEach { char ->
            map2[char] = map2.getOrDefault(char, defaultValue = 0) + 1
        }

        return map1 == map2
    }
}