package com.bam.mysocialapp.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.bam.mysocialapp.ui.posts.models.Post

@Dao
interface PostEntityDao {
    @Query("select * from Post")
    suspend fun getAll():List<Post>


    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: Post)

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: List<Post>)

}