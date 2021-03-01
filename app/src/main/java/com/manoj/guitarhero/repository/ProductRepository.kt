package com.manoj.guitarhero.repository

import com.manoj.guitarhero.api.MyApiRequest
import com.manoj.guitarhero.api.ProductAPI
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.response.AllProductsResponse
import okhttp3.MultipartBody

class ProductRepository : MyApiRequest(){
    private val productAPI = ServiceBuilder.buildService(ProductAPI::class.java)


    suspend fun getAllProducts(): AllProductsResponse{
        return apiRequest {
            productAPI.getAllProducts(
                    ServiceBuilder.token!!
            )
        }
    }

}