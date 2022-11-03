package com.junsu.maidasapp7.user.fragment.user

import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseFragment
import com.junsu.maidasapp7.databinding.FragmentUserStampBinding
import java.text.SimpleDateFormat
import java.util.*

class UserStampFragment : BaseFragment<FragmentUserStampBinding>(
    R.layout.fragment_user_stamp
) {

    private val fadeInAnimation by lazy {
        AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_fade_in)
    }

    private val fadeOutAnimation by lazy {
        AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_fade_out)
    }

    var isWorking = true

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
            changeUserWorkState()
            if (isWorking) {
                //TODO
            } else {
                viewModel.startWork()
            }
            binding.tvUserStampFirstStampTime.text =
                SimpleDateFormat("hh:mm", Locale.getDefault()).format(Calendar.getInstance().time)
            binding.tvUserStampWorkTime.text = "오늘 479분 남았어요"
            binding.tvUserStampTotalTime.text = "0/480"
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

        viewModel.workStatus.observe(
            this
        ) {
            if (it.isSuccessful) {
                with(binding) {
                    when (it.body()!!.work_status) {
                        "WORK" -> {
                            isWorking = true
                            changeUserWorkState()
                        }
                        else -> {
                            isWorking = false
                            changeUserWorkState()
                        }
                    }
                    tvUserStampFirstStampTime.text = it.body()!!.work_date
                }
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
                tvUserStampWorkStateWorking.visibility = VISIBLE
                tvUserStampWorkStateWorking.startAnimation(fadeInAnimation)


                tvUserStampWorkStateWaiting.startAnimation(fadeOutAnimation)
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

                tvUserStampWorkStateWaiting.visibility = VISIBLE
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

