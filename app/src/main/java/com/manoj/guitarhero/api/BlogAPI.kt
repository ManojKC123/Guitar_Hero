package com.manoj.guitarhero.api

import com.manoj.guitarhero.response.AllBlogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface BlogAPI {
    //get all students
    @GET("/blog/fetch")
    suspend fun getAllBlogs(
        @Header("Authorization") token : String,
    ): Response<AllBlogsResponse>

    @GET("/blog/fetch/:id")
    suspend fun getSingleBlog(
        @Header("Authorization") token : String,
    ): Response<AllBlogsResponse>
}