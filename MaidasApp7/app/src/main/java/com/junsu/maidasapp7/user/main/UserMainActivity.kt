package com.junsu.maidasapp7.user.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityUserMainBinding
import com.junsu.maidasapp7.user.fragment.user.UserStampFragment

class UserMainActivity : BaseActivity<ActivityUserMainBinding>(
    R.layout.activity_user_main
) {

    private val userStampFragment: UserStampFragment by lazy {
        UserStampFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeFragment(userStampFragment)
        initWidgets()
    }

    private fun initWidgets() {
        binding.bnUserMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bnUserMainUser -> {
                    changeFragment(userStampFragment)
                    true
                }
                R.id.bnUserMainCalendar -> {
                    // TODO
                    true
                }
                R.id.bnUserMainSettings -> {
                    // TODO
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.layoutUserMainContainer.id, fragment)
            .commitAllowingStateLoss()
    }

    override fun observeEvent() {
    }
}