package com.manoj.guitarhero.response

import com.manoj.guitarhero.entity.Product

data class AllProductsResponse (
        val success: Boolean?=true,
        val count: Int? = 0,
        val data : ArrayList<Product>? = null )
