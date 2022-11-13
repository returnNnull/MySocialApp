package com.bam.mysocialapp.ui.albums

import com.bam.mysocialapp.ui.albums.models.Photo
import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi {

    @GET("photos/")
    fun getAll(): Call<List<Photo>>
}