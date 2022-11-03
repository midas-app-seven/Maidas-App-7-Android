package com.junsu.maidasapp7.user.fragment.user

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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

        val fadeInAnimation: Animation =
            AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_fade_in)

        val fadeOutAnimation: Animation =
            AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_fade_out)

        with(binding) {
            if (isWorking) {
                buttonWorkState.apply {
                    setBackgroundResource(
                        R.drawable.background_btn_primary_red
                    )
                    text = DO_WAITING

                }
                tvUserStampWorkStateWorking.startAnimation(fadeInAnimation)
                tvUserStampWorkStateWaiting.startAnimation(fadeOutAnimation)
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
                tvUserStampWorkStateWorking.startAnimation(fadeOutAnimation)
                tvUserStampWorkStateWaiting.startAnimation(fadeInAnimation)

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

