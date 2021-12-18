package com.raywenderlich.android.cocktailsgame

import org.junit.Assert
import org.junit.Test

class QuestionUnitTests {

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption(){
        val question = Question("Correct","Incorrect")
        Assert.assertNull(question.answeredOption)
    }

    @Test
    fun whenAnswering_shouldHaveAnsweredOption(){
        val question = Question("Correct","Incorrect")
        question.answer("Incorrect")

        Assert.assertEquals("Incorrect",question.answeredOption)
    }

    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue(){
        val question = Question("Correct","Incorrect")
        val result = question.answer("Correct")

        Assert.assertTrue(result)
    }

    @Test
    fun whenAnswering_withIncorrectOption_shouldReturnFalse(){
        val question=Question("Correct","Incorrect")
        val result = question.answer("Incorrect")

        Assert.assertFalse(result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_withInvalidOption_shouldThrowException(){
        val question=Question("Correct","Incorrect")

        question.answer("Invalid")
    }

}