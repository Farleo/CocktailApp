package io.devlight.cocktailapp.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.devlight.cocktailapp.R
import io.devlight.cocktailapp.api.NetworkService
import io.devlight.cocktailapp.api.TheCocktailDbApi
import io.devlight.cocktailapp.model.CocktailSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchActivity : AppCompatActivity() {
    private lateinit var jsonApi: TheCocktailDbApi
    var drinks: MutableList<String> = ArrayList()
    private lateinit var gridView: GridView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        jsonApi = NetworkService.getJSONApi()
        this.gridView = findViewById(R.id.gridView)
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks)
        gridView.adapter = arrayAdapter
        val editText = findViewById<EditText>(R.id.search_field)
        editText.addTextChangedListener(object : SearchTextWatcher() {
            override fun onSearch(text: String) {
                search(text)
            }
        })
    }
    fun search(searchTag: String) {
        val request = jsonApi.searchCocktails(searchTag)
        request.enqueue(object : Callback<CocktailSearchResponse> {
            override fun onResponse(call: Call<CocktailSearchResponse>, response: Response<CocktailSearchResponse>) {
                val result = response.body()!!.drinks.map { it.strDrink}
                drinks.clear()
                drinks.addAll(result.toMutableList())
            }

            override fun onFailure(call: Call<CocktailSearchResponse>, t: Throwable) {
                val toast = Toast.makeText(
                    applicationContext,
                    t.message, Toast.LENGTH_SHORT
                )
                toast.show()
            }
        })
    }
}
