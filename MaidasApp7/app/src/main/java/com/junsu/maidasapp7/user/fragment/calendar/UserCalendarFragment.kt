package com.junsu.maidasapp7.user.fragment.calendar

import android.os.Bundle
import android.view.View
import com.junsu.maidasapp7.AllDecorator
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.TodayDecorator
import com.junsu.maidasapp7.base.BaseFragment
import com.junsu.maidasapp7.databinding.FragmentUserCalenderBinding

class UserCalendarFragment : BaseFragment<FragmentUserCalenderBinding>(
    R.layout.fragment_user_calender
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calendarUserCalendar.addDecorators(
            AllDecorator(requireActivity()),
            TodayDecorator(requireActivity())
        )
    }

    override fun observeEvent() {
    }
}