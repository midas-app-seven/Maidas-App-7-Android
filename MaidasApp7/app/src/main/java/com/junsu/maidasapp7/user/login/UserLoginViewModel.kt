package com.junsu.maidasapp7.user.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.maidasapp7.Token
import kotlinx.coroutines.launch
import retrofit2.Response

class UserLoginViewModel(private val repository: UserLoginRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<LoginResponse>>()
    val response: LiveData<Response<LoginResponse>> = _response

    internal fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.login(loginRequest)
            }.onSuccess {
                _response.postValue(it)
                if (it.isSuccessful) {
                    with(Token) {
                        accessToken = it.body()!!.accessToken.also { tk ->
                            println(tk)
                        }
                        refreshToken = it.body()!!.refreshToken.also { tk ->
                            println(tk)
                        }
                    }
                }
            }.onFailure {
                println("Failure.. $it")
            }
        }
    }
}