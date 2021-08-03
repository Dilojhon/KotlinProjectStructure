package com.example.kotlinprojectstructure.utils.extentions

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kotlinprojectstructure.R

fun ImageView.loadImage(url: String?) {
    Glide.with(context).load(url).placeholder(R.drawable.profile_picture_placeholder).into(this)
}
fun ImageView.loadImageFromUri(uri: Uri?) {
    Glide.with(context).load(uri).placeholder(R.drawable.profile_picture_placeholder).into(this)
}