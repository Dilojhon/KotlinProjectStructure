package com.example.kotlinprojectstructure.network.authnetwork.authresponsemodels

data class SignUpResponse (
    val data: DataSignUpResponse,
    val meta: MetaSignUpResponse
)
data class DataSignUpResponse(
    val token: String
)
data class MetaSignUpResponse(
    val message: String,
    val status_code: Int
)