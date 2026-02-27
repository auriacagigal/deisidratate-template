package com.github.ulht.deisidratate

import java.util.Calendar
import java.util.Date

class WaterEntry(
    val drink: DrinkType,
    val amount: Int,
    val date: Date?,
    val notes: String? = null
) {
    val dayTime: DayTimeType
        get() {
            val cal = Calendar.getInstance()
            cal.time = date
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            return when {
                hour in 7..11 -> DayTimeType.MORNING
                hour in 12..20 -> DayTimeType.NOON
                else -> DayTimeType.NIGHT
            }
        }
}