package com.bam.mysocialapp.ui.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bam.mysocialapp.ui.posts.models.Post
import com.bam.mysocialapp.ui.posts.restapi.PostService
import com.bam.mysocialapp.ui.posts.models.PostsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsViewModel() : ViewModel() {


    private val postService: PostService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postService = retrofit.create(PostService::class.java)
    }

    private val postsRepository = PostsRepository(postService)

   var posts: MutableLiveData<List<Post>?> = postsRepository.getAll()



}