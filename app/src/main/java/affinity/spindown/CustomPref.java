package affinity.spindown;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;


public class CustomPref extends AppCompatActivity {

    private EditText playerOne, playerTwo, playerThree, playerFour;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private SeekBar seekBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_pref);

        SharedPreferences customSharedPreference = getSharedPreferences("customSharedPrefs",
                Activity.MODE_PRIVATE);

        //PlayerOne
        playerOne = (EditText) findViewById(R.id.editText1);
        playerOne.setText(customSharedPreference.getString("editTextPref", ""));

        //PlayerTwo
        playerTwo = (EditText) findViewById(R.id.editText);
        playerTwo.setText(customSharedPreference.getString("editTextPref", ""));

        //PlayerThree
        playerThree = (EditText) findViewById(R.id.editText2);
        playerThree.setText(customSharedPreference.getString("editTextPref", ""));

        //PlayerFour
        playerFour = (EditText) findViewById(R.id.editText3);
        playerFour.setText(customSharedPreference.getString("editTextPref", ""));

        //If checkbox is false, make radiogroup invisible
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        checkBox.setChecked(customSharedPreference.getBoolean("checkBoxPref", false));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    for (int i = 0; i < radioGroup.getChildCount(); i++) {
                        radioGroup.getChildAt(i).setEnabled(false);
                    }
                    radioGroup.setAlpha(.5f);
                }
                else
                    for (int i = 0; i < radioGroup.getChildCount(); i++) {
                        radioGroup.getChildAt(i).setEnabled(true);
                    }
                radioGroup.setAlpha(1f);

            }
        });


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton radioButton0 = (RadioButton) findViewById(R.id.radio0);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioGroup.check(customSharedPreference.getInt("radioGroupPref",radioButton0.getId()));
        radioGroup.check(customSharedPreference.getInt("radioGroupPref",radioButton1.getId
                ()));

        Button mClose = (Button)findViewById(R.id.close);
        mClose.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        });

        Button mSave = (Button)findViewById(R.id.save);
        mSave.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                savePreferences();
                finish();
            }
        });

        //Adds brightness functionality to screen
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setMax(255);

        float curBrightnessValue = 0;
        try {
            curBrightnessValue = android.provider.Settings.System.getInt(
                    getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        int screen_brightness = (int) curBrightnessValue;
        seekBar.setProgress(screen_brightness);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue,
                                          boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Do nothing!
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                android.provider.Settings.System.putInt(getContentResolver(),
                        android.provider.Settings.System.SCREEN_BRIGHTNESS,
                        progress);
            }
        });

    }

    private void savePreferences(){

        SharedPreferences customSharedPreference = getSharedPreferences("customSharedPrefs",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = customSharedPreference.edit();
        editor.putString("editTextPref", playerOne.getText().toString());
        editor.putBoolean("checkBoxPref",checkBox.isChecked());
        editor.putInt("radioGroupPref", radioGroup.getCheckedRadioButtonId());
        editor.commit();

        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        Log.v("Preferences:", "Radio Text: " + radioButton.getText());
    }
}