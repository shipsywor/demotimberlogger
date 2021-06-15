package com.anything

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // USAGE
        Timber.d("MainActivity created!")
        Timber.d("MainActivity TWO!")

        val jsonString = "{\"name\": \"Elvis\", \"age\": 18}"

        Timber.tag("fd").d(jsonString)

        Timber.d("NIIIIIIIIIIIIICE")
    }
}