package com.manoj.guitarhero.api

import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {
    //    Register USer
    @FormUrlEncoded
    @POST("auth/register")
    suspend fun registerUser(
        @Body user: User
    ) : Response<LoginResponse>


    //    Login User
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun loginUser(
        @Field("username") username:String,
        @Field("username") password:String
    ): Response<LoginResponse>
}