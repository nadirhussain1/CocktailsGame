package com.raywenderlich.android.cocktailsgame

class Score(high:Int=0) {
    var current=0
    var highest=0

    init {
        highest=high
    }

    fun increment(){
        current++
        if(current>highest) {
            highest++
        }
    }
}