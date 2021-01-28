package com.manoj.onlinebusticket.dao

import androidx.room.Insert
import com.manoj.onlinebusticket.entity.User

interface UserDAO {
    @Insert
    suspend fun registerUser(user: User)
}