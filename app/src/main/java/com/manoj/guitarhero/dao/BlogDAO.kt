package com.manoj.guitarhero.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manoj.guitarhero.model.BlogItem
import com.manoj.guitarhero.model.ProductItem

@Dao
interface BlogDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogs: List<BlogItem>)

    @Query("select * from BlogItem")
    suspend fun getallBlog() : List<BlogItem>

    @Query("SELECT * FROM BlogItem where title = :title")
    suspend fun getBlog(title: String): BlogItem
}