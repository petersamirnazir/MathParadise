package mathparadiseegypt.com.app;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameModeActivity extends AppCompatActivity {

    ImageButton ibEasy, ibNormal, ibHard, ibAdvanced,back;
    String mode = "";
    ImageView ivGirl ,ivBoy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
        ibEasy = (ImageButton) findViewById(R.id.bEasy);
        ibNormal = (ImageButton) findViewById(R.id.bNormal);
        ibHard = (ImageButton) findViewById(R.id.bHard);
        ibAdvanced = (ImageButton) findViewById(R.id.bAdvanced);
        ivGirl = (ImageView) findViewById(R.id.ivGirl);
        ivBoy = (ImageView) findViewById(R.id.ivBoy);

        mathParadise.boyGirlMainActivity(getApplicationContext(),ivGirl,ivBoy);

        ibEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = "easy";
                mathParadise.buttonAnimation(getApplicationContext(), ibEasy);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                Intent i = new Intent(getApplicationContext(),PlayActivity.class);



                i.putExtra("mode",mode);
                startActivity(i);
            }
        });

        ibNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = "normal";
                mathParadise.buttonAnimation(getApplicationContext(), ibNormal);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                Intent i = new Intent(getApplicationContext(),PlayActivity.class);
                i.putExtra("mode",mode);

                startActivity(i);
            }
        });

        ibHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = "hard";
                mathParadise.buttonAnimation(getApplicationContext(), ibHard);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                Intent i = new Intent(getApplicationContext(),PlayActivity.class);
                i.putExtra("mode",mode);




                startActivity(i);
            }
        });

        ibAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = "advanced";
                mathParadise.buttonAnimation(getApplicationContext(), ibAdvanced);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);
                Intent i = new Intent(getApplicationContext(),PlayActivity.class);
                i.putExtra("mode",mode);

                startActivity(i);
            }
        });


        back=(ImageButton)findViewById(R.id.ibBack);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mathParadise.buttonAnimation(getApplicationContext(), back);
                mathParadise.setAudioPlayer("button",getApplicationContext(),false);

                 finish();


            }

        });
    }



    @Override
    protected void onResume() {
        super.onResume();

    }
}


