package com.piyush.scribeflow.core.player

interface AudioPlayer {

    fun play(filePath: String)

    fun stop()
}