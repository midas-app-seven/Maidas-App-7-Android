package com.junsu.maidasapp7.user.register

import retrofit2.Response

class UserRegisterRepository {

    suspend fun register(request: UserRegisterRequest): Response<Void> {
        return registerAPI.register(request)
    }
}