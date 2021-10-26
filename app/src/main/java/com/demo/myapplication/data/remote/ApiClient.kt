package com.demo.myapplication.data.remote

import android.os.Build
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by Ghanshyam.
 */
object ApiClient {
    var webApiService: WebApiService? =null
    fun getapi():WebApiService {
            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            httpClientBuilder.connectTimeout(5, TimeUnit.MINUTES)
            httpClientBuilder.readTimeout(5, TimeUnit.MINUTES)
            httpClientBuilder.writeTimeout(5, TimeUnit.MINUTES)

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)

            val gsonInstance = GsonBuilder().setLenient().create()

            var retrofitWithHeader = Retrofit.Builder()
                .baseUrl(WebApiService.BASEURL)
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gsonInstance))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            webApiService = retrofitWithHeader.create(WebApiService::class.java)
            return this.webApiService!!
        }
}