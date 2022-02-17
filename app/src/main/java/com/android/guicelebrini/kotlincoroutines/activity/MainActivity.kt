package com.android.guicelebrini.kotlincoroutines.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.guicelebrini.kotlincoroutines.R
import com.android.guicelebrini.kotlincoroutines.model.Character

class MainActivity : AppCompatActivity() {

    val charactersList = arrayListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}