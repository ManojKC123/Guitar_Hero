package com.manoj.guitarhero.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["productModel"], unique = true)])
    data class ProductItem (
            @PrimaryKey(autoGenerate= true)
            var id: Int = 0,

            @ColumnInfo(name = "productModel")
            var productModel: String? = null,

            @ColumnInfo(name = "productDescription")
            var productDescription: String? = null,

            @ColumnInfo(name = "companyName")
            var companyName: String? = null,

            @ColumnInfo(name = "UnitPrice")
            var UnitPrice: String? = null,

            @ColumnInfo(name = "color")
            var color: String? = null,

            @ColumnInfo(name = "discount")
            var discount: String? = null,

            @ColumnInfo(name = "weight")
            var weight: String? = null,

            @ColumnInfo(name = "picture")
            var picture: String? = null,


    ):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
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
                parcel.writeInt(id)
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

        companion object CREATOR : Parcelable.Creator<ProductItem> {
                override fun createFromParcel(parcel: Parcel): ProductItem {
                        return ProductItem(parcel)
                }

                override fun newArray(size: Int): Array<ProductItem?> {
                        return arrayOfNulls(size)
                }
        }
}
