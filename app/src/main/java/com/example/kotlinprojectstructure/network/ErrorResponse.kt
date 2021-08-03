package com.example.kotlinprojectstructure.network

data class ErrorResponse(
    val data: Data,
    val meta: Meta
):Throwable(meta.message)

data class Meta(
    val message: String,
    val status_code: Int
)
class Data(
)



