package com.raywenderlich.android.cocktailsgame.common.repository

interface CocktailsRepository {
    fun saveHighScore(score:Int)
    fun getHighScore():Int
}