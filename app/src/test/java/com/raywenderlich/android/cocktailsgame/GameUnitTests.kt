package com.raywenderlich.android.cocktailsgame

import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.*

class GameUnitTests {
    @Test
    fun whenGettingNextQuestion_shouldReturnFirst(){
        val firstQuestion = Question("Correct","Incorrect")
        val questions= listOf(firstQuestion)

        val game=Game(questions)
        val nextQuestion = game.getNextQuestion()

        Assert.assertSame(firstQuestion,nextQuestion)
    }

    @Test
    fun whenGettingNextQuestion_withoutMoreQuestions_shouldReturnNull(){
        val game=Game(emptyList())
        val nextQuestion = game.getNextQuestion()

        Assert.assertNull(nextQuestion)
    }

    @Test
    fun whenAnswering_shouldDelegateToQuestion(){
        val question = mock<Question>()

        val game = Game(listOf(question))
        game.answer(question,"OPTION")

        verify(question).answer(eq("OPTION"))
    }

    @Test
    fun whenAnsweringCorrectly_shouldIncrementCurrentScore() {
        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(true)
        val score = mock<Score>()
        val game = Game(listOf(question), score)
        game.answer(question, "OPTION")
        verify(score).increment()
    }

    @Test
    fun whenAnsweringIncorrectly_shouldNotIncrementCurrentScore() {
        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(false)
        val score = mock<Score>()
        val game = Game(listOf(question), score)
        game.answer(question, "OPTION")
        verify(score, never()).increment()
    }

}