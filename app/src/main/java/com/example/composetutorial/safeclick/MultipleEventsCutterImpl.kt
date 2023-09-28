package com.example.composetutorial.safeclick

import android.os.SystemClock

class MultipleEventsCutterImpl : MultipleEventsCutter {

    private var defaultInterval: Int = 1000
    private var lastTimeClicked: Long = 0

    override fun processEvent(event: () -> Unit) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        event.invoke()
    }
}