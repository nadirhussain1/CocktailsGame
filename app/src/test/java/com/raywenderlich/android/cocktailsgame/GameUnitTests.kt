package com.raywenderlich.android.cocktailsgame

import org.junit.Assert
import org.junit.Test

class GameUnitTests {

    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore(){
        val game = Game(emptyList())
        game.incrementScore()

        Assert.assertEquals(1,game.currentScore)
    }

    @Test
    fun whenIncrementingScore_shouldIncrementHighestScore(){
        val game=Game(emptyList())
        game.incrementScore()

        Assert.assertEquals(1,game.highestScore)
    }

    @Test
    fun whenIncrementingScore_belowHighestScore_shouldNotIncrementHighestScore(){
        val game=Game(emptyList(),10)
        game.incrementScore()

        Assert.assertEquals(10,game.highestScore)
    }

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

}