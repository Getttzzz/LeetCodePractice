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

    while (temp / divisor != 0) {
        temp = temp - divisor
        divisor = divisor * 10


//        temp=1233 divisor=10
//        temp=1223 divisor=100
//        temp=1123 divisor=1000
//        temp=123 divisor=10000

        println("temp=$temp divisor=$divisor")
    }


//    val result = x / 1000
//    println("result=$result")


    return false
}