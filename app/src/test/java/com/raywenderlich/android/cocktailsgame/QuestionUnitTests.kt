package com.raywenderlich.android.cocktailsgame

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {

    lateinit var question:Question

    @Before
    fun setUp(){
        question = Question("Correct","Incorrect")
    }

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption(){
        Assert.assertNull(question.answeredOption)
    }

    @Test
    fun whenAnswering_shouldHaveAnsweredOption(){
        question.answer("Incorrect")
        Assert.assertEquals("Incorrect",question.answeredOption)
    }

    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue(){
        val result = question.answer("Correct")
        Assert.assertTrue(result)
    }

    @Test
    fun whenAnswering_withIncorrectOption_shouldReturnFalse(){
        val result = question.answer("Incorrect")
        Assert.assertFalse(result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_withInvalidOption_shouldThrowException(){
        question.answer("Invalid")
    }



}