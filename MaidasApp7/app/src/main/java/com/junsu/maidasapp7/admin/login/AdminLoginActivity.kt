package com.junsu.maidasapp7.admin.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.admin.main.AdminMainActivity
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityAdminLoginBinding

class AdminLoginActivity : BaseActivity<ActivityAdminLoginBinding>(
    R.layout.activity_admin_login
) {

    private val viewModel by lazy {
        ViewModelProvider(
            this, AdminLoginViewModelFactory(AdminLoginRepository())
        )[AdminLoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initWidgets()
    }

    private fun initWidgets() {
        binding.btnAdminLoginLogin.setOnClickListener {
            viewModel.login(
                AdminLoginRequest(
                    binding.etAdminLoginEmail.text.toString(),
                    binding.etAdminLoginPassword.text.toString(),
                )
            )
        }
    }

    override fun observeEvent() {
        viewModel.response.observe(
            this
        ) {
            if (it.isSuccessful) {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AdminMainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "로그인 실패.. ${it.code()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
