package com.example.easy_software_android_app.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.easy_software_android_app.*
import com.example.easy_software_android_app.databinding.FragmentDetailBinding
import com.example.easy_software_android_app.databinding.FragmentEditBinding
import com.example.easy_software_android_app.databinding.FragmentHomeBinding
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditlFragment: Fragment(R.layout.fragment_edit) {
    private lateinit var binding: FragmentEditBinding
    private lateinit var myAdapter: UserAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    private val args:EditlFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentEditBinding.bind(view)
        binding.btnApplyChanges.text = args.current.username
        putMethod()
        binding.btnApplyChanges.setOnClickListener {


        findNavController().popBackStack()
        }

    }
    private fun putMethod() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitdata = retrofitBuilder.putUserRequest()
          }


}

























