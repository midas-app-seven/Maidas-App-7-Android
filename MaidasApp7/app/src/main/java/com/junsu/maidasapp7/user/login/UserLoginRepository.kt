package com.junsu.maidasapp7.user.login

import retrofit2.Response

class UserLoginRepository {

    suspend fun login(userLoginRequest: UserLoginRequest): Response<LoginResponse> {
        return userLoginAPI.login(userLoginRequest)
    }
}
