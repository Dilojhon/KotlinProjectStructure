package com.example.kotlinprojectstructure.network.authnetwork.authresponsemodels

data class LogoutResponse(
    val data: DataLogoutResponse,
    val meta: MetaLogoutResponse
)
class DataLogoutResponse(
)
data class MetaLogoutResponse(
    val message: String,
    val status_code: Int
)