package com.ofamosoron.tdd.acceptanceTests

import com.ofamosoron.tdd.Car
import com.ofamosoron.tdd.Engine
import junit.framework.Assert.assertEquals
import org.junit.Test

class CarFeature {

    private val engine = Engine(temperature = 90.0, isTurnedOn = false)
    private val car = Car(fuel = 6.0, engine = engine)

    @Test
    fun carIsLoosingFuelWhenIsTurnedOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnEngineAndTemperatureIsRising() {
        car.turnOn()

        assertEquals(95.0, car.engine.temperature)
        assertEquals(true, car.engine.isTurnedOn)
    }
}