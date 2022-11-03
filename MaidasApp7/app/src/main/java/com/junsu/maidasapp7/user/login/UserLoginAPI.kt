package com.junsu.maidasapp7.user.login

import com.junsu.maidasapp7.RetrofitClient
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserLoginAPI {

    @POST("/auth/user/login")
    @Headers("Content-Type: application/json")
    suspend fun login(@Body userLoginRequest: UserLoginRequest): Response<LoginResponse>
}

data class UserLoginRequest(
    val email: String,
    val password: String,
)

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
)

val userLoginAPI: UserLoginAPI =
    RetrofitClient.getRetrofitClient()!!.create(UserLoginAPI::class.java)