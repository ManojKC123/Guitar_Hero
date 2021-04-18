package com.manoj.guitar_hero_wear.dao

import androidx.room.Dao
import androidx.room.Query
import com.manoj.guitar_hero_wear.entity.User

@Dao
interface UserDAO {
    @Query("select * from User where email=(:username) and password=(:password)")
    suspend fun checkUser(username: String, password: String): User
}
