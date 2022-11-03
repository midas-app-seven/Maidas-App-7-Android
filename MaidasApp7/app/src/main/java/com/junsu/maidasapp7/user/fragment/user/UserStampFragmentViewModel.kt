package com.junsu.maidasapp7.user.fragment.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class UserStampFragmentViewModel(private val repository: UserStampRepository) : ViewModel() {

    private var _response = MutableLiveData<Response<UserStampChangeWorkStateResponse>>()
    val response: LiveData<Response<UserStampChangeWorkStateResponse>> = _response

    fun changeUserWorkState(request: UserStampChangeWorkStateRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.changeUserWorkState(request)
            }.onSuccess {
                _response.postValue(it)
            }.onFailure {
                println("Failure.. $it")
            }
        }
    }
}