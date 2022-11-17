package com.bam.mysocialapp.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bam.mysocialapp.databinding.FragmentPostsBinding
import com.bam.mysocialapp.ui.posts.adapters.PostListAdapter
import com.bam.mysocialapp.ui.posts.models.Post

class PostsFragment : Fragment() {

    private lateinit var _binding: FragmentPostsBinding
    private lateinit var viewModel: PostsViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PostListAdapter()
        adapter.itemClick {

        }

        _binding.postsListRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[PostsViewModel::class.java]
        viewModel.posts.observe(requireActivity()) {
           if (it != null) {
                adapter.items = it
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.saveInCache()
    }
}