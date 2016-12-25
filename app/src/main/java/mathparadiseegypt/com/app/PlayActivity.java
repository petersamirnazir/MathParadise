package mathparadiseegypt.com.app;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    TextView tvNumber1 , tvNumber2 ,tvHowMany , tvAnswerNumber ,tvScore,tv_score_tv,tv_mode,tv_mode_t;
    Button bAnswer1 , bAnswer2 , bAnswer3 , bAnswer1E , bAnswer2E , bAnswer3E ;
    ImageButton ibNextQuestionWrong , ibNextQuestionRight;
    ImageView ivSign , ivGirl , ivBoy;
    String mode = "";
    LinearLayout llEasy,llNormal;
    GridLayout glEasy;
    int noofImages = 0 , rightResult = 0 ;
    Typeface myTypeface;
    RelativeLayout rlRightAnswer , rlWrongAnswer;


    ImageButton back;

    ToggleButton sound;

    MediaPlayer player;

    int disablecounter = 0;
    boolean chec_sound=false;

    int score_easy = 0;
    int score_normal = 0;
    int score_hard = 0;
    int score_advanced = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ibNextQuestionWrong = (ImageButton) findViewById(R.id.ibNextQuestionWrong);
        ibNextQuestionRight = (ImageButton) findViewById(R.id.ibNextQuestionRight);
        rlRightAnswer = (RelativeLayout) findViewById(R.id.rlRightAnswer);
        rlWrongAnswer = (RelativeLayout) findViewById(R.id.rlWrongAnswer);
        myTypeface = Typeface.createFromAsset(getAssets(), "grinched_2_0_regular.ttf");
        tvHowMany= (TextView)findViewById(R.id.tvHowMany);
        tvHowMany.setTypeface(myTypeface);
        ivGirl = (ImageView) findViewById(R.id.ivGirl);
        ivBoy = (ImageView) findViewById(R.id.ivBoy);

        tvScore=(TextView)findViewById(R.id.tv_score);
        tvScore.setTypeface(myTypeface);

        tv_score_tv=(TextView)findViewById(R.id.tv_score_t);
        tv_score_tv.setTypeface(myTypeface);

        tv_mode_t=(TextView)findViewById(R.id.tv_mode_t);
        tv_mode_t.setTypeface(myTypeface);

        tv_mode=(TextView)findViewById(R.id.tv_mode);
        tv_mode.setTypeface(myTypeface);



        mathParadise.boyGirlMainActivity(getApplicationContext(),ivGirl,ivBoy);

        Intent i = getIntent();
        mode = i.getStringExtra("mode");
        //set mode
        tv_mode.setText(""+mode);

        if (mode.equals("easy")){
            glEasy = (GridLayout) findViewById(R.id.glEasy);
            bAnswer1E = (Button) findViewById(R.id.bAnswer1E);
            bAnswer2E = (Button) findViewById(R.id.bAnswer2E);
            bAnswer3E = (Button) findViewById(R.id.bAnswer3E);
            llEasy = (LinearLayout) findViewById(R.id.llEasy);
            llEasy.setVisibility(View.VISIBLE);
            noofImages = mathParadise.playEasy(glEasy,getApplicationContext(),bAnswer1E,bAnswer2E,bAnswer3E);

            bAnswer1E.setTypeface(myTypeface);
            bAnswer2E.setTypeface(myTypeface);
            bAnswer3E.setTypeface(myTypeface);


            bAnswer1E.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {


                    if (Integer.parseInt(bAnswer1E.getText().toString()) == noofImages) {
                        showAnswer(ibNextQuestionRight, rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                        showScore();


                    } else {
                        showAnswer(ibNextQuestionWrong, rlWrongAnswer);
                        disablecounter++;
                    }

                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1E.setClickable(false);
                        bAnswer2E.setClickable(false);
                        bAnswer3E.setClickable(false);
                        disablecounter= 0;
                    }


                }
            });

            bAnswer2E.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {


                    if (Integer.parseInt(bAnswer2E.getText().toString()) == noofImages) {
                        showAnswer(ibNextQuestionRight, rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                        showScore();


                    } else {
                        showAnswer(ibNextQuestionWrong, rlWrongAnswer);
                        disablecounter++;

                    }

                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1E.setClickable(false);
                        bAnswer2E.setClickable(false);
                        bAnswer3E.setClickable(false);
                        disablecounter =0;
                    }


                }
            });

            bAnswer3E.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer3E.getText().toString()) == noofImages) {
                        showAnswer(ibNextQuestionRight, rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                        showScore();


                    } else {
                        showAnswer(ibNextQuestionWrong, rlWrongAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not
                    }

                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1E.setClickable(false);
                        bAnswer2E.setClickable(false);
                        bAnswer3E.setClickable(false);
                        disablecounter = 0;
                    }

                }
            });


        }
        else if (mode.equals("normal")){
            tvNumber1 = (TextView) findViewById(R.id.tvNumber1);
            tvNumber2 = (TextView) findViewById(R.id.tvNumber2);
            tvAnswerNumber = (TextView) findViewById(R.id.tvAnswerNumber);
            bAnswer1 = (Button) findViewById(R.id.bAnswer1);
            bAnswer2 = (Button) findViewById(R.id.bAnswer2);
            bAnswer3 = (Button) findViewById(R.id.bAnswer3);
            ivSign = (ImageView) findViewById(R.id.ivSign);
            llNormal = (LinearLayout) findViewById(R.id.llNormal);

            llNormal.setVisibility(View.VISIBLE);

            tvNumber1.setTypeface(myTypeface);
            tvNumber2.setTypeface(myTypeface);
            tvAnswerNumber.setTypeface(myTypeface);
            bAnswer1.setTypeface(myTypeface);
            bAnswer2.setTypeface(myTypeface);
            bAnswer3.setTypeface(myTypeface);



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                tvAnswerNumber.setBackground(getResources().getDrawable(R.drawable.q_mark));
            }

            rightResult = mathParadise.playNormal(tvNumber1,tvNumber2,bAnswer1,bAnswer2,bAnswer3,ivSign);

            bAnswer1.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer1.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not
                        showScore();


                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++;
                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }

                }
            });

            bAnswer2.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer2.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not
                        showScore();

                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++;
                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });

            bAnswer3.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer3.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not
                        showScore();



                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++;
                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });
        }
        else if (mode.equals("hard")){
            tvNumber1 = (TextView) findViewById(R.id.tvNumber1);
            tvNumber2 = (TextView) findViewById(R.id.tvNumber2);
            tvAnswerNumber = (TextView) findViewById(R.id.tvAnswerNumber);
            bAnswer1 = (Button) findViewById(R.id.bAnswer1);
            bAnswer2 = (Button) findViewById(R.id.bAnswer2);
            bAnswer3 = (Button) findViewById(R.id.bAnswer3);
            ivSign = (ImageView) findViewById(R.id.ivSign);
            llNormal = (LinearLayout) findViewById(R.id.llNormal);

            llNormal.setVisibility(View.VISIBLE);
            tvNumber1.setTypeface(myTypeface);
            tvNumber2.setTypeface(myTypeface);
            tvAnswerNumber.setTypeface(myTypeface);
            bAnswer1.setTypeface(myTypeface);
            bAnswer2.setTypeface(myTypeface);
            bAnswer3.setTypeface(myTypeface);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                tvAnswerNumber.setBackground(getResources().getDrawable(R.drawable.q_mark));
            }


            rightResult = mathParadise.playHard(tvNumber1,tvNumber2,bAnswer1,bAnswer2,bAnswer3,ivSign);

            bAnswer1.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer1.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);

                        disablecounter++;
                        showScore();

                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++;
                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });

            bAnswer2.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer2.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);

                        disablecounter++; ///the counter of checking if user pressed or not

                        showScore();

                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });

            bAnswer3.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer3.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                        showScore();


                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });
        }

        else if (mode.equals("advanced")){
            tvNumber1 = (TextView) findViewById(R.id.tvNumber1);
            tvNumber2 = (TextView) findViewById(R.id.tvNumber2);
            tvAnswerNumber = (TextView) findViewById(R.id.tvAnswerNumber);
            bAnswer1 = (Button) findViewById(R.id.bAnswer1);
            bAnswer2 = (Button) findViewById(R.id.bAnswer2);
            bAnswer3 = (Button) findViewById(R.id.bAnswer3);
            ivSign = (ImageView) findViewById(R.id.ivSign);
            llNormal = (LinearLayout) findViewById(R.id.llNormal);

            llNormal.setVisibility(View.VISIBLE);

            tvNumber1.setTypeface(myTypeface);
            tvNumber2.setTypeface(myTypeface);
            tvAnswerNumber.setTypeface(myTypeface);
            bAnswer1.setTypeface(myTypeface);
            bAnswer2.setTypeface(myTypeface);
            bAnswer3.setTypeface(myTypeface);


            rightResult = mathParadise.playAdvanced(tvNumber1,tvNumber2,tvAnswerNumber,bAnswer1,bAnswer2,bAnswer3,ivSign,
                    (getResources().getDrawable(R.drawable.q_mark)),(getResources().getDrawable(R.drawable.chalk_on_board_not_selected)));

            bAnswer1.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer1.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);

                        disablecounter++; ///the counter of checking if user pressed or not
                        showScore();

                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });

            bAnswer2.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer2.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                        showScore();


                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++; ///the counter of checking if user pressed or not

                    }
                    if(disablecounter > 0){ /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });

            bAnswer3.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(bAnswer3.getText().toString())==rightResult){
                        showAnswer(ibNextQuestionRight,rlRightAnswer);
                        disablecounter++;  ///the counter of checking if user pressed or not
                        showScore();


                    }
                    else {
                        showAnswer(ibNextQuestionWrong,rlWrongAnswer);
                        disablecounter++;
                    }
                    if(disablecounter > 0){   /// the check after every press
                        bAnswer1.setClickable(false);
                        bAnswer2.setClickable(false);
                        bAnswer3.setClickable(false);
                        disablecounter = 0;
                    }
                }
            });
        }


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

        sound=(ToggleButton)findViewById(R.id.tbSound);
        sound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Is the toggle on?
                boolean on = ((ToggleButton) sound).isChecked();

                if (on) {

                 player.pause();

                } else {
                    player.setLooping(true);
                    player.start();
                }
            }
        });



        //play sound




    }

    public void nextQuestion(final ImageButton ibNext, final RelativeLayout rlAnswer){

        ibNext.setVisibility(View.VISIBLE);
        ibNext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                ibNext.setVisibility(View.INVISIBLE);
                if (mode.equals("easy")){
                    noofImages = mathParadise.playEasy(glEasy,getApplicationContext(),bAnswer1E,bAnswer2E,bAnswer3E);
                    bAnswer1E.setClickable(true);
                    bAnswer2E.setClickable(true);
                    bAnswer3E.setClickable(true);



                }
                else if (mode.equals("normal")){
                    rightResult = mathParadise.playNormal(tvNumber1,tvNumber2,bAnswer1,bAnswer2,bAnswer3,ivSign);


                    bAnswer1.setClickable(true);
                    bAnswer2.setClickable(true);
                    bAnswer3.setClickable(true);

                }
                else if (mode.equals("hard")){
                    rightResult = mathParadise.playHard(tvNumber1,tvNumber2,bAnswer1,bAnswer2,bAnswer3,ivSign);


                    bAnswer1.setClickable(true);
                    bAnswer2.setClickable(true);
                    bAnswer3.setClickable(true);



                }
                else if (mode.equals("advanced")){
                    rightResult = mathParadise.playAdvanced(tvNumber1,tvNumber2,tvAnswerNumber,bAnswer1,bAnswer2,bAnswer3,ivSign,
                            (getResources().getDrawable(R.drawable.q_mark)),(getResources().getDrawable(R.drawable.chalk_on_board_not_selected)));

                    bAnswer1.setClickable(true);
                    bAnswer2.setClickable(true);
                    bAnswer3.setClickable(true);

                }
                rlAnswer.setVisibility(View.INVISIBLE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showAnswer(ImageButton ibNext , RelativeLayout rlAnswer){
        rlAnswer.setVisibility(View.VISIBLE);
        if (rlAnswer == rlRightAnswer){
            mathParadise.setAudioPlayer("right_answer",getApplicationContext(),false);
        }
        else if (rlAnswer == rlWrongAnswer){
            if (mode.equals("easy")){
                mathParadise.showRightAnswer(noofImages,bAnswer1E,bAnswer2E,bAnswer3E,PlayActivity.this);
            }
            else {
                mathParadise.showRightAnswer(rightResult,bAnswer1,bAnswer2,bAnswer3,PlayActivity.this);
            }
            mathParadise.setAudioPlayer("wrong_answer",getApplicationContext(),false);
        }
        mathParadise.rightAndWrongAnswer(getApplicationContext(),rlAnswer);
        nextQuestion(ibNext,rlAnswer);
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
        player = MediaPlayer.create(PlayActivity.this,R.raw.app_music);
        player.setLooping(true);
        player.start();
        super.onResume();

    }
    /**
     * func to show score and save i save score
     *
     */
    public void showScore() {
        switch (mode) {
            case "easy":
                score_easy++;
                tvScore.setText("" + score_easy);
                score.saveScore(score_easy, 0, 0, 0, PlayActivity.this);
                break;

            case "normal":

                score_normal++;
                tvScore.setText("" + score_normal);
                score.saveScore(0, score_normal, 0, 0, PlayActivity.this);
                break;

            case "hard":
                score_hard++;
                tvScore.setText("" + score_hard);
                score.saveScore(0, 0, score_hard, 0, PlayActivity.this);
                break;

            case "advanced":
                score_advanced++;
                tvScore.setText("" + score_advanced);
                score.saveScore(0, 0, 0, score_advanced, PlayActivity.this);
                break;

        }
    }
}
