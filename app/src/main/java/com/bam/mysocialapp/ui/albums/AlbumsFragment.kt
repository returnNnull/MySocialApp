package com.bam.mysocialapp.ui.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bam.mysocialapp.databinding.FragmentAlbumsBinding
import com.bam.mysocialapp.ui.albums.adapters.PhotoListAdapter

class AlbumsFragment : Fragment() {

    private var _binding: FragmentAlbumsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PhotoListAdapter()
        binding.albumsRecyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this)[AlbumsViewModel::class.java]
        viewModel.photos.observe(requireActivity()){
            if (it != null){
                adapter.items = it
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}