package com.junsu.maidasapp7.admin.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.maidasapp7.Token
import kotlinx.coroutines.launch
import retrofit2.Response

class AdminLoginViewModel(private val repository: AdminLoginRepository) : ViewModel() {


    private var _response = MutableLiveData<Response<AdminLoginResponse>>()
    val response: LiveData<Response<AdminLoginResponse>> = _response

    fun login(request: AdminLoginRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.login(request)
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