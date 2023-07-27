package com.ofamosoron.tdd.unitTests

import com.ofamosoron.tdd.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EngineShould {

    private val engine = Engine(isTurnedOn = false, temperature = 90.0)

    @Test
    fun turnOn() {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseItsTemperatureWhenTurnedOn() {
        engine.turnOn()
        assertEquals(95.0, engine.temperature)
    }
}