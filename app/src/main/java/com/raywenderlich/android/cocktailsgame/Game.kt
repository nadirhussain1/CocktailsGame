package com.raywenderlich.android.cocktailsgame

class Game(val questions:List<Question>, high:Int=0) {
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

    fun getNextQuestion():Question{
       return questions.get(0)
    }
}