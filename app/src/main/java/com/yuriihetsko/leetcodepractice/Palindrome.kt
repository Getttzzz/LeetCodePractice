package com.yuriihetsko.leetcodepractice


// 9. Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.
fun main() {
    println("isPalindrome=${isPalindrome(12321)}")
}

//First palindromic numbers: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121
private fun isPalindrome(x: Int): Boolean {
//    val result = x % 1000 // Input 12345; Result: 345
//    val result = x.rem(1000)Input 12345; Result: 345

//    val result = x.div(1000) // Input: 12345; Result: 12
//    val result = x / 1000 // Input 12345: Result: 12

    if (x < 0) return false
    if (x == 0) return true


    var temp = x

    val digits = mutableListOf<Int>()

    while (temp > 0) {
        digits.add(temp % 10)
        temp /= 10
    }

    while (digits.size >= 1) {
        if (digits.first() != digits.last()) return false // oh no, x isn't a palindrome

        digits.removeFirstOrNull()
        digits.removeLastOrNull()
        println("$digits")
    }

    return true
}