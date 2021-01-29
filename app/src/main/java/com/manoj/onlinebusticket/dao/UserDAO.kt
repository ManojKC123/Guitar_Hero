package com.manoj.onlinebusticket.dao

import androidx.room.Dao
import androidx.room.Insert
import com.manoj.onlinebusticket.entity.User

@Dao
interface UserDAO {
    @Insert
    suspend fun registerUser(user: User)
}