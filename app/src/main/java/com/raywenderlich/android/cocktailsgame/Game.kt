package com.raywenderlich.android.cocktailsgame

class Game(val questions: List<Question>, val score: Score = Score(0)) {
    var questionIndex: Int = 0

    fun getNextQuestion(): Question? {
        if (questionIndex < questions.size) {
            val nextQuestion = questions.get(questionIndex)
            questionIndex++;
            return nextQuestion
        }

        return null
    }

    fun answer(question: Question, option: String) {
        val result = question.answer(option)
        if (result) {
            score.increment()
        }
    }
}