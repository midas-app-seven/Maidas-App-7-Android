package com.junsu.maidasapp7.user.fragment.user

import com.junsu.maidasapp7.RetrofitClient
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserStampAPI {

    @GET("/user/")
    @Headers("Content-Type: application/json")
    suspend fun getUserStatus(@Header("Authorization") accessToken: String): Response<UserStampUserStatusResponse>

    @POST("/work")
    suspend fun startWork(@Header("Authorization") accessToken: String): Response<UserStampStartWorkResponse>
}

data class UserStampUserStatusResponse(
    val work_status: String,
    val work_date: String,
    val place: String,
    val time: String,
)

data class UserStampStartWorkResponse(
    val workStatus: String,
)

val userStampAPI: UserStampAPI =
    RetrofitClient.getRetrofitClient()!!.create(UserStampAPI::class.java)
