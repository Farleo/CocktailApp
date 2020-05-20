package io.devlight.cocktailapp.api

import io.devlight.cocktailapp.model.CocktailSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


public interface TheCocktailDbApi {
    @GET("/api/json/v1/1/search.php")
    fun searchCocktails(@Query("s") searchText: String): Call<CocktailSearchResponse>

}