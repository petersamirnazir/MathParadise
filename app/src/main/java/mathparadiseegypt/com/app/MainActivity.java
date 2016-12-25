package mathparadiseegypt.com.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageButton ibPlay , ibHighScore , ibExit;
    Intent i;
    ImageView ivWhiteBackground , ivGirl , ivBoy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibPlay = (ImageButton) findViewById(R.id.ibPlay);
        ibHighScore = (ImageButton) findViewById(R.id.ibHighScore);
        ibExit =(ImageButton) findViewById(R.id.ibExit);
        ivWhiteBackground = (ImageView) findViewById(R.id.ivWhiteArraysBackground);
        ivGirl = (ImageView) findViewById(R.id.ivGirl);
        ivBoy = (ImageView) findViewById(R.id.ivBoy);


        mathParadise.boyGirlMainActivity(getApplicationContext(),ivGirl,ivBoy);

        ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),GameModeActivity.class);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                mathParadise.buttonAnimation(getApplicationContext(),ibPlay);
                mathParadise.tranitionActivity(MainActivity.this);


                startActivity(i);

            }
        });

        ibHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),HighScoreActivity.class);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                mathParadise.buttonAnimation(getApplicationContext(),ibHighScore);
                mathParadise.tranitionActivity(MainActivity.this);

                startActivity(i);
            }
        });

        ibExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                mathParadise.buttonAnimation(getApplicationContext(),ibExit);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
