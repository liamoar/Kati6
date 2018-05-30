package com.example.welcome.kati6;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class LoadingActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);

        WaveLoadingView mWaveLoadingView = findViewById(R.id.waveLoadingView);
        mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);
//        mWaveLoadingView.setCenterTitleColor(Color.GRAY);
        mWaveLoadingView.setBottomTitleSize(18);
        mWaveLoadingView.setProgressValue(50);
        mWaveLoadingView.setBorderWidth(4);
        mWaveLoadingView.setAmplitudeRatio(60);
//        mWaveLoadingView.setWaveColor(Color.GRAY);
//        mWaveLoadingView.setBorderColor(Color.GRAY);
//        mWaveLoadingView.setTopTitleStrokeColor(Color.BLUE);
        mWaveLoadingView.setTopTitleStrokeWidth(3);
        mWaveLoadingView.setAnimDuration(2000);
        mWaveLoadingView.startAnimation();

        //intent
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadingActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
