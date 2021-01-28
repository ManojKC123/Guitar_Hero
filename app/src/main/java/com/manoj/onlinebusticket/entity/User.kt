package com.manoj.onlinebusticket.entity

import android.location.Address
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    var name: String? = null,
    var mobile: String? = null,
    var address: String? = null,
    var mailID: String? = null,
    var password: String? = null
){
    @PrimaryKey(autoGenerate = true)
    var userID : Int = 0
}