package com.junsu.maidasapp7.user.fragment.calendar

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Toast
import com.junsu.maidasapp7.*
import com.junsu.maidasapp7.base.BaseFragment
import com.junsu.maidasapp7.databinding.FragmentUserCalenderBinding

class UserCalendarFragment : BaseFragment<FragmentUserCalenderBinding>(
    R.layout.fragment_user_calender
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.calendarUserCalendar) {
            addDecorators(
                AllDecorator(requireActivity()),
                RandomDecorator3(requireActivity()),
                RandomDecorator4(requireActivity()),
                RandomDecorator7(requireActivity()),
                RandomDecorator456(requireActivity()),
                TomorrowDecorator(requireActivity()),
                TodayDecorator(requireActivity()),
            )
            setOnDateChangedListener { w, d, s ->
                if (d.day.toString().toInt() == 25) {
                    binding.textView3.text = "10월 25일에 일한 시간"
                    binding.btnUserCalendarApplyVacation.isEnabled = false

                    binding.tvUserCalendarStartOfWorkStampTime.text = "09:25"

                    binding.textView2.visibility = VISIBLE
                    binding.tvUserCalendarEndOfWorkStampTime.visibility = VISIBLE
                    binding.tvUserCalendarTotalTime.text = "492/480"

                } else if (d.day.toString().toInt() == 29) {
                    binding.textView3.text = "10월 29일에 일한 시간"
                    binding.tvUserCalendarStartOfWorkStampTime.text = "-"
                    binding.tvUserCalendarEndOfWorkStampTime.text = "-"
                    binding.tvUserCalendarTotalTime.text = "-/480"

                } else if (d.day.toString().toInt() == 5) {
                    binding.textView3.text = "11월 5일에 일한 시간"
                    binding.btnUserCalendarApplyVacation.alpha = 1.0f
                    binding.btnUserCalendarApplyVacation.isEnabled = true
                }
            }
        }


        binding.btnUserCalendarApplyVacation.setOnClickListener {
            val builder = AlertDialog.Builder(requireActivity())
            builder.setMessage("연차 또는 반차를 선택해 주세요")
                .setPositiveButton(
                    "연차"
                ) { _, _ ->
                    Toast.makeText(requireActivity(), "신청이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    binding.tvUserCalendarAnnualLeft.text =
                        (binding.tvUserCalendarAnnualLeft.text.toString().toFloat().minus(1)
                            .toString())
                }
                .setNegativeButton("반차") { _, _ ->
                    Toast.makeText(requireActivity(), "신청이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    binding.tvUserCalendarAnnualLeft.text =
                        (binding.tvUserCalendarAnnualLeft.text.toString().toFloat().minus(0.5)
                            .toString())
                }
            builder.create()
            builder.show()
        }
    }

    override fun observeEvent() {
    }
}