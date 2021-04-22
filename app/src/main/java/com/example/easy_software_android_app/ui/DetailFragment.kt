package com.example.easy_software_android_app.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.easy_software_android_app.*
import com.example.easy_software_android_app.databinding.FragmentDetailBinding
import com.example.easy_software_android_app.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailFragment: Fragment(R.layout.fragment_detail) {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var myAdapter: UserAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    private val args:DetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentDetailBinding.bind(view)

        Glide.with(this.requireContext())
            .load(args.currentUser.avatar).into(binding.bigImage)

        binding.name.text = args.currentUser.name
        binding.createdAt.text = args.currentUser.username
        binding.email.text = args.currentUser.email
        binding.phone.text = args.currentUser.phoneNumber
        binding.navigate.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToEditlFragment(args.currentUser))
        }
    }
}

























