package io.devlight.cocktailapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkService {
    private var retrofit: Retrofit? = null
    private val instance: Retrofit
        get() {
            if (retrofit == null) {

                val url = "https://www.thecocktaildb.com/"
                retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

    fun getJSONApi(): TheCocktailDbApi {
        return instance.create(TheCocktailDbApi::class.java)
    }

}