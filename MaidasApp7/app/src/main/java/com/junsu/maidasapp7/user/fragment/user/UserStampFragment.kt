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

    var isWorking = false

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
            changeUserWorkState()
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
            if (isWorking) {
                buttonWorkState.apply {
                    setBackgroundResource(
                        R.drawable.background_btn_primary_red
                    )
                    text = DO_WAITING

                }
                tvUserStampWorkState.text = /*TODO*/ WORKING
                /* TODO* */
                isWorking = false

                run {
                    radioBtn1.isEnabled = false
                    radioBtn2.isEnabled = false
                    radioBtn3.isEnabled = false
                }
            } else {
                buttonWorkState.apply {
                    setBackgroundResource(
                        R.drawable.background_btn_primary
                    )
                    text = DO_WORKING

                }
                tvUserStampWorkState.text = /*TODO*/ WAITING

                isWorking = true

                run {
                    radioBtn1.isEnabled = true
                    radioBtn2.isEnabled = true
                    radioBtn3.isEnabled = true
                }
            }
        }
    }
}