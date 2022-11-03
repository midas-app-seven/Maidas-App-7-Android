package com.junsu.maidasapp7.presentation

import android.os.Bundle
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.databinding.ActivityAdminLoginBinding
import com.junsu.movie.presentation.base.BaseActivity

class AdminLoginActivity : BaseActivity<ActivityAdminLoginBinding>(
    R.layout.activity_admin_login
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
    }

    override fun observeEvent() {
    }
}