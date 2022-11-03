package com.junsu.maidasapp7

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getRetrofitClient(): Retrofit? {
        return retrofit ?: let {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

// TODO
const val BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/"