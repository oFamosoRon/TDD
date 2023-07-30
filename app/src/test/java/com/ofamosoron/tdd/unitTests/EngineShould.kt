package com.ofamosoron.tdd.unitTests

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.ofamosoron.tdd.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine(isTurnedOn = false, temperature = 80.0)

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlocking {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureGraduallyWhenTurnsOn() = runBlocking {
        val flow = engine.turnOn()
        val actual = flow.toList()

        assertEquals(listOf<Double>(85.0, 90.0, 95.0), actual)
    }
}