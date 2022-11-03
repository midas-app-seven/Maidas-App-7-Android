package com.junsu.maidasapp7.user.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityUserLoginBinding
import com.junsu.maidasapp7.user.main.UserMainActivity
import com.junsu.maidasapp7.user.register.UserRegisterActivity

class UserLoginActivity : BaseActivity<ActivityUserLoginBinding>(
    R.layout.activity_user_login
) {

    private val viewModel by lazy {
        ViewModelProvider(
            this, UserLoginViewModelFactory(UserLoginRepository())
        )[UserLoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initWidgets()
    }

    private fun initWidgets() {
        binding.btnUserLoginLogin.setOnClickListener {
            viewModel.login(
                LoginRequest(
                    binding.etUserLoginEmail.text.toString(),
                    binding.etUserLoginPassword.text.toString(),
                )
            )
        }

        binding.tvUserLoginGoToRegister.setOnClickListener {
            startActivity(Intent(this, UserRegisterActivity::class.java))
        }
    }

    override fun observeEvent() {
        viewModel.response.observe(
            this
        ) {
            if (it.isSuccessful) {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, UserMainActivity::class.java))
            } else {
                Toast.makeText(this, "로그인 실패.. ${it.code()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}