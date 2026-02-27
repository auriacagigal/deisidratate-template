package com.github.ulht.deisidratate

import java.util.Calendar
import java.util.Date

class EntriesBook private constructor() {

    private val entries: MutableList<WaterEntry> = mutableListOf()

    companion object {
        // Singleton: instância única, criada de forma lazy (só quando necessária)
        // Vantagens: garante uma única instância, acesso global, lazy initialization
        // Desvantagens: dificulta testes unitários, pode esconder dependências
        @Volatile
        private var instance: EntriesBook? = null

        fun getInstance(): EntriesBook {
            return instance ?: synchronized(this) {
                instance ?: EntriesBook().also { instance = it }
            }
        }
    }

    fun insert(entry: WaterEntry) {
        entries.add(entry)
    }

    fun getAll(): List<WaterEntry> = entries.toList()

    fun deleteAll() {
        entries.clear()
    }

    fun getPercentageOfLiquids(maxLimit: Int = 2000, date: Date = Date()): Int {
        val total = calculateTotalConsumedWater(date)
        return ((total.toDouble() / maxLimit) * 100).toInt()
    }

    fun getCurrentConsumption(maxLimit: Int = 2000, date: Date = Date()): String {
        val total = calculateTotalConsumedWater(date)
        return "$total/$maxLimit ml"
    }

    private fun calculateTotalConsumedWater(date: Date): Int {
        val cal = Calendar.getInstance()
        cal.time = date

        return entries.filter { entry ->
            val entryCal = Calendar.getInstance()
            entryCal.time = entry.date
            entryCal.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
                    entryCal.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)
        }.sumOf { it.amount }
    }
}