package io.devlight.cocktailapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


public interface TheCocktailDbApi {
    @GET("/search.php")
    fun getPostWithID(@Query("s") searchText: String): Call<CocktailSearchResponse?>?
}