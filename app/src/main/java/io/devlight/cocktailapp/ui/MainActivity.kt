package io.devlight.cocktailapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.devlight.cocktailapp.R
import io.devlight.cocktailapp.adapter.DrinkSearchViewAdapter
import io.devlight.cocktailapp.model.Drinks
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {
    private lateinit var drinks: MutableList<Drinks>
    private lateinit var adapter: DrinkSearchViewAdapter
    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showHistory()
    }

    override fun onRestart() {
        super.onRestart()
        showHistory()
    }

    fun search(view : View){
        val searchIntent = Intent (this, SearchActivity::class.java)
        startActivity(searchIntent)
    }

    private fun getPaperDB(): MutableList<Drinks>{
        Paper.init(this)
        drinks = Paper.book().read("drinks", ArrayList())
        return drinks
    }

    private fun showHistory(){
        adapter = DrinkSearchViewAdapter(this, getPaperDB())
        this.gridView = findViewById(R.id.gridView)
        gridView.adapter = adapter
        if(!drinks.isNullOrEmpty()){
            findViewById<TextView>(R.id.history).apply { text = "" }
        }
        gridView.setOnItemClickListener { parent, view, position, id ->
            intent = Intent(this, CocktailDetailsActivity::class.java)
            intent.putExtra("drinks", drinks[position])
            this.startActivity(intent)
        }
    }
}