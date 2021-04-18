package com.manoj.guitar_hero_wear.repository

import com.manoj.guitar_hero_wear.api.MyApiRequest
import com.manoj.guitar_hero_wear.api.ServiceBuilder
import com.manoj.guitar_hero_wear.api.UserAPI
import com.manoj.guitar_hero_wear.response.LoginResponse

class UserRepository: MyApiRequest() {

    private val userAPI =
            ServiceBuilder.buildService(UserAPI::class.java)

    //login user
    suspend fun checkUser(username:String,password:String): LoginResponse {
        return apiRequest {
            userAPI.checkUser(username,password)
        }
    }
}