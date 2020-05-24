package io.devlight.cocktailapp.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.devlight.cocktailapp.R
import io.devlight.cocktailapp.adapter.IngredientsAdapter
import io.devlight.cocktailapp.model.Drinks
import io.devlight.cocktailapp.model.Ingredient
import io.paperdb.Paper


class CocktailDetailsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var ingredients: List<Ingredient>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_details)
        val intent = intent
        val drinks = intent.getParcelableExtra<Drinks>("drinks")
        title = drinks?.strDrink
        save(drinks)
        Picasso.get().load(drinks?.strDrinkThumb).into(findViewById<ImageView>(R.id.cocktailImgDetail))
        findViewById<TextView>(R.id.drinkName).apply { text = drinks?.strDrink}
        findViewById<TextView>(R.id.alcoholic).apply { text = drinks?.strAlcoholic }
        findViewById<TextView>(R.id.glass).apply { text = drinks?.strGlass }
        findViewById<TextView>(R.id.instructionsDescription).apply { text = drinks?.strInstructions }
        ingredients = getIngredients(drinks)

        viewManager = LinearLayoutManager(this)
        viewAdapter = IngredientsAdapter(this, ingredients)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_ingredients).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

    }

    private fun getIngredients (drinks: Drinks?) : List<Ingredient> {
        val list: MutableList<Ingredient> = arrayListOf()
        list.addIfExist (drinks?.strIngredient1,drinks?.strMeasure1)
        list.addIfExist(drinks?.strIngredient2,drinks?.strMeasure2)
        list.addIfExist(drinks?.strIngredient3,drinks?.strMeasure3)
        list.addIfExist(drinks?.strIngredient4,drinks?.strMeasure4)
        list.addIfExist(drinks?.strIngredient5,drinks?.strMeasure5)
        list.addIfExist(drinks?.strIngredient6,drinks?.strMeasure6)
        list.addIfExist(drinks?.strIngredient7,drinks?.strMeasure7)
        list.addIfExist(drinks?.strIngredient8,drinks?.strMeasure8)
        list.addIfExist(drinks?.strIngredient9,drinks?.strMeasure9)
        list.addIfExist(drinks?.strIngredient10,drinks?.strMeasure10)
        list.addIfExist(drinks?.strIngredient11,drinks?.strMeasure11)
        list.addIfExist(drinks?.strIngredient12,drinks?.strMeasure12)
        list.addIfExist(drinks?.strIngredient13,drinks?.strMeasure13)
        list.addIfExist(drinks?.strIngredient14,drinks?.strMeasure14)
        list.addIfExist(drinks?.strIngredient15,drinks?.strMeasure15)
        return list
    }

    private fun MutableList<Ingredient>.addIfExist(ingredientName: String?, measure: String?){
        if(!ingredientName.isNullOrBlank()) {
            this.add(Ingredient(ingredientName,measure))
        }
    }
    private fun save(newDrink: Drinks){
        Paper.init(this)
        val drinks : List<Drinks>
        drinks = Paper.book().read("drinks", ArrayList())
        val existDrink = drinks.find { d -> d.idDrink==newDrink.idDrink }
        if(existDrink==null) {
            drinks.add(0,newDrink)
        }
        Paper.book().write("drinks", drinks)
    }
}
