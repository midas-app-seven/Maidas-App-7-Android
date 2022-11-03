package com.junsu.maidasapp7.user.register

import android.os.Bundle
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityUserRegisterBinding

class UserRegisterActivity : BaseActivity<ActivityUserRegisterBinding>(
    R.layout.activity_user_register
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initWidgets()
    }

    private fun initWidgets() {
        binding.tvUserRegisterGoToLogin.setOnClickListener {
            finish()
        }
    }

    override fun observeEvent() {

    }
}