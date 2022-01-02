package com.raywenderlich.android.cocktailsgame.common.repository

import android.content.SharedPreferences
import com.raywenderlich.android.cocktails.common.network.CocktailsApi


private const val HIGH_SCORE_KEY="HIGH_SCORE_KEY"
class CocktailsRepositoryImpl(val api:CocktailsApi,
                              val sharedPreferences: SharedPreferences)
                              :CocktailsRepository {

    override fun saveHighScore(score: Int) {
        val editor=sharedPreferences.edit()
        editor.putInt(HIGH_SCORE_KEY,score)
        editor.apply()
    }

    override fun getHighScore(): Int {
       return sharedPreferences.getInt(HIGH_SCORE_KEY,0)
    }

}