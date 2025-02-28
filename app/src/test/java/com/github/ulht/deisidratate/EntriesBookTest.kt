package com.github.ulht.deisidratate

import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import org.junit.Assert.*

class EntriesBookTest {

  @Before
  fun setUp() {
    EntriesBook.deleteAll()
  }

  @Test
  fun getPercentageOfLiquids_WithDefaultLimitHaveDrank1000_Return50Percent() {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
    val date = sdf.parse("31/12/2023 08:00")

    EntriesBook.insert(WaterEntry(drink = DrinkType.WATER, amount = 500, date = date!!))
    EntriesBook.insert(WaterEntry(drink = DrinkType.WATER, amount = 500, date = date))
    val percentage = EntriesBook.getPercentageOfLiquids(date = date)

    assertEquals(50, percentage)
  }

}