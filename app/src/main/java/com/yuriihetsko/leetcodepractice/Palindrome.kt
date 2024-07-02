package com.yuriihetsko.leetcodepractice


// 9. Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.
fun main() {
    println("isPalindrome=${isPalindrome(1234)}")
}

// Input could be:
// 12321
//
private fun isPalindrome(x: Int): Boolean {
//    val result = x % 1000 // Input 12345; Result: 345
//    val result = x.rem(1000)Input 12345; Result: 345

//    val result = x.div(1000) // Input: 12345; Result: 12
//    val result = x / 1000 // Input 12345: Result: 12

    var temp = x
    var divisor = 1
    var quantity = 0

    val divisorList = mutableListOf<Int>()

    while (temp / divisor != 0) {
        temp -= divisor
        divisorList.add(divisor)
        divisor *= 10
        quantity += 1

//        temp=1233 divisor=10
//        temp=1223 divisor=100
//        temp=1123 divisor=1000
//        temp=123 divisor=10000

        println("temp=$temp divisor=$divisor quantity=$quantity")
    }

    println("$divisorList")

    for (i in 0..< quantity) {
        val firstDigit = x / divisorList[divisorList.size-1]
        println("firstDigit=$firstDigit x=$x ")
    }

    return false
}