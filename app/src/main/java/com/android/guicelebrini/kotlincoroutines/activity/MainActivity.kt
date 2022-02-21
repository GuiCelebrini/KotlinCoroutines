package com.android.guicelebrini.kotlincoroutines.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.guicelebrini.kotlincoroutines.R
import com.android.guicelebrini.kotlincoroutines.adapter.AdapterRecyclerCharacters
import com.android.guicelebrini.kotlincoroutines.api.HarryPotterService
import com.android.guicelebrini.kotlincoroutines.model.Character
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var charactersList = arrayListOf<Character>()
    lateinit var service: HarryPotterService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureRetrofit()

        getCharactersList()
    }

    fun configureRetrofit(){
        service = Retrofit.Builder().baseUrl("http://hp-api.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryPotterService::class.java)
    }

    fun getCharactersList(){
        
        CoroutineScope(Dispatchers.IO).launch {
            val characters = service.getCharacters().await()

            withContext(Dispatchers.Main){
                characters?.let { charactersList = it }
                configureRecyclerView(charactersList)
            }

        }

        /*val harryPotterService = HarryPotterService.create()

        harryPotterService.getCharacters().enqueue(object : Callback<ArrayList<Character>>{
            override fun onResponse(call: Call<ArrayList<Character>>, response: Response<ArrayList<Character>>) {
                if (response.isSuccessful){
                    charactersList = response.body()!!
                    configureRecyclerView()
                }
            }

            override fun onFailure(call: Call<ArrayList<Character>>, t: Throwable) {
                Log.e("Erro", "onFailure: ${t.message}", )
            }


        })*/

    }

    fun configureRecyclerView(characters: ArrayList<Character>){

        val adapter = AdapterRecyclerCharacters(characters, applicationContext)
        val layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.setHasFixedSize(true)
        recycler_view.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayout.VERTICAL))
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter

    }
}