package com.example.composetutorial.safeclick

interface MultipleEventsCutter {
    fun processEvent(event: () -> Unit)
    companion object
}