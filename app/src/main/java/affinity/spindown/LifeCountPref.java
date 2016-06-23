package affinity.spindown;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aaron on 6/23/2016.
 */
public class LifeCountPref extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set default value from CustomPref
        SharedPreferences lifeCounterPref = getSharedPreferences("lifeCounterPref",
                Activity.MODE_PRIVATE);
    }

    private void savePreferences(){
        SharedPreferences lifeCounterPref = getSharedPreferences("lifeCounterPref",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = lifeCounterPref.edit();

//        editor.putInt("counterPlayerOne",
//        editor.commit();
    }

}
