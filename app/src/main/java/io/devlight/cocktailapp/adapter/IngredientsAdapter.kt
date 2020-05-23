package io.devlight.cocktailapp.adapter
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.devlight.cocktailapp.model.Ingredient


internal class IngredientsAdapter(
    private var context: Context?,
    private val ingredients: List<Ingredient>
) : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {
    private val inflater: LayoutInflater
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val mInflater = (context as Activity).layoutInflater
        val view: View = mInflater.inflate(io.devlight.cocktailapp.R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val ingredient = ingredients[position]
        holder.idView.text = (position + 1).toString()
        holder.nameView.text = ingredient.strIngredient
        holder.measuareView.text = ingredient.strMeasure
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    inner class ViewHolder internal constructor(view: View) :
        RecyclerView.ViewHolder(view) {
        val idView: TextView
        val nameView: TextView
        val measuareView: TextView

        init {
            idView = view.findViewById<View>(io.devlight.cocktailapp.R.id.drinkIngredientId) as TextView
            nameView = view.findViewById<View>(io.devlight.cocktailapp.R.id.drinkIngredientName) as TextView
            measuareView = view.findViewById<View>(io.devlight.cocktailapp.R.id.drinkIngredientMeasure) as TextView
        }
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}