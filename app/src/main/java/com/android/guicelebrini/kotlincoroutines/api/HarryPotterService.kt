package com.android.guicelebrini.kotlincoroutines.api

import com.android.guicelebrini.kotlincoroutines.model.Character
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HarryPotterService {

    @GET("characters")
    fun getCharacters() : Call<ArrayList<Character>>

    /*companion object{

        fun create() : HarryPotterService{

            val retrofit = Retrofit.Builder().baseUrl("http://hp-api.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            return retrofit.create(HarryPotterService::class.java)
        }

    }*/

}