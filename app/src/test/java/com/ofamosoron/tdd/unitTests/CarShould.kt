package com.ofamosoron.tdd.unitTests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.ofamosoron.tdd.Car
import com.ofamosoron.tdd.Engine
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(fuel = 5.0, engine = engine)

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenTurnedOn() = runBlockingTest {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlockingTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}