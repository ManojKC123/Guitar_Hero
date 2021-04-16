package com.manoj.guitarhero.repository


import com.manoj.guitarhero.api.BlogAPI
import com.manoj.guitarhero.api.MyApiRequest
import com.manoj.guitarhero.api.ProductAPI
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.response.AllBlogsResponse
import okhttp3.MultipartBody

class BlogRepository : MyApiRequest(){
    private val productAPI = ServiceBuilder.buildService(BlogAPI::class.java)


    suspend fun getAllBlogs(): AllBlogsResponse{
        return apiRequest {
            productAPI.getAllBlogs(
                ServiceBuilder.token!!
            )
        }
    }

}