package com.example.agrithonadmin

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface APIService {

    @GET("/")
    suspend fun getAdminData(): Call<AdminResponse>

    companion object {
        fun create(url: String) : APIService {

            val client = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build().create(APIService::class.java)
        }
    }
}