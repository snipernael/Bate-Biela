package com.app.batebiela

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonIds = intArrayOf(
            R.id.btnSom1,
            R.id.btnSom2,
            R.id.btnSom3,
            R.id.btnSom4,
            R.id.btnSom5,
            R.id.btnSom6,
            R.id.btnSom7,
            R.id.btnSom8,
            R.id.btnSom9,
            R.id.btnSom10,
            R.id.btnSom11,
            R.id.btnSom12,
            R.id.btnSom13,
            R.id.btnSom14,
            R.id.btnSom15,
            R.id.btnSom16,
            R.id.btnSom17,
            R.id.btnSom18,
            R.id.btnSom19,
            R.id.btnSom20,
            R.id.btnSom21,
            R.id.btnSom22
        )
        val soundIds = intArrayOf(
            R.raw.som_1,
            R.raw.som_2,
            R.raw.som_3,
            R.raw.som_4,
            R.raw.som_5,
            R.raw.som_6,
            R.raw.som_7,
            R.raw.som_8,
            R.raw.som_9,
            R.raw.som_10,
            R.raw.som_11,
            R.raw.som_12,
            R.raw.som_13,
            R.raw.som_14,
            R.raw.som_15,
            R.raw.som_16,
            R.raw.som_17,
            R.raw.som_18,
            R.raw.som_19,
            R.raw.som_20,
            R.raw.som_21,
            R.raw.som_22
        )

        for (i in buttonIds.indices) {
            findViewById<Button>(buttonIds[i]).setOnClickListener {
                tocarSom(soundIds[i])
            }
        }
    }

    private fun tocarSom(idDoSom: Int) {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
        }

        mediaPlayer = MediaPlayer.create(this, idDoSom)
        mediaPlayer?.start()

        mediaPlayer?.setOnCompletionListener {
            it.release()
            mediaPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}