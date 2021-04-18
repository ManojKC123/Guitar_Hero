package com.manoj.guitar_hero_wear.api

import com.manoj.guitar_hero_wear.entity.User
import com.manoj.guitar_hero_wear.response.LoginResponse
import com.manoj.guitar_hero_wear.response.UpdateResponse
import com.manoj.guitar_hero_wear.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface UserAPI {
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