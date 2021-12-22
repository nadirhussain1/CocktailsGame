package com.raywenderlich.android.cocktailsgame

class Game(val questions:List<Question>, high:Int=0) {
    var currentScore=0
    var highestScore=0
    var questionIndex:Int=0

    init{
        highestScore=high
    }

    fun incrementScore(){
        currentScore++
        if(currentScore>highestScore) {
            highestScore++
        }
    }

    fun getNextQuestion():Question?{
        questionIndex++;
        if(questionIndex<questions.size) {
            return questions.get(questionIndex)
        }
        return null
    }
}