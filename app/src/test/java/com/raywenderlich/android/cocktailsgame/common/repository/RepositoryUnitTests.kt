package com.raywenderlich.android.cocktailsgame.common.repository

import android.content.SharedPreferences
import com.raywenderlich.android.cocktails.common.network.CocktailsApi
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*

class RepositoryUnitTests {
    private lateinit var api: CocktailsApi
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesEditor:SharedPreferences.Editor
    private lateinit var repository: CocktailsRepository

    @Before
    fun setup(){
        //Creating mock objects
        api= mock()
        sharedPreferencesEditor= mock()
        sharedPreferences = mock()

        //stubbing method
        whenever(sharedPreferences.edit())
            .thenReturn(sharedPreferencesEditor)

        repository = CocktailsRepositoryImpl(api,sharedPreferences)
    }

    @Test
    fun saveScore_shouldSaveToSharedPreferences(){
        //Saving score in repository
        val score=100
        repository.saveHighScore(score)

        //Verifying statements in exact order.
        inOrder(sharedPreferencesEditor){
            verify(sharedPreferencesEditor).putInt(any(), eq(score))
            verify(sharedPreferencesEditor).apply()
        }
    }

    @Test
    fun getScore_shouldGetFromSharedPreferences(){
        repository.getHighScore()
        verify(sharedPreferences).getInt(any(), any())
    }
}