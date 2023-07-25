package com.ofamosoron.tdd

import org.junit.Test

import org.junit.Assert.*


class EngineTest {

    private val engine = Engine(2000, 189, temperature = 15, isTurnedOn = false)

    @Test
    fun engineTurnedOn() {
        engine.turnOn()
        assertEquals(true, engine.isTurnedOn)
        assertEquals(95, engine.temperature)
    }

    @Test
    fun engineTurnedOff() {
        engine.turnOff()
        assertEquals(false, engine.isTurnedOn)
        assertEquals(15, engine.temperature)
    }
}