package com.piyush.scribeflow.core.recorder

import android.media.MediaRecorder
import android.os.Build

class AndroidAudioRecorder : AudioRecorder {

    private var recorder: MediaRecorder? = null

    override fun start(
        outputFile: String
    ) {

        recorder =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                MediaRecorder()
            } else {
                MediaRecorder()
            }

        recorder?.apply {

            setAudioSource(
                MediaRecorder.AudioSource.MIC
            )

            setOutputFormat(
                MediaRecorder.OutputFormat.MPEG_4
            )

            setAudioEncoder(
                MediaRecorder.AudioEncoder.AAC
            )

            setOutputFile(
                outputFile
            )

            prepare()

            start()
        }
    }

    override fun stop() {

        recorder?.apply {

            stop()

            release()
        }

        recorder = null
    }
}