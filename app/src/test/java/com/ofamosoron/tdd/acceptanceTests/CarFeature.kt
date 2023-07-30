package com.ofamosoron.tdd.acceptanceTests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.ofamosoron.tdd.Car
import com.ofamosoron.tdd.Engine
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine(temperature = 80.0, isTurnedOn = false)
    private val car = Car(fuel = 6.0, engine = engine)

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenIsTurnedOn() = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun carIsTurningOnEngineAndTemperatureIsRising() = runBlockingTest {
        car.turnOn()
        coroutineTestRule.advanceTimeBy(6_001)
        assertEquals(95.0, car.engine.temperature)
        assertEquals(true, car.engine.isTurnedOn)
    }
}