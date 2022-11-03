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

class TomorrowDecorator(context: Context) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_transparent)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return when (day!!.month) {
            CalendarDay.today().month -> {
                true
            }
            else -> {
                false
            }
        }
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}

class AllDecorator(context: Context) : DayViewDecorator {

    val drawable = context.getDrawable(R.drawable.background_no_worktime)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return day?.isBefore(CalendarDay.today()) == true
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable)
    }
}

class RandomDecorator3(context: Context) : DayViewDecorator {

    private val _day = CalendarDay.today().day

    val drawable1 = context.getDrawable(R.drawable.background_below_four_hours)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return when {
            day!!.day % 3 == 0 -> {
                true
            }
            else -> {
                false
            }
        }
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable1)
    }
}

class RandomDecorator7(context: Context) : DayViewDecorator {

    private val _day = CalendarDay.today().day

    val drawable2 = context.getDrawable(R.drawable.background_below_four_hours)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return when {
            day!!.day % 7 == 0 || day!!.day % 11 == 0 -> {
                true
            }
            else -> {
                false
            }
        }
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable2)
    }
}

class RandomDecorator4(context: Context) : DayViewDecorator {

    private val _day = CalendarDay.today().day

    val drawable3 = context.getDrawable(R.drawable.background_below_eight_hours)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return when {
            day!!.day % 4 == 0 -> {
                true
            }
            else -> {
                false
            }
        }
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable3)
    }
}

class RandomDecorator456(context: Context) : DayViewDecorator {

    private val _day = CalendarDay.today().day

    val drawable4 = context.getDrawable(R.drawable.background_over_eight_hours)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return when {
            day!!.day % 4 == 0 || day!!.day % 5 == 0 || day!!.day % 6 == 0 -> {
                true
            }
            else -> {
                false
            }
        }
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setBackgroundDrawable(drawable4)
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