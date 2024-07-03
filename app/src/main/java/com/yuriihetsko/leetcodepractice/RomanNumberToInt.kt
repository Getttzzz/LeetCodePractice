package com.yuriihetsko.leetcodepractice

fun main() {
    println("romanToInt=${romanToInt("LVIII")}")
}


// Roman numerals are represented by seven different symbols:
// I - 1
// V - 5
// X - 10
// L - 50
// C - 100
// D - 500
// M - 1000

// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.

private fun romanToInt(s: String): Int {

    //  Input: s = "III"
    //  Output: 3
    //  Explanation: III = 3.


    //  Input: s = "LVIII"
    //  Output: 58
    //  Explanation: L = 50, V= 5, III = 3.

    // 54 -> LIV (L=50; IV=4)
    // 58 -> LVIII (L=50; V=5; III=3) //for I I need to check what's next. It could be I or II or III
    // 59 -> LIX (L=50; IX=9)
    // 60 -> LX (L=50; X=10)
    //

    val charList = s.toList()
    var sum = 0

    charList.forEachIndexed { i, char ->
        val nextChar = if (i < charList.size-1) charList[i + 1] else null

        println("char=$char nextChar=$nextChar")

        sum += when (char) {
            'I' -> {
                when (nextChar) {
                    null -> 1
                    'V' -> 4
                    'X' -> 9
                    else -> {
                        if (i < charList.size - 2) 3 else 2
                    }
                }
            }
            'V' -> 5
            'X' -> 10
            'L' -> 50
            else -> 0
        }
    }

    println("$sum")

    return sum
}