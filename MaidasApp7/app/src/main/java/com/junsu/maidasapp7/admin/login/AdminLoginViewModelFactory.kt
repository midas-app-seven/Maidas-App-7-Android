package com.junsu.maidasapp7.admin.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class AdminLoginViewModelFactory(private val repository: AdminLoginRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AdminLoginViewModel(repository) as T
    }
}