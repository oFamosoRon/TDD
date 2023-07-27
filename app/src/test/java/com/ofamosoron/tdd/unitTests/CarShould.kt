package com.ofamosoron.tdd.unitTests

import com.ofamosoron.tdd.Car
import com.ofamosoron.tdd.Engine
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(fuel = 5.0, engine = engine)

    @Test
    fun looseFuelWhenTurnedOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}