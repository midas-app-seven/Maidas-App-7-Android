package com.junsu.maidasapp7.user.fragment.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.maidasapp7.Token.accessToken
import kotlinx.coroutines.launch
import retrofit2.Response

class UserStampFragmentViewModel(private val repository: UserStampRepository) : ViewModel() {

    init {
        getUserStatus()
    }

    private var _workStatus = MutableLiveData<Response<UserStampUserStatusResponse>>()
    val workStatus: LiveData<Response<UserStampUserStatusResponse>> = _workStatus

    private var _response = MutableLiveData<Response<UserStampStartWorkResponse>>()
    val response: LiveData<Response<UserStampStartWorkResponse>> = _response

    private fun getUserStatus() {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.getUserStatus(accessToken!!)
            }.onSuccess {
                println("HIHIHIHIHI${it.body()}")
                _workStatus.postValue(it)
            }.onFailure {
                println("Failure.. $it")
            }
        }
    }

    internal fun startWork() {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.startWork(accessToken!!)
            }.onSuccess {
                _response.postValue(it)
            }.onFailure {
                println("Failure.. $it")
            }
        }
    }
}

const val DO_WORKING = "근무하기"

const val DO_WAITING = "대기하기"

