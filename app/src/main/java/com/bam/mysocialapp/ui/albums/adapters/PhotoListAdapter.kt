package com.bam.mysocialapp.ui.albums.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bam.mysocialapp.R
import com.bam.mysocialapp.databinding.AlbumListItemBinding
import com.bam.mysocialapp.ui.albums.models.Photo
import com.squareup.picasso.Picasso

class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    var items: List<Photo> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (Photo) -> Unit = {}
    fun itemClick(listener: (Photo) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url  = items[position].url
        val view = holder.binding.image
        Picasso.get().load(url).into(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = AlbumListItemBinding.bind(view)

    }
}