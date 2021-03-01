package com.manoj.guitarhero.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manoj.guitarhero.entity.Product

interface ProductDAO {

    @Dao
    interface FutsalDAO {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(futsals: List<Product>)

        @Query("select * from Product")
        suspend fun getallFutsal() : List<Product>

        @Query("SELECT * FROM Product where productModel = :name")
        suspend fun getFutsal(name: String): Product
    }
}