package com.junsu.maidasapp7.admin.login

import com.junsu.maidasapp7.RetrofitClient
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AdminLoginAPI {

    @POST("/manager/login")
    @Headers("Content-Type: application/json")
    suspend fun login(@Body adminLoginRequest: AdminLoginRequest): Response<AdminLoginResponse>
}

data class AdminLoginRequest(
    val email: String,
    val password: String,
)

data class AdminLoginResponse(
    val accessToken: String,
    val refreshToken: String,
)

val adminLoginAPI: AdminLoginAPI =
    RetrofitClient.getRetrofitClient()!!.create(AdminLoginAPI::class.java)