package com.junsu.maidasapp7.user.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class UserRegisterViewModel(private val repository: UserRegisterRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<Void>>()
    val response: LiveData<Response<Void>> = _response

    internal fun register(request: UserRegisterRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.register(request)
            }.onSuccess {
                _response.postValue(it)
            }.onFailure {
                println("Failure.. $it")
            }
        }
    }
}