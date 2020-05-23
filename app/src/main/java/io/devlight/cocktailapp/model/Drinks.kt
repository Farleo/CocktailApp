package io.devlight.cocktailapp.model

import android.os.Parcel
import android.os.Parcelable


data class Drinks (val idDrink: Int,
                      val strDrink: String?,
                      val strDrinkThumb: String?,
                      val strCategory: String?,
                      val strAlcoholic: String?,
                      val strGlass: String?,
                      val strInstructions: String?,
                      val dateModified: String? = null,
                      val strIngredient1: String? = null,
                      val strMeasure1: String? = null,
                      val strIngredient2: String? = null,
                      val strMeasure2: String? = null,
                      val strIngredient3: String? = null,
                      val strMeasure3: String? = null,
                      val strIngredient4: String? = null,
                      val strMeasure4: String? = null,
                      val strIngredient5: String? = null,
                      val strMeasure5: String? = null,
                      val strIngredient6: String? = null,
                      val strMeasure6: String? = null,
                      val strIngredient7: String? = null,
                      val strMeasure7: String? = null,
                      val strIngredient8: String? = null,
                      val strMeasure8: String? = null,
                      val strIngredient9: String? = null,
                      val strMeasure9: String? = null,
                      val strIngredient10: String? = null,
                      val strMeasure10: String? = null,
                      val strIngredient11: String? = null,
                      val strMeasure11: String? = null,
                      val strIngredient12: String? = null,
                      val strMeasure12: String? = null,
                      val strIngredient13: String? = null,
                      val strMeasure13: String? = null,
                      val strIngredient14: String? = null,
                      val strMeasure14: String? = null,
                      val strIngredient15: String? = null,
                      val strMeasure15: String? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idDrink)
        parcel.writeString(strDrink)
        parcel.writeString(strDrinkThumb)
        parcel.writeString(strCategory)
        parcel.writeString(strAlcoholic)
        parcel.writeString(strGlass)
        parcel.writeString(strInstructions)
        parcel.writeString(dateModified)
        parcel.writeString(strIngredient1)
        parcel.writeString(strMeasure1)
        parcel.writeString(strIngredient2)
        parcel.writeString(strMeasure2)
        parcel.writeString(strIngredient3)
        parcel.writeString(strMeasure3)
        parcel.writeString(strIngredient4)
        parcel.writeString(strMeasure4)
        parcel.writeString(strIngredient5)
        parcel.writeString(strMeasure5)
        parcel.writeString(strIngredient6)
        parcel.writeString(strMeasure6)
        parcel.writeString(strIngredient7)
        parcel.writeString(strMeasure7)
        parcel.writeString(strIngredient8)
        parcel.writeString(strMeasure8)
        parcel.writeString(strIngredient9)
        parcel.writeString(strMeasure9)
        parcel.writeString(strIngredient10)
        parcel.writeString(strMeasure10)
        parcel.writeString(strIngredient11)
        parcel.writeString(strMeasure11)
        parcel.writeString(strIngredient12)
        parcel.writeString(strMeasure12)
        parcel.writeString(strIngredient13)
        parcel.writeString(strMeasure13)
        parcel.writeString(strIngredient14)
        parcel.writeString(strMeasure14)
        parcel.writeString(strIngredient15)
        parcel.writeString(strMeasure15)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Drinks> {
        override fun createFromParcel(parcel: Parcel): Drinks {
            return Drinks(parcel)
        }

        override fun newArray(size: Int): Array<Drinks?> {
            return arrayOfNulls(size)
        }
    }
}
