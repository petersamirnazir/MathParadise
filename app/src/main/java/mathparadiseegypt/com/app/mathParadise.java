package mathparadiseegypt.com.app;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

import static android.content.Context.CONTEXT_IGNORE_SECURITY;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Peter on 03/11/2016.
 */

public class mathParadise {

    public static int takeRandom(int max) {
        Random randNum = new Random();
        int outRand = randNum.nextInt(max);

        return outRand;
    }

    public static int randPlac() {
        Random randpos = new Random();
        int place = randpos.nextInt(3) + 1;

        return place;
    }

    public static int takeCustomeRandom(int max, int changeRange) {
        Random randNum = new Random();
        int outRand = randNum.nextInt(max - (max - changeRange)) + (max - changeRange);

        return outRand;
    }

    public static int calNormal(TextView no1, TextView no2, ImageView ivsign) {
        int num1 = takeRandom(10);
        int num2 = takeRandom(10);

        no1.setText(String.valueOf(num1));
        no2.setText(String.valueOf(num2));

        int finalres = 0;

        if (num1 < num2) {
            finalres = num1 + num2;
            ivsign.setImageResource(R.drawable.plus);


        } else {
            finalres = num1 - num2;
            ivsign.setImageResource(R.drawable.subtract);

        }

        return finalres;

    }

    public static int playNormal(TextView number1, TextView number2, Button answer1, Button answer2, Button answer3, ImageView sign) {

        int wrongNum1 = 0;
        wrongNum1 = takeRandom(15);
        int wrongNum2 = 0;
        wrongNum2 = takeRandom(15);
/*        while (wrongNum1 == wrongNum2) {         /////checking the two wrong answers if equal
            wrongNum1 = 0;
            wrongNum1 = takeRandom(15);
            wrongNum2 = 0;
            wrongNum2 = takeRandom(15);
        }*/
        int finalresult = calNormal(number1, number2, sign);

        if (wrongNum1 != finalresult && wrongNum2 != finalresult && wrongNum1!= wrongNum2) {

            switch (randPlac()) {
                case 1:
                    answer1.setText(String.valueOf(finalresult));
                    answer2.setText(String.valueOf(wrongNum1));
                    answer3.setText(String.valueOf(wrongNum2));
                    break;

                case 2:
                    answer1.setText(String.valueOf(wrongNum1));
                    answer2.setText(String.valueOf(finalresult));
                    answer3.setText(String.valueOf(wrongNum2));
                    break;

                case 3:
                    answer1.setText(String.valueOf(wrongNum1));
                    answer2.setText(String.valueOf(wrongNum2));
                    answer3.setText(String.valueOf(finalresult));
                    break;
            }
            return finalresult;
        } else {
            return playNormal(number1, number2, answer1, answer2, answer3, sign);
        }
    }

    public static int playEasy(GridLayout gl, Context context, Button answer1E, Button answer2E, Button answer3E) {
        gl.removeAllViews();
        int maxImages = takeRandom(10) + 1;
        int imageType = takeRandom(4);
        for (int i = 1; i <= maxImages; i++) {
            ImageView iv = new ImageView(context);
            switch (imageType) {
                case 0:
                    iv.setImageResource(R.drawable.apple);
                    break;
                case 1:
                    iv.setImageResource(R.drawable.bunny);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.flower);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.frog);
                    break;
            }
            gl.addView(iv);
        }
        int wrongNum1 = 0;
        wrongNum1 = takeRandom(10) + 1;
        int wrongNum2 = 0;
        wrongNum2 = takeRandom(10) + 1;
/*        while (wrongNum1 == wrongNum2) {          /////checking the two wrong answers if equal
            wrongNum1 = 0;
            wrongNum1 = takeRandom(10) + 1;
            wrongNum2 = 0;
            wrongNum2 = takeRandom(10) + 1;
        }*/
        if (wrongNum1 != maxImages && wrongNum2 != maxImages && wrongNum1!=wrongNum2) {

            switch (randPlac()) {
                case 1:

                    answer1E.setText(String.valueOf(maxImages));
                    answer2E.setText(String.valueOf(wrongNum1));
                    answer3E.setText(String.valueOf(wrongNum2));


                    break;
                case 2:

                    answer1E.setText(String.valueOf(wrongNum1));
                    answer2E.setText(String.valueOf(maxImages));
                    answer3E.setText(String.valueOf(wrongNum2));
                    break;
                case 3:
                    answer1E.setText(String.valueOf(wrongNum1));
                    answer2E.setText(String.valueOf(wrongNum2));
                    answer3E.setText(String.valueOf(maxImages));
                    break;


            }
            return maxImages;
        } else {
            return playEasy(gl, context, answer1E, answer2E, answer3E);
        }
    }

    public static int calHard(TextView no1, TextView no2, ImageView ivSign) {
        int num1 = takeRandom(10) + 1;
        int num2 = takeRandom(10) + 1;

        no1.setText(String.valueOf(num1));
        no2.setText(String.valueOf(num2));

        int finalRes = 0;

        if (num1 % num2 == 0) {
            finalRes = num1 / num2;
            ivSign.setImageResource(R.drawable.divid);
        } else {
            finalRes = num1 * num2;
            ivSign.setImageResource(R.drawable.x);
        }

        return finalRes;
    }

    public static int playHard(TextView number1, TextView number2, Button answer1, Button answer2, Button answer3, ImageView sign) {


        int finalResult = calHard(number1, number2, sign);
        int wrongNum1 = 0;
        wrongNum1 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
        int wrongNum2 = 0;
        wrongNum2 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
/*        while (wrongNum1 == wrongNum2) {          /////checking the two wrong answers if equal
            wrongNum1 = 0;
            wrongNum1 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
            wrongNum2 = 0;
            wrongNum2 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
        }*/


        if (wrongNum1 != finalResult && wrongNum2 != finalResult && wrongNum1!=wrongNum2) {

            switch (randPlac()) {
                case 1:
                    answer1.setText(String.valueOf(finalResult));
                    answer2.setText(String.valueOf(wrongNum1));
                    answer3.setText(String.valueOf(wrongNum2));
                    break;

                case 2:
                    answer1.setText(String.valueOf(wrongNum1));
                    answer2.setText(String.valueOf(finalResult));
                    answer3.setText(String.valueOf(wrongNum2));
                    break;

                case 3:
                    answer1.setText(String.valueOf(wrongNum1));
                    answer2.setText(String.valueOf(wrongNum2));
                    answer3.setText(String.valueOf(finalResult));
                    break;
            }
            return finalResult;
        } else {
            return playHard(number1, number2, answer1, answer2, answer3, sign);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static int playAdvanced(TextView number1, TextView number2, TextView answerNumber, Button answer1, Button answer2, Button answer3, ImageView sign, Drawable qmarkDrawable, Drawable normalBackgrnd) {
        int rndModeType = takeRandom(2);
        int rndQmarkPlace = takeRandom(3);
        int finalResult = 0, resultAdvanced = 0;
        switch (rndModeType) {
            case 0:
                finalResult = calNormal(number1, number2, sign);
                break;
            case 1:
                finalResult = calHard(number1, number2, sign);
                break;
        }
        answerNumber.setText(String.valueOf(finalResult));


        switch (rndQmarkPlace) {
            case 0:
                    resultAdvanced = Integer.parseInt(number1.getText().toString());
                    number1.setBackground(qmarkDrawable);
                    number1.setText("");
                    number2.setBackground(normalBackgrnd);
                    answerNumber.setBackground(normalBackgrnd);

                break;
            case 1:
                    resultAdvanced = Integer.parseInt(number2.getText().toString());
                    number2.setBackground(qmarkDrawable);
                    number2.setText("");
                    number1.setBackground(normalBackgrnd);
                    answerNumber.setBackground(normalBackgrnd);
                break;
            case 2:
                    resultAdvanced = Integer.parseInt(answerNumber.getText().toString());
                    answerNumber.setBackground(qmarkDrawable);
                    answerNumber.setText("");
                    number1.setBackground(normalBackgrnd);
                    number2.setBackground(normalBackgrnd);
                break;

        }

        int wrongNum1 = 0;
        wrongNum1 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
        int wrongNum2 = 0;
        wrongNum2 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
/*        while (wrongNum1 == wrongNum2) {   /////checking the two wrong answers if equal
            wrongNum1 = 0;
            wrongNum1 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
            wrongNum2 = 0;
            wrongNum2 = Math.abs(takeCustomeRandom(finalResult, 5) + 1);
        }*/

        if (wrongNum1 != resultAdvanced && wrongNum2 != resultAdvanced && wrongNum1!=wrongNum2) {

            switch (randPlac()) {
                case 1:
                    answer1.setText(String.valueOf(resultAdvanced));
                    answer2.setText(String.valueOf(wrongNum1));
                    answer3.setText(String.valueOf(wrongNum2));
                    break;

                case 2:
                    answer1.setText(String.valueOf(wrongNum1));
                    answer2.setText(String.valueOf(resultAdvanced));
                    answer3.setText(String.valueOf(wrongNum2));
                    break;

                case 3:
                    answer1.setText(String.valueOf(wrongNum1));
                    answer2.setText(String.valueOf(wrongNum2));
                    answer3.setText(String.valueOf(resultAdvanced));
                    break;
            }
            return resultAdvanced;
        } else {
            return playAdvanced(number1, number2, answerNumber, answer1, answer2, answer3, sign, qmarkDrawable, normalBackgrnd);
        }

    }

    public static int getScore(Context context) {
        String scorefile = "SCORE_FILE";
        SharedPreferences sharedprefrence;
        sharedprefrence = context.getSharedPreferences(scorefile, MODE_PRIVATE);
        int score = sharedprefrence.getInt("score", 0);
        Log.e("score in file=", "" + score);
        return score;

    }

    public static void saveScore(int score, Context context) {
        String scorefile = "SCORE_FILE";
        SharedPreferences pref = context.getSharedPreferences(scorefile, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        int check_score = getScore(context);

        //check score if new score grater than score in file save new score
        if (check_score < score) {
            editor.putInt("score", score);
            editor.commit();
            Log.i("i save ", "" + score);
        } else {
            Log.i("score is less than ", "" + score);
        }


    }

    public static void setAudioPlayer(String filname, Context context, boolean stop) {
        /*
        String background_sound="R.raw.app_music";
        String viewscour_sound="R.raw.viewscore";
        String button_sound="R.raw.button";
        String wrong_answer_sound="R.raw.wrong_answer";
        String right_answer_sound="R.raw.right_answer";
        */


        //MediaPlayer mp1 = new MediaPlayer();

        stop = false;
        if (filname == "button" && stop == false) {
            MediaPlayer mp = MediaPlayer.create(context, R.raw.button);
            mp.start();
            //mp1.setDataSource(context , R.raw.button);
        } else if (filname == "app_music" && stop == false) {
            MediaPlayer mp = MediaPlayer.create(context, R.raw.app_music);
            mp.start();
            mp.setLooping(true);
            if (stop == true) {
                mp.stop();
            }
        } else if (filname == "view_score" && stop == false) {
            MediaPlayer mp = MediaPlayer.create(context, R.raw.viewscore);
            mp.start();


        } else if (filname == "wrong_answer" && stop == false) {
            MediaPlayer mp = MediaPlayer.create(context, R.raw.wrong_answer);
            mp.start();
        } else if (filname == "right_answer" && stop == false) {
            MediaPlayer mp = MediaPlayer.create(context, R.raw.right_answer);
            mp.start();

        } else {
            //do nothing

        }


    }

    public static void seek_media(Context context) {
        MediaPlayer mp = MediaPlayer.create(context, R.raw.viewscore);
        mp.seekTo((1 * 60 * 1000) + (22 * 1000));
        mp.stop();

    }

    public static void lightRotate(Context context, View view) {

        Animation rotation = AnimationUtils.loadAnimation(context, R.anim.rotate_light);
        view.startAnimation(rotation);
    }

    /**
     * fucnction for button animation
     *
     * @param context
     * @param view
     */

    public static void buttonAnimation(Context context, View view) {
        Animation rotation = AnimationUtils.loadAnimation(context, R.anim.button_animation);
        view.startAnimation(rotation);
    }

    /**
     * fucnction for button animation
     *
     * @param context
     * @param view
     */

    public static void rightAndWrongAnswer(Context context, View view) {
        Animation rotation = AnimationUtils.loadAnimation(context, R.anim.answer_dialoge);
        view.startAnimation(rotation);
    }

    /**
     * fucnction transtion between tow activity
     * activity one slide out right and another slide in right
     * simple example for use
     * Intent i = new Intent(Splash.this, score.class);
     * animation.tranitionActivity(Splash.this);
     * startActivity(i);
     * finish();
     */

    public static void tranitionActivity(Activity act) {

        act.overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_right);

    }

    /**
     * fucnction for button animation
     *
     * @param context
     * @param view
     */

    public static void boyGirlMainActivity(final Context context, final View view, final View view2) {
        Animation rotation = AnimationUtils.loadAnimation(context, R.anim.boy_and_girl_in_main_activity);
        rotation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boyGirlMainActivity(context, view2, view);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(rotation);
    }

    static void gifLoad(Context context, View view, int gif_src) {

        Glide.with(context)
                .load(gif_src)
                .asGif()  // you may not need this
                .crossFade()
                .into((ImageView) view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void showRightAnswer(int rightAnswer, Button b1, Button b2, Button b3, Context context) {
        if (Integer.parseInt(b1.getText().toString()) == rightAnswer) {
            anim(b1,false,context);


        } else if (Integer.parseInt(b2.getText().toString()) == rightAnswer) {
            anim(b2,false,context);

        } else if (Integer.parseInt(b3.getText().toString()) == rightAnswer) {
            anim(b3,false,context);

        }
    }



public static void anim(final View view, boolean stop, final Context context) {

    ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            Animation rotation = AnimationUtils.loadAnimation(context, R.anim.blink);
            view.startAnimation(rotation);
            view.setAlpha((Float) animation.getAnimatedValue());


        }
    });
    if (stop==false) {
        animator.setDuration(300);
        animator.setRepeatCount(1);
        animator.start();

    }
    else {
        animator.end();
    }


}

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void resetAnsewrs(Button b1 , Button b2, Button b3, Drawable dr){

        b1.setBackground(dr);
        b2.setBackground(dr);
        b3.setBackground(dr);


    }

}