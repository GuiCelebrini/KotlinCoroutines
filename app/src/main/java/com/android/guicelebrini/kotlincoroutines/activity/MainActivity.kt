package com.android.guicelebrini.kotlincoroutines.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.guicelebrini.kotlincoroutines.R
import com.android.guicelebrini.kotlincoroutines.adapter.AdapterRecyclerCharacters
import com.android.guicelebrini.kotlincoroutines.model.Character
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val charactersList = arrayListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createCharactersList()

        configureRecyclerView()

    }

    fun createCharactersList(){
        charactersList.add(Character("Réuri", "Prédio", "Gordo", "https://pm1.narvii.com/6304/ec17b75745651f282db742c8de8f649a92f5a6ae_hq.jpg"))
        charactersList.add(Character("Rony", "Palmeiras", "Rústico", "https://metropolitanafm.com.br/wp-content/uploads/2021/04/Em-noite-inspiradora-de-Rony-R%C3%BAstico-Palmeiras-goleia-Independiente-del-Valle-pela-Libertadores.jpg"))
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