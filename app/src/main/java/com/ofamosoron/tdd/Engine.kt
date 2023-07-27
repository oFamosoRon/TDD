package com.ofamosoron.tdd

class Engine(var temperature: Double, var isTurnedOn: Boolean = false) {
    fun turnOn() {
        temperature += 5.0
        isTurnedOn = !isTurnedOn
    }
}