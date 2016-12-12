package com.leemutech.org.salesbot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private ImageView imageView_one = null;
    private ImageView imageView_two = null;
    Timer MyTimer;
    long animation_clock = 3000;

    Animation animation_zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView_one = (ImageView) findViewById(R.id.imageviewOne);
        imageView_two = (ImageView) findViewById(R.id.imageViewtwo);
        animation_zoom = AnimationUtils.loadAnimation(this, R.drawable.zoom);

    }


    @Override
    protected void onResume() {
        super.onResume();


        MyTimer = new Timer();
        MyTimer.scheduleAtFixedRate(new FadeTimerTask(), animation_clock, animation_clock);


        //===============Splash
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 8000);
        //=========================
    }


    @Override
    protected void onPause() {
        super.onPause();
        MyTimer.cancel();
        MyTimer = null;
    }

    private void crossfade() {
        if (imageView_two.getVisibility() == View.VISIBLE) {
            _crossfade(imageView_one, imageView_two);
        } else {
            _crossfade(imageView_two, imageView_one);
        }
    }

    @SuppressLint("NewApi")
    private void _crossfade(View fadeIn, final View fadeOut) {

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        fadeIn.setAlpha(0f);
        fadeIn.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        fadeIn.animate()
                .alpha(1f)
                .setDuration(1000)
                .setListener(null).start();

        // Zoom content view

        fadeIn.animate()
                .scaleX((float) 1.10)
                .scaleY((float) 1.10)
                .setDuration(animation_clock - 50).start();

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        fadeOut.animate()
                .alpha(0f)
                .setDuration(1000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        fadeOut.setVisibility(View.GONE);
                        fadeOut.setScaleX((float) 1.0);
                        fadeOut.setScaleY((float) 1.0);
                    }
                }).start();
    }


    private class FadeTimerTask extends TimerTask {


        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    crossfade();
                }
            });
        }
    }
}
