package com.example.homework1.model

class Dice() {
    var sides = 6

    fun roll(time:Int): IntArray {
        var result = IntArray(10) {0}
        for (i in 1..time){
        result[i-1]=(1..sides).random()
        }
        return result
        // return MutableList (rollcount) { Random.nextInt(1, 7) } 也行
    }
}
