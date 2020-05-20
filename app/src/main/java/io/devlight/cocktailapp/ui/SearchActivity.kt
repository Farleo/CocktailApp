package io.devlight.cocktailapp.ui

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.devlight.cocktailapp.R
import io.devlight.cocktailapp.api.NetworkService
import io.devlight.cocktailapp.api.TheCocktailDbApi
import io.devlight.cocktailapp.model.CocktailSearchResponse
import io.devlight.cocktailapp.model.Drinks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchActivity : AppCompatActivity() {
    private lateinit var jsonApi: TheCocktailDbApi
    var drinks: MutableList<Drinks> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        jsonApi = NetworkService.getJSONApi()

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
                drinks.addAll(response.body()!!.drinks)
            }

            override fun onFailure(call: Call<CocktailSearchResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
