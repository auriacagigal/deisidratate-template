package com.github.ulht.deisidratate

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat

class WaterEntryTest {

  @Test
  fun daytime_IsMorning_DateTimeMustReturnMorning() {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
    val date = sdf.parse("31/12/2023 08:00")
    val entry = WaterEntry(drink = DrinkType.WATER, amount = 100, date = date)

    val dayTime = entry.dayTime

    assertEquals(DayTimeType.MORNING, dayTime)
  }

  @Test
  fun daytime_IsNoon_DateTimeMustReturnNoon() {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
    val date = sdf.parse("31/12/2023 14:00")
    val entry = WaterEntry(drink = DrinkType.WATER, amount = 50, date = date)

    val dayTime = entry.dayTime

    assertEquals(DayTimeType.NOON, dayTime)
  }

  @Test
  fun daytime_IsNoon_DateTimeMustReturnNight() {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
    val date = sdf.parse("31/12/2023 00:00")
    val entry = WaterEntry(drink = DrinkType.WATER, amount = 100, date = date)

    val dayTime = entry.dayTime

    assertEquals(DayTimeType.NIGHT, dayTime)
  }

}