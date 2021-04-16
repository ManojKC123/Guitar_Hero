package com.manoj.guitarhero.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manoj.guitarhero.entity.Product
import com.manoj.guitarhero.model.ProductItem


@Dao
    interface ProductDAO {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(products: List<ProductItem>)

        @Query("select * from ProductItem")
        suspend fun getallProduct() : List<ProductItem>

        @Query("SELECT * FROM ProductItem where productModel = :productModel")
        suspend fun getProduct(productModel: String): ProductItem
    }