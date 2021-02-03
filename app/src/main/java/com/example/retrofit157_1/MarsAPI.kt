package com.example.retrofit157_1

import com.example.retrofit157_1.pojo.MarsTerrain
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MarsAPI {

    // vieja confiable
    @GET("realestate")
    fun fetchMarsTerrainEnqueue(): Call<List<MarsTerrain>>

    //La forma recomendable nueva
    @GET("realestate")
    suspend fun fetchMarsTerrainCoroutines(): Response<List<MarsTerrain>>

}