package com.junsu.maidasapp7.user.fragment.user

import android.os.Bundle
import android.view.View
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseFragment
import com.junsu.maidasapp7.databinding.FragmentUserStampBinding

class UserStampFragment : BaseFragment<FragmentUserStampBinding>(
    R.layout.fragment_user_stamp
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWidgets()
    }

    private fun initWidgets() {

    }

    override fun observeEvent() {
    }
}