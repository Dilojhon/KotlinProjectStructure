package com.example.kotlinprojectstructure.utils.validations

import android.widget.EditText
import android.widget.Spinner

interface OnFormValidationListener {
    fun onValidated()
    fun onNotValidated(
        editText: EditText, error: String
    )
}