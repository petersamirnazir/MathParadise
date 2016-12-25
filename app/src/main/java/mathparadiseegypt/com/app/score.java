package mathparadiseegypt.com.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by OM_ELNOUR on 15/12/2016.
 */

public class score {

    /**
     *
     * @param context
     * @return  score for easy mode
     */
    public static int getScoreEasy(Context context) {
        String scorefile = "SCORE_FILE";
        SharedPreferences sharedprefrence;
        sharedprefrence = context.getSharedPreferences(scorefile, MODE_PRIVATE);
        int score_easy = sharedprefrence.getInt("scoreEasy", 0);

        return score_easy;

    }



    /**
     *
     * @param context
     * @return score for normal mode
     */
    public static int getScoreNormal(Context context) {
        String scorefile = "SCORE_FILE";
        SharedPreferences sharedprefrence;
        sharedprefrence = context.getSharedPreferences(scorefile, MODE_PRIVATE);
        int score_normal = sharedprefrence.getInt("scoreNormal", 0);

        return score_normal;

    }

    /**
     *
     * @param context
     * @return score for hard mode
     */
    public static int getScoreHard(Context context) {
        String scorefile = "SCORE_FILE";
        SharedPreferences sharedprefrence;
        sharedprefrence = context.getSharedPreferences(scorefile, MODE_PRIVATE);
        int scoreHard = sharedprefrence.getInt("scoreHard", 0);

        return scoreHard;

    }

    /**
     *
     * @param context
     * @return score for score mode
     */
    public static int getScoreAdvanced(Context context) {
        String scorefile = "SCORE_FILE";
        SharedPreferences sharedprefrence;
        sharedprefrence = context.getSharedPreferences(scorefile, MODE_PRIVATE);
        int score_advanced = sharedprefrence.getInt("scoreAdvanced", 0);
       // Log.e("score in file=", "" + score_advanced);
        return score_advanced;

    }



    /**
     * save score in shared prefrence
     * @param scoreEasy
     * @param scoreNormal
     * @param scoreHard
     * @param score_advanced
     * @param context
     */
    public static void saveScore(int scoreEasy,int scoreNormal,int scoreHard,int score_advanced, Context context) {
        String scorefile = "SCORE_FILE";
        SharedPreferences pref = context.getSharedPreferences(scorefile, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        int check_score_easy = getScoreEasy(context);
        int check_score_normal = getScoreNormal(context);
        int check_score_hard = getScoreHard(context);
        int check_score_advanced = getScoreAdvanced(context);

        //check score if new score grater than score in file save new score
        if (check_score_easy < scoreEasy) {
            editor.putInt("scoreEasy", scoreEasy);
            editor.commit();
        }
        else if (check_score_normal< scoreNormal){
            editor.putInt("scoreNormal", scoreNormal);
            editor.commit();

        }
        else if (check_score_hard<scoreHard){
            editor.putInt("scoreHard", scoreHard);
            editor.commit();
        }
        else if (check_score_advanced<score_advanced) {
            editor.putInt("scoreAdvanced", score_advanced);
            editor.commit();
        }
        else {
           // Log.e("score in file", "is grater than new score " );
        }



    }


}
