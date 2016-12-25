package mathparadiseegypt.com.app;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HighScoreActivity extends AppCompatActivity {

    TextView tvHighScoreEasy,tvHighScoreNormal,tvHighScoreHard,tvHighScoreAdvanced , tvTitleHighScore;
    String highScoreEasy ="",highScoreNormal ="",highScoreHard ="",highScoreAdvanced ="";
    Typeface myTypeFace;
    ImageView ivFireWorks1 , ivFireWorks2;
    ImageButton back;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        myTypeFace = Typeface.createFromAsset(getAssets(), "grinched_2_0_regular.ttf");

        tvHighScoreEasy =(TextView) findViewById(R.id.tvHighScoreEasy);
        tvHighScoreNormal =(TextView) findViewById(R.id.tvHighScoreNormal);
        tvHighScoreHard =(TextView) findViewById(R.id.tvHighScoreHard);
        tvHighScoreAdvanced =(TextView) findViewById(R.id.tvHighScoreAdvanced);

        tvTitleHighScore =(TextView) findViewById(R.id.tvTitleHighScore);

        highScoreEasy = String.valueOf(score.getScoreEasy(getApplicationContext()));
        highScoreNormal = String.valueOf(score.getScoreNormal(getApplicationContext()));
        highScoreHard = String.valueOf(score.getScoreHard(getApplicationContext()));
        highScoreAdvanced = String.valueOf(score.getScoreAdvanced(getApplicationContext()));


        tvHighScoreEasy.setText(highScoreEasy);
        tvHighScoreNormal.setText(highScoreNormal);
        tvHighScoreHard.setText(highScoreHard);
        tvHighScoreAdvanced.setText(highScoreAdvanced);

        tvHighScoreEasy.setTypeface(myTypeFace);
        tvHighScoreNormal.setTypeface(myTypeFace);
        tvHighScoreHard.setTypeface(myTypeFace);
        tvHighScoreAdvanced.setTypeface(myTypeFace);


        tvTitleHighScore.setTypeface(myTypeFace);
        ivFireWorks1 = (ImageView) findViewById(R.id.ivFireWorks1);
        ivFireWorks2 = (ImageView) findViewById(R.id.ivFireWorks2);


        mathParadise.gifLoad(getApplicationContext(),ivFireWorks1,R.drawable.animated_fireworks_image);
        mathParadise.gifLoad(getApplicationContext(),ivFireWorks2,R.drawable.animated_fireworks_image);



        back=(ImageButton)findViewById(R.id.ibBack);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mathParadise.buttonAnimation(getApplicationContext(), back);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                onPause();
                finish();



            }

        });


    }


    @Override
    protected void onPause() {
        if (this.isFinishing()){ //basically BACK was pressed from this activity
            player.stop();
            // Toast.makeText(HighScoreActivity.this, "YOU PRESSED BACK FROM YOUR 'HOME/MAIN' ACTIVITY", Toast.LENGTH_SHORT).show();
        }
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                player.stop();
                // Toast.makeText(HighScoreActivity.this, "YOU LEFT YOUR APP", Toast.LENGTH_SHORT).show();
            }
            else {
                // Toast.makeText(HighScoreActivity.this, "YOU SWITCHED ACTIVITIES WITHIN YOUR APP", Toast.LENGTH_SHORT).show();
            }
        }
        super.onStop();
    }

    @Override
    protected void onStop() {
        player.stop();
        player.release();
        super.onStop();
    }

    @Override
    protected void onResume() {
        player = MediaPlayer.create(HighScoreActivity.this,R.raw.viewscore);
        player.setLooping(true);
        player.start();
        super.onResume();
    }
}

