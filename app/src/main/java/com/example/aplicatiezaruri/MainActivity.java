package com.example.aplicatiezaruri;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button btn;
    public ImageView zar1;
    public ImageView zar2;
    public MediaPlayer mp;
    public int[] zaruri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnZar);
        zar1 = findViewById(R.id.zar1);
        zar2 = findViewById(R.id.zar2);
        mp = MediaPlayer.create(this, R.raw.dice2);

        zaruri = new int[]{
                R.drawable.zar1,
                R.drawable.zar2,
                R.drawable.zar3,
                R.drawable.zar4,
                R.drawable.zar5,
                R.drawable.zar6,
        };

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                chanegeBtn_onplay();
                mp.start();
                changeImages();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        chanegeBtn_onstop();
                    }
                });

            }
        });
    }

    public int getRandom(int [] array){
        int random = new Random().nextInt(array.length);

        return array[random];
    }

    public void chanegeBtn_onplay(){
        btn.setEnabled(false);
        btn.setText(getResources().getString(R.string.btn_apasat));
    }
    public void chanegeBtn_onstop(){
        btn.setEnabled(true);
        btn.setText(getResources().getString(R.string.btn_neapasat));

    }

    public void changeImages(){
        zar1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zar_stanga));
        zar2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zar_dreapta));
        int poza = getRandom(zaruri);
        zar1.setImageDrawable(getResources().getDrawable(poza));
        poza = getRandom(zaruri);
        zar2.setImageDrawable(getResources().getDrawable(poza));

    }

}