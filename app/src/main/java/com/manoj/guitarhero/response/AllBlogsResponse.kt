package com.manoj.guitarhero.response

import com.manoj.guitarhero.entity.Blog

data class AllBlogsResponse (
    val success: Boolean?=true,
    val count: Int? = 0,
    val data : ArrayList<Blog>? = null )