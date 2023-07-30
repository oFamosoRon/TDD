package com.ofamosoron.tdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Car(var fuel: Double, var engine: Engine) {

    suspend fun turnOn() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn().collect { temperature ->
                println("$temperature")
            }
        }
    }
}