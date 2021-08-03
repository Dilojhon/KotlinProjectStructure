package com.example.kotlinprojectstructure.network.mainnetwork.mainnetworkResponsemodels

data class SearchResponse(
    val data: DataSearchResponse,
    val meta: MetaSearchResponse
)
data class DataSearchResponse(
    val users: ArrayList<UsersSearchResponse>,
)
data class UsersSearchResponse(
    val user_id: Int,
    val user_name: Int,
    val user_image_url: String
)

data class MetaSearchResponse(
    val message: String,
    val status_code: Int
)