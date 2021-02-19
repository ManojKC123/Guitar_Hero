package com.manoj.guitarhero.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey
    var _id: String="",
    var firstname: String? = null,
    var lastname: String? = null,
    var phone: String? = null,
    var address: String? = null,
    var email: String? = null,
    var password: String? = null

)
//){
//    @PrimaryKey(autoGenerate = true)
//    var userID : Int = 0
//}