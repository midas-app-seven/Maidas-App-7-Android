package com.junsu.maidasapp7.user.fragment.user

import retrofit2.Response

class UserStampRepository {

    suspend fun getUserStatus(accessToken: String): Response<UserStampUserStatusResponse> {
        return userStampAPI.getUserStatus(accessToken)
    }

    suspend fun startWork(accessToken: String): Response<UserStampStartWorkResponse> {
        return userStampAPI.startWork(accessToken)
    }
}