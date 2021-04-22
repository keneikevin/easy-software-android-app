package com.example.easy_software_android_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.easy_software_android_app.databinding.ItemUserBinding
import com.example.easy_software_android_app.ui.HomeFragment
import com.example.easy_software_android_app.ui.HomeFragmentDirections

class UserAdapter (val userList: List<UserItem>): RecyclerView.Adapter<UserAdapter.ShoppingViewHolder>() {
    private lateinit var binding: ItemUserBinding
    class ShoppingViewHolder(binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        val tvName= binding.tvName
        val tvSize =binding.tvEmail
        val image = binding.ivAvatar
        val tvNumber = binding.tvNumber
    }

    private val diffCallback = object : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var useitems: List<UserItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val userItem = userList[position]
        holder.apply {
            Glide.with(itemView).setDefaultRequestOptions(
                RequestOptions()
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.img_avatar)
                .diskCacheStrategy(DiskCacheStrategy.DATA))
                .load(userItem.avatar).into(image)

            itemView.setOnClickListener {
                val directions= HomeFragmentDirections.actionHomeFragmentToDetailFragment2(userItem)
                it.findNavController().navigate(directions)
            }

            tvName.text = userItem.name
            tvSize.text = userItem.email
            tvNumber.text = userItem.phoneNumber

        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}














