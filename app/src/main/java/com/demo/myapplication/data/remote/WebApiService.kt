package com.demo.myapplication.data.remote

import com.demo.myapplication.data.model.apiresponse.NameListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface WebApiService {

    @GET("employees")
    fun nameList(): Observable<NameListResponse>

   companion object {
        const val BASEURL = "https://dummy.restapiexample.com/api/v1/"
    }
}