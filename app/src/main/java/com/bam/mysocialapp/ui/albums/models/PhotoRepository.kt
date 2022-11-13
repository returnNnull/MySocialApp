package com.bam.mysocialapp.ui.albums.models

import androidx.lifecycle.MutableLiveData
import com.bam.mysocialapp.ui.albums.PhotoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepository (private val photoApi: PhotoApi) {

    private val photos: MutableLiveData<List<Photo>?> = MutableLiveData()


    fun getAll(): MutableLiveData<List<Photo>?>{
        photoApi.getAll().enqueue(object : Callback<List<Photo>>{
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val result = response.body()
                photos.value = result
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                print("")
            }

        })
        return photos
    }

}