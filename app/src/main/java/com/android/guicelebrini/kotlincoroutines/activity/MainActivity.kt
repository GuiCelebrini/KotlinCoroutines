package com.android.guicelebrini.kotlincoroutines.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.guicelebrini.kotlincoroutines.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}