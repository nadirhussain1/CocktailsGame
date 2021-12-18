package com.raywenderlich.android.cocktailsgame

import kotlin.IllegalArgumentException

class Question(val correctOption: String, val inCorrectOption: String) {
    var answeredOption: String? = null

    fun answer(option: String): Boolean {
        if (option != correctOption && option != inCorrectOption) {
            throw IllegalArgumentException("Not a valid answer")
        }

        answeredOption = option
        return (answeredOption == correctOption)
    }
}