package com.piyush.scribeflow.core.player

import android.media.MediaPlayer

class AndroidAudioPlayer : AudioPlayer {

    private var player: MediaPlayer? = null

    override fun play(
        filePath: String
    ) {

        player?.release()

        player = MediaPlayer().apply {

            setDataSource(filePath)

            prepare()

            start()
        }
    }

    override fun stop() {

        player?.stop()

        player?.release()

        player = null
    }
}