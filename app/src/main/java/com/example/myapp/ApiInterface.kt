package com.example.myapp

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Sudam Chole on 2/18/2020.
 */
interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("LogErrorAPI")
    fun logErrorAPI(@Body body: String): Call<JsonObject>
}
