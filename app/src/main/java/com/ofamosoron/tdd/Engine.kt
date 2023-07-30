package com.ofamosoron.tdd

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine(var temperature: Double, var isTurnedOn: Boolean = false) {
    suspend fun turnOn(): Flow<Double> {
        isTurnedOn = !isTurnedOn

        return flow {
            repeat(3) {
                delay(2_000)
                temperature += 5
                emit(temperature)
            }
        }
    }
}