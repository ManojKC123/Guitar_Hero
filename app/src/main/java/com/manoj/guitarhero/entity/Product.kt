package com.manoj.guitarhero.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product (
        @PrimaryKey
        var _id: String="",
        var productModel: String? = null,
        var productDescription: String? = null,
        var companyName: String? = null,
        var UnitPrice: Number? = null,
        var color: String? = null,
        var discount: String? = null,
        var weight: String? = null,
        var picture: String? = null
)