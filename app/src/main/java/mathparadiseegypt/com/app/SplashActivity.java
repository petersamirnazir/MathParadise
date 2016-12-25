package mathparadiseegypt.com.app;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.List;

public class SplashActivity extends AppCompatActivity {


    private ImageView cloud_left,cloud_right,sparcle,math,boy;
    ImageView light_rotate;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        player = MediaPlayer.create(SplashActivity.this,R.raw.app_music);
        player.start();

        cloud_left=(ImageView)findViewById(R.id.cloud_left_splash);
        cloud_right=(ImageView)findViewById(R.id.cloud_right_splash);
        sparcle=(ImageView)findViewById(R.id.sparcle_splash);
        math=(ImageView)findViewById(R.id.math_paradise);
        boy=(ImageView)findViewById(R.id.boy_splash);
        light_rotate=(ImageView)findViewById(R.id.light_round_splash);

        splash_animation();

    }



    // all content animation except light round
    public void splash_animation() {

        Animation cloud_left_anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.trans_left_cloud);
        cloud_left.startAnimation(cloud_left_anim);

        Animation cloud_right_anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.trans_right_cloud);
        cloud_right.startAnimation(cloud_right_anim);


        Animation trans_sparcle_up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.trans_sparcle_up);
        sparcle.startAnimation(trans_sparcle_up);


        Animation trans_math_down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.trans_math_down);
        math.startAnimation(trans_math_down);


        Animation boy_anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.boy_animation);
        boy.startAnimation(boy_anim);
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {

            Thread timer = new Thread() {
                public void run() {
                    try {
                        sleep(4000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {

                            player.pause();
                            Intent i = new Intent(SplashActivity.this, MainActivity.class);
                            mathParadise.tranitionActivity(SplashActivity.this);
                            startActivity(i);
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            timer.start();
        } else {

        }
    }






}
