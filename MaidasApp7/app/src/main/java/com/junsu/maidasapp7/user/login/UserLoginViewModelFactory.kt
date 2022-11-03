package com.junsu.maidasapp7.user.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class UserLoginViewModelFactory(private val repository: UserLoginRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserLoginViewModel(repository) as T
    }
}