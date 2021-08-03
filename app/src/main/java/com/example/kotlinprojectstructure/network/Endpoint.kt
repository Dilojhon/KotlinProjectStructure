package com.example.kotlinprojectstructure.network

import com.example.kotlinprojectstructure.network.authnetwork.authrequestmodels.LoginRequest
import com.example.kotlinprojectstructure.network.authnetwork.authrequestmodels.SignUpRequest
import com.example.kotlinprojectstructure.network.authnetwork.authresponsemodels.LoginResponse
import com.example.kotlinprojectstructure.network.authnetwork.authresponsemodels.LogoutResponse
import com.example.kotlinprojectstructure.network.authnetwork.authresponsemodels.SignUpResponse
import com.example.kotlinprojectstructure.network.mainnetwork.mainnetworkResponsemodels.AddUsersByCSVResponse
import com.example.kotlinprojectstructure.network.mainnetwork.mainnetworkResponsemodels.SearchResponse
import com.example.kotlinprojectstructure.network.mainnetwork.mainnetworkResponsemodels.UploadImagesResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface Endpoint {

    companion object {

        /************Auth************/
        const val logIn = "api/auth/login/"
        const val logOut = "api/auth/logout"
        const val signUp = "api/auth/signup/"

        /************Main************/
        const val search = "api/user/search"
        const val uploadImages = "api/user/upload-images_to_aws/"
        const val uploadCsv = "api/user/add-products-by-csv/"
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*********************************Auth************************************************/
    @POST(logIn)
    fun login(@Body body: LoginRequest): Call<LoginResponse>

    @GET(logOut)
    fun logout(): Call<LogoutResponse>

    @POST(signUp)
    fun signup(@Body body: SignUpRequest): Call<SignUpResponse>
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*********************************Main************************************************/
    //For-Searching
    @GET(search)
    fun search(
        @Query("search_query") search_query: String
    ): Call<SearchResponse>

    //Upload-Image-File
    @Multipart
    @POST(uploadImages)
    fun uploadImages(
        @Part image_file: ArrayList<MultipartBody.Part>
    ): Call<UploadImagesResponse>

    //Upload-Csv-File
    @Multipart
    @POST(uploadCsv)
    fun uploadCsv(
        @Part csv_file: MultipartBody.Part,
        @Part("shop_id") shop_id: RequestBody
    ): Call<AddUsersByCSVResponse>


}