package com.yuriihetsko.leetcodepractice.arraysandhashing

import org.junit.Assert
import org.junit.Test

class _5_TopKElements {

    @Test
    fun case1() {
        Assert.assertArrayEquals(
            intArrayOf(12, 8),
            topKFrequent(nums = intArrayOf(9, 12, 12, 12, 8, 8, 5), k = 2)
        )
    }

    @Test
    fun case2() {
        Assert.assertArrayEquals(
            intArrayOf(1, 2),
            topKFrequent(nums = intArrayOf(3, 2, 2, 1, 1, 1), k = 2)
        )
    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray =
        nums
            .asSequence()
            .groupingBy { it }
            .eachCount()
            .entries
            .sortedByDescending { it.value }
            .take(k)
            .map { it.key }
            .toIntArray()

}