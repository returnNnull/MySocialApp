package com.bam.mysocialapp.ui.posts

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.bam.mysocialapp.db.DbConnection
import com.bam.mysocialapp.db.PostEntityDao
import com.bam.mysocialapp.ui.posts.models.Post
import com.bam.mysocialapp.ui.posts.restapi.PostService
import com.bam.mysocialapp.ui.posts.models.PostsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Flow

class PostsViewModel(application: Application) : AndroidViewModel(application) {


    private val postService: PostService
    private val postEntityDao: PostEntityDao
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postService = retrofit.create(PostService::class.java)

        postEntityDao = DbConnection.getDatabase(application.applicationContext).dao();
    }

    private val postsRepository = PostsRepository(postService, postEntityDao)



    var posts: MutableLiveData<List<Post>?> = MutableLiveData()
    init {
        viewModelScope.launch {
            postsRepository.getAll().collectLatest {
                posts.value = it
            }
        }
    }

    fun saveInCache(){
        viewModelScope.launch {
            posts.value?.let { postEntityDao.insert(it) }
        }
    }



}