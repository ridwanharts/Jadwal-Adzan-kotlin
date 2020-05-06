package com.ridwanharts.jadwaladzan.data.network

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiAdzan {

    @GET("779/tanggal/{date}")
    suspend fun getData(
        @Path(
            value = "date",
            encoded = true
        ) date : String
    ) : Response<AdzanResponse>

    companion object{
        operator fun invoke(
            netConInterceptor: NetConInterceptor
        ): ApiAdzan{
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(netConInterceptor)
                .build()
            return Retrofit.Builder().client(okHttpClient)
                .baseUrl("https://api.banghasan.com/sholat/format/json/jadwal/kota/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiAdzan::class.java)
        }
    }
}