package com.manoj.guitarhero.repository

import com.manoj.guitarhero.api.MyApiRequest
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.api.UserAPI
import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.response.LoginResponse

class UserRepository: MyApiRequest() {

    private val userAPI =
            ServiceBuilder.buildService(UserAPI::class.java)

    //register User

    suspend fun registerUser(user: User):LoginResponse{
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    //login user
    suspend fun checkUser(username:String,password:String):LoginResponse{
        return apiRequest {
            userAPI.checkUser(username,password)
        }
    }

}