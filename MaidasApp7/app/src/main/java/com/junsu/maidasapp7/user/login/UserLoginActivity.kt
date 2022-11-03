package com.junsu.maidasapp7.user.login

import android.content.Intent
import android.os.Bundle
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityUserLoginBinding
import com.junsu.maidasapp7.user.register.UserRegisterActivity

class UserLoginActivity : BaseActivity<ActivityUserLoginBinding>(
    R.layout.activity_user_login
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initWidgets()
    }

    private fun initWidgets() {
        binding.btnUserLoginLogin.setOnClickListener {
            // TODO 로그인 로직
        }

        binding.tvUserLoginGoToRegister.setOnClickListener {
            startActivity(Intent(this, UserRegisterActivity::class.java))
        }
    }

    override fun observeEvent() {
    }
}