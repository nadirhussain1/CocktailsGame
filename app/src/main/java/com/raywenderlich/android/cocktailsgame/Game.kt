package com.raywenderlich.android.cocktailsgame

class Game(high:Int=0) {
    var currentScore=0
    var highestScore=0

    init{
        highestScore=high
    }

    fun incrementScore(){
        currentScore++
        if(currentScore>highestScore) {
            highestScore++
        }
    }
}