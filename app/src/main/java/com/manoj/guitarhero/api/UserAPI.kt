package com.manoj.guitarhero.api

import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.response.LoginResponse
import com.manoj.guitarhero.response.RegisterResponse
import com.manoj.guitarhero.response.UpdateResponse
import com.manoj.guitarhero.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface UserAPI {
    //    Register USer
    @POST("user/insert")
    suspend fun registerUser(
        @Body user: User
    ) : Response<RegisterResponse>


    //Login user
    @FormUrlEncoded
    @POST("user/login")
    suspend fun checkUser(
            @Field("email") username : String,
            @Field("password") password : String
    ): Response<LoginResponse>

    //update user details
    @PUT("/user/update")
    suspend fun updateUser(
        @Header("Authorization") token: String,
        @Body user: User
    ): Response<UpdateResponse>

    //get user details
    @GET("/profile")
    suspend fun getUser(
        @Header("Authorization") token: String,
    ): Response<UserResponse>
}