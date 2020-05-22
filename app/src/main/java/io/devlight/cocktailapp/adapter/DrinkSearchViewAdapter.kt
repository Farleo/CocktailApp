package io.devlight.cocktailapp.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import io.devlight.cocktailapp.R
import io.devlight.cocktailapp.model.Drinks


class CustomAdapter(private var context: Context, private var drinks: MutableList<Drinks>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var myView = convertView
        val holder: ViewHolder


        if (myView == null) {


            val mInflater = (context as Activity).layoutInflater
            myView = mInflater.inflate(R.layout.grid_item, parent, false)
            holder = ViewHolder()
            holder.mImageView = myView!!.findViewById(R.id.imageView) as ImageView
            holder.mTextView = myView.findViewById(R.id.textView) as TextView
            myView.tag = holder


        } else {

            holder = myView.tag as ViewHolder

        }
        val currentDrinks = drinks[position]

        if(currentDrinks.strDrinkThumb.isNotBlank())
        {
            Picasso.get().load(currentDrinks.strDrinkThumb).into(holder.mImageView)
        }else {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_LONG).show()
        }

        holder.mTextView!!.text = currentDrinks.strDrink

        return myView

    }

    override fun getItem(p0: Int): Any {
        return drinks[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return drinks.size
    }

    class ViewHolder {

        var mImageView: ImageView? = null
        var mTextView: TextView? = null

    }

}