package com.manoj.guitarhero.repository

import android.provider.SyncStateContract.Helpers.update
import com.manoj.guitarhero.api.MyApiRequest
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.api.UserAPI
import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.response.LoginResponse
import com.manoj.guitarhero.response.RegisterResponse
import com.manoj.guitarhero.response.UpdateResponse
import com.manoj.guitarhero.response.UserResponse

class UserRepository: MyApiRequest() {

    private val userAPI =
            ServiceBuilder.buildService(UserAPI::class.java)

    //register User

    suspend fun registerUser(user: User):RegisterResponse{
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