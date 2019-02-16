package com.example.reproductorisa;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.adan);
        vectormp[1] = MediaPlayer.create(this, R.raw.culpa);
        vectormp[2] = MediaPlayer.create(this, R.raw.bien);

    }

    // Metodo para el boton PlayPause
    public void PlayPause (View view){
        if(vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        }else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }
    }

    // Metodo para stop
    public void Stop(View view){
        if(vectormp[posicion]!= null){
    }
}
