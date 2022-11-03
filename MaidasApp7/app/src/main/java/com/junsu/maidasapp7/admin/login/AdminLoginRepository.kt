package com.junsu.maidasapp7.admin.login

import retrofit2.Response

class AdminLoginRepository {

    suspend fun login(request: AdminLoginRequest): Response<AdminLoginResponse> {
        return adminLoginAPI.login(request)
    }
}