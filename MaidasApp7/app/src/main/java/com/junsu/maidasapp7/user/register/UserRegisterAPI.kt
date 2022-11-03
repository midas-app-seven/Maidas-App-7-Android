package com.junsu.maidasapp7.user.register

import com.junsu.maidasapp7.RetrofitClient
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserRegisterAPI {

    @POST("/auth/user")
    @Headers("Content-Type: application/json")
    suspend fun register(@Body userRegisterRequest: UserRegisterRequest): Response<Void>

    @POST("/email")
    @Headers("Content-Type: application/json")
    suspend fun verifyEmail(@Body verifyEmailRequest: VerifyEmailRequest): Response<Void>
}

data class UserRegisterRequest(
    val email: String,
    val authKey: String,
    val nickname: String,
    val password: String,
    val companyCode: String,
)

data class VerifyEmailRequest(
    val email: String,
)

val userRegisterAPI: UserRegisterAPI =
    RetrofitClient.getRetrofitClient()!!.create(UserRegisterAPI::class.java)