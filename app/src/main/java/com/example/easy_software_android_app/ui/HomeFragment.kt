package com.example.easy_software_android_app.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easy_software_android_app.*
import com.example.easy_software_android_app.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var myAdapter: UserAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentHomeBinding.bind(view)

        binding.txt.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.txt.layoutManager = linearLayoutManager


        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<UserItem>?> {
            override fun onResponse(
                call: Call<List<UserItem>?>,
                response: Response<List<UserItem>?>
            ) {val responseBody = response.body()!!
        myAdapter = UserAdapter(responseBody)
                myAdapter.notifyDataSetChanged()
                binding.txt.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<UserItem>?>, t: Throwable) {

            }
        })

}}

























