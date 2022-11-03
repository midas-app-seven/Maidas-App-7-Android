package com.junsu.maidasapp7.user.fragment.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class UserStampFragmentViewModel(private val repository: UserStampRepository) : ViewModel() {

    private var _workState = MutableLiveData<Response<UserStampGetWorkStateResponse>>()
    val workState: LiveData<Response<UserStampGetWorkStateResponse>> = _workState

    private var _response = MutableLiveData<Response<UserStampChangeWorkStateResponse>>()
    val response: LiveData<Response<UserStampChangeWorkStateResponse>> = _response

    fun getUserWorkState() {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.getUserWorkState(
                    UserStampGetWorkStateRequest(
                        "TODO"
                    )
                )
            }.onSuccess {
                _workState.postValue(it)
            }.onFailure {
                println("Failure.. $it")
            }
        }
    }

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

var startTime: Int? = null

const val WAITING = "대기"
const val DO_WORKING = "근무하기"

const val WORKING = "근무"
const val DO_WAITING = "대기하기"

