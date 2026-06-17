package com.piyush.scribeflow.core.recorder

interface AudioRecorder {

    fun start(outputFile: String)

    fun stop()
}