package com.example.kotlinprojectstructure.network.mainnetwork.mainnetworkResponsemodels

data class UploadImagesResponse(
    val data: DataUploadImagesResponse,
    val meta: MetaUploadImagesResponse
)

data class DataUploadImagesResponse(
    val images_urls: ArrayList<UsersImageUploadImagesResponse>
)

data class UsersImageUploadImagesResponse(
    val url: String
)

data class MetaUploadImagesResponse(
    val message: String,
    val status_code: Int
)