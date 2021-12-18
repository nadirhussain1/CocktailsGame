package com.raywenderlich.android.cocktailsgame

import org.junit.Assert
import org.junit.Test

class GameUnitTests {

    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore(){
        val game = Game()
        game.incrementScore()

        Assert.assertEquals(1,game.currentScore)
    }

    @Test
    fun whenIncrementingScore_shouldIncrementHighestScore(){
        val game=Game()
        game.incrementScore()

        Assert.assertEquals(1,game.highestScore)
    }

    @Test
    fun whenIncrementingScore_belowHighestScore_shouldNotIncrementHighestScore(){
        val game=Game(10)
        game.incrementScore()

        Assert.assertEquals(10,game.highestScore)
    }
}