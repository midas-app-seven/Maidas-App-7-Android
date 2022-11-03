package com.junsu.maidasapp7.user.fragment.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class UserStampFragmentViewModelFactory(private val repository: UserStampRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserStampFragmentViewModel(repository) as T
    }
}