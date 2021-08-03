package com.example.kotlinprojectstructure.network

import com.google.gson.Gson
import okhttp3.ResponseBody

class ErrorHandling {

    companion object {
        fun parseError(response: ResponseBody?): ErrorResponse {
            val gson = Gson()
            return gson.fromJson<ErrorResponse>(
                response?.string(),
                ErrorResponse::class.java
            )
        }
    }
}