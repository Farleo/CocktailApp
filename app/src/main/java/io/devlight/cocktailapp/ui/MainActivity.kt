package io.devlight.cocktailapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.devlight.cocktailapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun search(view : View){
        val searchIntent = Intent (this, SearchActivity::class.java)
        startActivity(searchIntent)
    }
}