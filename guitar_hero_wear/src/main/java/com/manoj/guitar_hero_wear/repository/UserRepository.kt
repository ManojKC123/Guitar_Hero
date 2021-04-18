package com.manoj.guitar_hero_wear.repository

import com.manoj.guitar_hero_wear.api.MyApiRequest
import com.manoj.guitar_hero_wear.api.ServiceBuilder
import com.manoj.guitar_hero_wear.api.UserAPI
import com.manoj.guitar_hero_wear.entity.User
import com.manoj.guitar_hero_wear.response.LoginResponse
import com.manoj.guitar_hero_wear.response.UpdateResponse
import com.manoj.guitar_hero_wear.response.UserResponse

class UserRepository: MyApiRequest() {

    private val userAPI =
            ServiceBuilder.buildService(UserAPI::class.java)

    //login user
    suspend fun checkUser(username:String,password:String): LoginResponse {
        return apiRequest {
            userAPI.checkUser(username,password)
        }
    }


    //get User Details
    suspend fun getUser(): UserResponse {
        return apiRequest {
            userAPI.getUser(
                    ServiceBuilder.token!!
            )
        }
    }

    //UPDATE USER
    suspend fun updateUser(user: User): UpdateResponse {
        return apiRequest {
            userAPI.updateUser(
                ServiceBuilder.token!!,user
            )
        }
    }
}