package com.junsu.maidasapp7

import android.content.Intent
import android.os.Bundle
import com.junsu.maidasapp7.databinding.ActivityStartBinding
import com.junsu.maidasapp7.admin.AdminLoginActivity
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.user.login.UserLoginActivity

class StartActivity : BaseActivity<ActivityStartBinding>(
    R.layout.activity_start
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initButtons()
    }

    private fun initButtons() {
        binding.btnStartUser.setOnClickListener {
            startActivity(Intent(this, UserLoginActivity::class.java))
            finish()
        }

        binding.btnStartAdmin.setOnClickListener {
            startActivity(Intent(this, AdminLoginActivity::class.java))
            finish()
        }
    }

    override fun observeEvent() {
    }
}