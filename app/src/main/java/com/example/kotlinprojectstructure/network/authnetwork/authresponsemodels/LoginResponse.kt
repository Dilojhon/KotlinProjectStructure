package com.example.kotlinprojectstructure.network.authnetwork.authresponsemodels

data class LoginResponse(
    val data: DataLoginResponse,
    val meta: MetaLoginResponse
)
data class DataLoginResponse(
    val token: String
)
data class MetaLoginResponse(
    val message: String,
    val status_code: Int
)