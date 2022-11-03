package com.junsu.maidasapp7.user.fragment.user

import retrofit2.Response

class UserStampRepository {

    suspend fun getUserWorkState(request: UserStampGetWorkStateRequest): Response<UserStampGetWorkStateResponse> {
        return userStampAPI.getUserWorkState(request)
    }

    suspend fun changeUserWorkState(request: UserStampChangeWorkStateRequest): Response<UserStampChangeWorkStateResponse> {
        return userStampAPI.changeUserWorkState(request)
    }
}