package com.yuriihetsko.leetcodepractice


// 9. Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.
fun main() {
    println("isPalindrome=${isPalindrome(123321)}")
}

private fun isPalindrome(x: Int): Boolean {
//    val result = x % 1000 // Input 12345; Result: 345
//    val result = x.rem(1000)Input 12345; Result: 345

//    val result = x.div(1000) // Input: 12345; Result: 12
//    val result = x / 1000 // Input 12345: Result: 12

    var temp = x
    var divisor = 1

    val divisorList = mutableListOf<Int>()

    while (temp / divisor != 0) {
        temp -= divisor
        divisor *= 10

        divisorList.add(divisor)

//        temp=1233 divisor=10
//        temp=1223 divisor=100
//        temp=1123 divisor=1000
//        temp=123 divisor=10000
    }

    divisorList.removeLast() //remove redundant 10_000

    var nextX = x

    while (divisorList.isNotEmpty()) {
        println("nextX(start)=$nextX $divisorList")

        val firstDigit = nextX / divisorList.last()
        val lastDigit = nextX % divisorList.first()
        println("firstDigit=$firstDigit lastDigit=$lastDigit")

        if (firstDigit != lastDigit) return false // oh no, x isn't a palindrome

        nextX -= firstDigit * divisorList.last()
        nextX -= lastDigit
        nextX /= divisorList.first()

        divisorList.removeLastOrNull()
        divisorList.removeLastOrNull()

        println("nextX(end)=$nextX \n")
        // 230 -> 23 = 230/10=23
    }

    return true
}