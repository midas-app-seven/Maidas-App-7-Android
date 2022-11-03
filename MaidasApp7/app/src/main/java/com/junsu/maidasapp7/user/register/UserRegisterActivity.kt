package com.junsu.maidasapp7.user.register

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityUserRegisterBinding

class UserRegisterActivity : BaseActivity<ActivityUserRegisterBinding>(
    R.layout.activity_user_register
) {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            UserRegisterViewModelFactory(UserRegisterRepository())
        )[UserRegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initWidgets()
    }

    private fun initWidgets() {
        binding.btnUserRegisterVerifyEmail.setOnClickListener {
            // TODO 인증 요청
        }

        binding.btnUserRegisterRegister.setOnClickListener {
            viewModel.register(
                UserRegisterRequest(
                    binding.etUserRegisterEmail.text.toString(),
                    binding.etUserRegisterVerificationCode.text.toString(),
                    binding.etUserRegisterNickname.text.toString(),
                    binding.etUserRegisterPassword.text.toString(),
                    binding.etUserRegisterCompanyVerificationCode.text.toString()
                ).also {
                    println(it.toString())
                }
            )
        }

        binding.tvUserRegisterGoToLogin.setOnClickListener {
            finish()
        }
    }

    override fun observeEvent() {
        viewModel.registerResponse.observe(
            this
        ) {
            if (it.isSuccessful) {
                Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                println(it.code())
                Toast.makeText(this, "회원가입 실패..", Toast.LENGTH_SHORT).show()
            }
        }
    }
}