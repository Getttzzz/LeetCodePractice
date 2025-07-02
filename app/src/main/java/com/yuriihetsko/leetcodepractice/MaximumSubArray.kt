package com.yuriihetsko.leetcodepractice

fun main() {
    println("maxSubArray=${maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))}")
}

//Given an integer array nums, find the subarray with the largest sum, and return its sum.

//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.

//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
private fun maxSubArray(array: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var currSum = 0

    array.forEachIndexed { i, element ->

        if (element > maxSum) {
            currSum += element
            if (currSum > maxSum) {
                maxSum = currSum
                currSum = 0
            }
        }

        println("i=$i element=$element maxSum=$maxSum currSum=$currSum")
    }


    return 1
}