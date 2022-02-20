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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var charactersList = arrayListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createCharactersList()
    }

    fun createCharactersList(){

        val harryPotterService = HarryPotterService.create()

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


        })

    }

    fun configureRecyclerView(){

        val adapter = AdapterRecyclerCharacters(charactersList, applicationContext)
        val layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.setHasFixedSize(true)
        recycler_view.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayout.VERTICAL))
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter

    }
}