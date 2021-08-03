package com.example.kotlinprojectstructure.utils.extentions

import android.app.Activity
import android.content.Intent

fun Intent.startNewActivity(parent: Activity) {
    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    parent.startActivity(this)
}