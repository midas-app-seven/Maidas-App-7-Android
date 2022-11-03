package com.junsu.maidasapp7.user.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class UserRegisterViewModel(private val repository: UserRegisterRepository) : ViewModel() {

    private var _registerResponse = MutableLiveData<Response<Void>>()
    val registerResponse: LiveData<Response<Void>> = _registerResponse

    internal fun register(request: UserRegisterRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.register(request)
            }.onSuccess {
                _registerResponse.value = it
            }.onFailure {
                println("Failure..$it")
            }
        }
    }
}