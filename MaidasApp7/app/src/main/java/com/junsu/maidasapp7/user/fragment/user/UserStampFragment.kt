package com.junsu.maidasapp7.user.fragment.user

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseFragment
import com.junsu.maidasapp7.databinding.FragmentUserStampBinding

class UserStampFragment : BaseFragment<FragmentUserStampBinding>(
    R.layout.fragment_user_stamp
) {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            UserStampFragmentViewModelFactory(UserStampRepository())
        )[UserStampFragmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWidgets()
    }

    private fun initWidgets() {
        binding.buttonWorkState.setOnClickListener {

            /*viewModel.changeUserWorkState(
                UserStampChangeWorkStateRequest(
                    //TODO
                )
            )*/
        }
    }

    override fun observeEvent() {
        viewModel.response.observe(
            this
        ) {
            if (it.isSuccessful) {
                changeUserWorkState()
            }
        }
    }

    private fun changeUserWorkState() {
        with(binding) {
            buttonWorkState.setBackgroundDrawable()
        }
    }
}