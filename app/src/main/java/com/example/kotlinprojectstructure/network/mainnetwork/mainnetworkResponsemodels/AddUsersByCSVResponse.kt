package com.example.kotlinprojectstructure.network.mainnetwork.mainnetworkResponsemodels

data class AddUsersByCSVResponse(
    val data: DataAddUsersByCSVResponse,
    val meta: MetaAddUsersByCSVResponse
)
data class DataAddUsersByCSVResponse(
    val total_users: Int,
    val inserted_users: Int,
    val failed_users: Int,
    val successfully_insertion_products: ArrayList<SuccessFullyInsertionUsers>,
    val failed_insertion_products: ArrayList<FailedInsertionUsers>

)
data class SuccessFullyInsertionUsers(
    val user_id: Int,
    val user_name: String
)
data class FailedInsertionUsers(
    val user_id: Int,
    val user_name: String
)
data class MetaAddUsersByCSVResponse(
    val message: String,
    val status_code: Int
)