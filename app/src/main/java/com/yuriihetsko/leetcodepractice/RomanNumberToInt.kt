package com.yuriihetsko.leetcodepractice

fun main() {
    println("romanToInt=${romanToInt("MCMXCIV")}")
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
    // 54 -> LIV (L=50; IV=4)
    // 58 -> LVIII (L=50; V=5; III=3) //for I I need to check what's next. It could be I or II or III
    // 59 -> LIX (L=50; IX=9)
    // 60 -> LX (L=50; X=10)
    // 61 -> LXI
    // 62 -> LXII
    // 63 -> LXIII
    // 64 -> LXIV
    // 65 -> LXV

    //Input: s = "MCMXCIV"
    //Output: 1994
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    val charList = s.toList()
    var sum = 0

    var skipCycle = false


    var i = 0
    for (char in charList) {
        if (skipCycle){
            i++
            skipCycle = false
            continue
        }
        val nextChar = if (i < charList.size - 1) charList[i + 1] else null

        println("char=$char nextChar=$nextChar")

        when (char) {
            'I' -> {
                when (nextChar) {
                    null -> {sum += 1; println("+1")}
                    'V' -> { sum += 4; println("+4"); break }
                    'X' -> { sum += 9; println("+9"); break }
                    'I' -> { if (i < charList.size - 2) { sum += 3;println("+3"); break } else { sum += 2;println("+2"); break } }
                    else -> error("Shouldn't be here")
                }
            }

            'V' -> {sum += 5; println("+5");}
            'X' -> { // 40 -> XL; 90 -> XC
                when(nextChar) {
                    'L' -> {sum+=40; println("+40");skipCycle=true; i++;continue}
                    'C' -> {sum+=90; println("+90"); skipCycle=true; i++; continue}
                    else -> {sum += 10; println("+10")}
                }
            }
            'L' -> {sum += 50; println("+50");}
            'C' -> {
                when(nextChar){
                    'D' -> {sum+=400; println("+400"); skipCycle=true; i++; continue}
                    'M' -> {sum+=900; println("+900");skipCycle=true; i++; continue}
                    else -> {sum+=100; println("+100")}
                }
            }
            'D' -> {sum+=500; println("+500");}
            'M' -> {sum+=1000; println("+1000");}
            else -> error("Shouldn't be here")
        }

        i++
    }
    println("$sum")

    return sum
}