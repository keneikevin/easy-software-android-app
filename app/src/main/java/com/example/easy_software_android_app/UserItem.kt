package com.example.easy_software_android_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class UserItem(
    val avatar: String,
    val createdAt: String,
    val `data`: @RawValue Data,
    var email: String,
    val id: String,
    var name: String,
    var phoneNumber: String,
    val username: String
):Parcelable