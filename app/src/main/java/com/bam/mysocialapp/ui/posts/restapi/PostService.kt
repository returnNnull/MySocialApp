package com.bam.mysocialapp.ui.posts.restapi

import com.bam.mysocialapp.ui.posts.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts/")
    fun getAll(): Call<List<Post>>
}