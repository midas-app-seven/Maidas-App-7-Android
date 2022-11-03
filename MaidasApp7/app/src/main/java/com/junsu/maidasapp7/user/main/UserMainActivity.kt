package com.junsu.maidasapp7.user.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityUserMainBinding
import com.junsu.maidasapp7.user.fragment.calendar.UserCalendarFragment
import com.junsu.maidasapp7.user.fragment.settings.UserSettingsFragment
import com.junsu.maidasapp7.user.fragment.user.UserStampFragment

class UserMainActivity : BaseActivity<ActivityUserMainBinding>(
    R.layout.activity_user_main
) {

    private val userStampFragment: UserStampFragment by lazy {
        UserStampFragment()
    }

    private val userCalendarFragment: UserCalendarFragment by lazy {
        UserCalendarFragment()
    }

    private val userSettingsFragment: UserSettingsFragment by lazy {
        UserSettingsFragment()
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
                    changeFragment(userCalendarFragment)
                    true
                }
                R.id.bnUserMainSettings -> {
                    changeFragment(userSettingsFragment)
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