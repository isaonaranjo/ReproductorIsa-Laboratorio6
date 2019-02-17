package com.example.reproductorisa

// Maria Isabel Ortiz Naranjo
// Carne: 18176
// Plataformas moviles y videojuegos

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal lateinit var play_pause: Button
    internal lateinit var btn_repetir: Button
    internal var mp: MediaPlayer? = null
    internal lateinit var iv: ImageView
    internal var repetir = 2
    internal var posicion = 0

    internal var vectormp = arrayOfNulls<MediaPlayer>(4)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_pause = findViewById<View>(R.id.btn_play) as Button
        btn_repetir = findViewById<View>(R.id.btn_repetir) as Button
        iv = findViewById<View>(R.id.imageView) as ImageView

        vectormp[0] = MediaPlayer.create(this, R.raw.adan)
        vectormp[1] = MediaPlayer.create(this, R.raw.culpa)
        vectormp[2] = MediaPlayer.create(this, R.raw.bien)

    }

    // Metodo para el boton PlayPause
    fun PlayPause(view: View) {
        if (vectormp[posicion]!!.isPlaying()) {
            vectormp[posicion]!!.pause()
            play_pause.setBackgroundResource(R.drawable.reproducir)
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show()
        } else {
            vectormp[posicion]!!.start()
            play_pause.setBackgroundResource(R.drawable.pausa)
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
        }
    }

    // Metodo para stop
    fun Stop(view: View) {
        if (vectormp[posicion] != null) {
            vectormp[posicion]!!.stop()

            vectormp[0] = MediaPlayer.create(this, R.raw.adan)
            vectormp[1] = MediaPlayer.create(this, R.raw.culpa)
            vectormp[2] = MediaPlayer.create(this, R.raw.bien)
            posicion = 0
            play_pause.setBackgroundResource(R.drawable.reproducir)
            iv.setImageResource(R.drawable.portada1)
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()

        }
    }

    // Metodo repetir una pista de audio
    fun Repetir(view: View) {
        if (repetir == 1) {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir)
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show()
            vectormp[posicion]!!.setLooping(false)
            repetir = 2
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir)
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show()
            vectormp[posicion]!!.setLooping(true)
            repetir = 1

        }
    }

    // Boton para la siguiente cancion
    fun Siguiente(view: View) {
        if (posicion < vectormp.size - 1) {
            if (vectormp[posicion]!!.isPlaying()) {
                vectormp[posicion]!!.stop()
                posicion++
                vectormp[posicion]!!.start()


                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1)
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2)
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3)
                }
            } else {
                posicion++
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1)
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2)
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3)
                }

            }

        } else {
            Toast.makeText(this, "No hay más canciones disponibles", Toast.LENGTH_SHORT).show()

        }

    }

    // Metodo para regresar a la cancion anterior

    fun Anterior(view: View) {
        if (posicion >= 1) {

            if (vectormp[posicion]!!.isPlaying()) {
                vectormp[posicion]!!.stop()
                vectormp[0] = MediaPlayer.create(this, R.raw.adan)
                vectormp[1] = MediaPlayer.create(this, R.raw.culpa)
                vectormp[2] = MediaPlayer.create(this, R.raw.bien)
                posicion--

                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1)
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2)
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3)
                }
                vectormp[posicion]!!.start()

            } else {
                posicion--

                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1)
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2)
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3)
                }
            }
        } else {
            Toast.makeText(this, "No hay más canciones disponibles", Toast.LENGTH_SHORT).show()
        }
    }
}
