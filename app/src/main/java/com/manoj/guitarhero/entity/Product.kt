package com.manoj.guitarhero.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product (
        @PrimaryKey
        var _id: String="",
        var productModel: String? = null,
        var productDescription: String? = null,
        var companyName: String? = null,
        var UnitPrice: String? = null,
        var color: String? = null,
        var discount: String? = null,
        var weight: String? = null,
        var picture: String? = null
):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString()!!,
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
                parcel.writeString(_id)
                parcel.writeString(productModel)
                parcel.writeString(productDescription)
                parcel.writeString(companyName)
                parcel.writeString(UnitPrice)
                parcel.writeString(color)
                parcel.writeString(discount)
                parcel.writeString(weight)
                parcel.writeString(picture)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Product> {
                override fun createFromParcel(parcel: Parcel): Product {
                        return Product(parcel)
                }

                override fun newArray(size: Int): Array<Product?> {
                        return arrayOfNulls(size)
                }
        }
}