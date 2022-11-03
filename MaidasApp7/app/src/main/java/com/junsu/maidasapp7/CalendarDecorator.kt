package com.junsu.maidasapp7

import android.content.Context
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class TodayDecorator(context: Context) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_calendar_selected)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return day?.equals(CalendarDay.today())!!
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}

class AllDecorator(context: Context) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_no_worktime)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return true
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}

class NoWorkTimeDecorator(context: Context) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_no_worktime)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return true
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}

class BelowFourHoursDecorator(context: Context, day: CalendarDay) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_below_four_hours)!!
    private val receivedDay = day


    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return receivedDay == day
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}

class BelowEightHoursDecorator(context: Context, day: CalendarDay) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_below_eight_hours)!!
    private val receivedDay = day


    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return receivedDay == day
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}

class OverEightHoursDecorator(context: Context, day: CalendarDay) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_over_eight_hours)!!
    private val receivedDay = day


    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return receivedDay == day
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}