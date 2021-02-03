package com.example.retrofit157_1.pojo

import com.google.gson.annotations.SerializedName

// (POJO)
data class MarsTerrain(
                        @SerializedName("id")
                        val id: String,
                        @SerializedName("price")
                        val price: Long,
                        @SerializedName("type")
                        val type: String,
                        @SerializedName("img_src")
                        val srcImg: String)
