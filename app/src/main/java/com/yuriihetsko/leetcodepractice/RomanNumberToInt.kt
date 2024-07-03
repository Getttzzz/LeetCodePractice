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
    // 61 -> LXI
    // 62 -> LXII
    // 63 -> LXIII
    // 64 -> LXIV
    // 65 -> LXV

    val charList = s.toList()
    var sum = 0


    var i = 0
    for (char in charList) {
        val nextChar = if (i < charList.size - 1) charList[i + 1] else null

        println("char=$char nextChar=$nextChar")

        when (char) {
            'I' -> {
                when (nextChar) {
                    null -> sum+=1
                    'V' -> sum+=4
                    'X' -> sum+=9
                    'I' -> {
                        val nextNextChar = if (i < charList.size - 2) charList[i+2] else null
                        println("GETZ.<top>.romanToInt--> nextNextChar=$nextNextChar")
                        if (nextNextChar != null) {
                            sum+=3
                            break
                        } else {
                            sum+=2
                            break
                        }
                    }
                    else -> sum+=-999
                }
            }

            'V' -> sum+=5
            'X' -> sum+=10
            'L' -> sum+=50
            else -> sum+=-999
        }

        i++
    }

    println("$sum")

    return sum
}