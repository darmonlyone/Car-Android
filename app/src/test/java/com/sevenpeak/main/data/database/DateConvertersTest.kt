package com.sevenpeak.main.data.database

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class DateConvertersTest {

    lateinit var dateConverters: DateConverters

    @Before
    fun setUp() {
        dateConverters = DateConverters()
    }

    @Test
    fun testFromTimestamp() {
        val result = dateConverters.fromTimestamp(1624393391523)
        assertEquals(result!!.time, 1624393391523)
    }

    @Test
    fun testDateToTimestamp() {
        val result = dateConverters.dateToTimestamp(Date(1624393391523))
        assertEquals(1624393391523, result)
    }
}