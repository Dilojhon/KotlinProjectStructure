package com.example.kotlinprojectstructure.network


import com.example.kotlinprojectstructure.BuildConfig
import com.example.kotlinprojectstructure.utils.MyApplicationPreferences
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface ApiListener<T> {
    fun onSuccess(body: T?)
    fun onFailure(error: Throwable)
    fun onCancel() {
    }
}

object ApiClient {

    private const val BASE_URL = "http://com.example.kotlinprojectstructure"//Enter your Server URl Here

    private val httpClient = OkHttpClient.Builder()
    private val builder = getRetrofitBuilder()
    private val loggingInterceptor = getLoggingInterceptor()
    private val headerInterceptor = getHeaderInterceptor()
    val retrofitt = getRetrofit()
    val client = getRetrofitClient()

    private fun getRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    private fun getHeaderInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val request = chain.request()
                val newBuilder = request.newBuilder()
                val token = MyApplicationPreferences.token
                            if (token.isNullOrEmpty().not()) {
                    newBuilder.addHeader("Authorization", token!!)
                }
                return chain.proceed(newBuilder.build())
            }

        }
    }

    private fun getRetrofit(): Retrofit {
        if (httpClient.interceptors().contains(headerInterceptor).not()) {
            httpClient.addInterceptor(headerInterceptor)
        }
        if (BuildConfig.DEBUG) {
            if (httpClient.interceptors().contains(loggingInterceptor).not()) {
                httpClient.addInterceptor(loggingInterceptor)
            }
        }
        return builder.client(httpClient.build()).build()
    }

    private fun getRetrofitClient(): Endpoint {
        return retrofitt.create(Endpoint::class.java)
    }

    fun <T> executeApi(call: Call<T>, apiListener: ApiListener<T>) {

        call.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                apiListener.onFailure(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (call.isCanceled) {
                    apiListener.onCancel()
                }
                if (response.isSuccessful) {
                    apiListener.onSuccess(response.body())
                }
                else {
                    val parseError = ErrorHandling.parseError(response.errorBody())
                //    Timber.d(parseError.toString())
                    apiListener.onFailure(Throwable(parseError.meta.message))
                }
            }
        })
    }
}