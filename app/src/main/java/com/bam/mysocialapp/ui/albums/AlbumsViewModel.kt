package com.bam.mysocialapp.ui.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bam.mysocialapp.ui.albums.models.Photo
import com.bam.mysocialapp.ui.albums.models.PhotoRepository
import com.bam.mysocialapp.ui.posts.restapi.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumsViewModel : ViewModel() {

    private val photoApi: PhotoApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        photoApi = retrofit.create(PhotoApi::class.java)
    }


    private val photoRepository = PhotoRepository(photoApi)

    val photos: MutableLiveData<List<Photo>?> = photoRepository.getAll()


}