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
    @POST("user/insert")
    suspend fun registerUser(
        @Body user: User
    ) : Response<LoginResponse>


    //Login user
    @FormUrlEncoded
    @POST("user/login")
    suspend fun checkUser(
            @Field("email") username : String,
            @Field("password") password : String
    ): Response<LoginResponse>
}