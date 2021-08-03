package com.example.kotlinprojectstructure.utils.extentions

import android.widget.EditText


fun EditText.getString(): String {
    return this.text.toString().trim()
}

fun EditText.getInt(): Int {
    return this.text.toString().trim().toInt()
}