package com.junsu.maidasapp7.user.fragment.user

import com.junsu.maidasapp7.RetrofitClient
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserStampAPI {

    @POST(" TODO")
    suspend fun changeUserWorkState(@Body userStampChangeWorkStateRequest: UserStampChangeWorkStateRequest): Response<UserStampChangeWorkStateResponse>
}

data class UserStampChangeWorkStateRequest(
    val type: String, //TODO
)

data class UserStampChangeWorkStateResponse(
    val type: String, //TODO
)

val userStampAPI: UserStampAPI =
    RetrofitClient.getRetrofitClient()!!.create(UserStampAPI::class.java)
