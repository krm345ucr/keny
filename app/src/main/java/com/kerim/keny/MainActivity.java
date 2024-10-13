package com.kerim.keny;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView skortext;
    TextView suretext;
    int skor;
    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] imageArry;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        suretext = findViewById(R.id.suretext);
        skortext = findViewById(R.id.skortext);
        suretext.setText("time:10");
        skor = 0;
        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);

        imageArry = new ImageView[]{imageView0,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};
        hideimages();



        new CountDownTimer(1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                suretext.setText("süre:"+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                suretext.setText("süre:10");
                //handler.removeCallbacks(runnable);
                /*for (ImageView image :imageArry ){
                    image.setVisibility(View.INVISIBLE);
                }*/


            }
        }.start();

    }
    public void skorarttırma(View view){
        skor++;

        skortext.setText("skor:"+skor);
    }
    public void hideimages (){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image :imageArry ){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(9);
                imageArry[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }
}