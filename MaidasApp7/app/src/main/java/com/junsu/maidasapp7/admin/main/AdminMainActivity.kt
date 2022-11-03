package com.junsu.maidasapp7.admin.main

import android.content.Intent
import android.os.Bundle
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.admin.userdetail.AdminMainUserDetailActivity
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityAdminMainBinding

class AdminMainActivity : BaseActivity<ActivityAdminMainBinding>(
    R.layout.activity_admin_main
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.container.setOnClickListener {
            startActivity(Intent(this, AdminMainUserDetailActivity::class.java))
        }
    }

    override fun observeEvent() {
    }
}
