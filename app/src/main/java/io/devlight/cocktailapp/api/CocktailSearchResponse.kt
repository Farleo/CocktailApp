package io.devlight.cocktailapp.api

import com.google.gson.annotations.SerializedName

data class CocktailSearchResponse (

    @SerializedName("drinks") val drinks : List<Drinks>
)