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

    private var _binding: FragmentPostsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PostListAdapter()
        binding.postsListRecyclerView.adapter = adapter
        val postsViewModel = ViewModelProvider(this)[PostsViewModel::class.java]
        postsViewModel.posts.observe(requireActivity()) {
            if (it != null) {
                adapter.items = it
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}