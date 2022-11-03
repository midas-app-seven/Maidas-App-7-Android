package com.junsu.maidasapp7.user.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class UserRegisterViewModelFactory(private val repository: UserRegisterRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserRegisterViewModel(repository) as T
    }
}