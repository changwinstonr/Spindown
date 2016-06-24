package affinity.spindown;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
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
    //Declares buttons for life incrementer
    private RadioButton radioButton0, radioButton1;
    //Declares buttons for life counter
    private RadioButton radioButtonTwenty, radioButtonThirty, radioButtonForty;
    private SeekBar seekBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_pref);

        //Prevent keyboard from automatically opening when activity is started.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        loadPreferences();
        seekBrightness();

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

    }

    private void savePreferences(){

        SharedPreferences customSharedPreference = getSharedPreferences("customSharedPrefs",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = customSharedPreference.edit();
        editor.putString("editTextPref1", playerOne.getText().toString());
        editor.putString("editTextPref2", playerTwo.getText().toString());
        editor.putString("editTextPref3", playerThree.getText().toString());
        editor.putString("editTextPref4", playerFour.getText().toString());
        editor.putBoolean("checkBoxPref",checkBox.isChecked());
        //Needs some work; save status of either not greyed or greyed out.
        editor.putBoolean("radioButton0" , radioButton0.isChecked());
        editor.putBoolean("radioButton1" , radioButton1.isChecked());
        editor.putBoolean("radioButtonTwenty" , radioButtonTwenty.isChecked());
        editor.putBoolean("radioButtonThirty" , radioButtonThirty.isChecked());
        editor.putBoolean("radioButtonForty" , radioButtonForty.isChecked());
        editor.commit();
    }

    private void loadPreferences(){
        SharedPreferences customSharedPreference = getSharedPreferences("customSharedPrefs",
                Activity.MODE_PRIVATE);

        //PlayerOne
        playerOne = (EditText) findViewById(R.id.editText1);
        playerOne.setText(customSharedPreference.getString("editTextPref1", ""));

        //PlayerTwo
        playerTwo = (EditText) findViewById(R.id.editTextDie);
        playerTwo.setText(customSharedPreference.getString("editTextPref2", ""));

        //PlayerThree
        playerThree = (EditText) findViewById(R.id.editText2);
        playerThree.setText(customSharedPreference.getString("editTextPref3", ""));

        //PlayerFour
        playerFour = (EditText) findViewById(R.id.editText3);
        playerFour.setText(customSharedPreference.getString("editTextPref4", ""));


        //Get RadioGroup1 button values
//        int i = customSharedPreference.getInt("customSharedPrefs",-1);
//        for(;i<1; i++) {
//            if (i >= 0) {
//                ((RadioButton) ((RadioGroup) findViewById(R.id.radioGroup1)).getChildAt(i)).setChecked
//                        (true);
//            }
//        }
//        //Get RadioGroup1 button values
//        int j = customSharedPreference.getInt("customSharedPrefs",-1);
//        for(;i<2;j++) {
//
//            if (j >= 0) {
//                ((RadioButton) ((RadioGroup) findViewById(R.id.radioGroup2)).getChildAt(i)).setChecked
//                        (true);
//            }
//        }

        radioButton0 = (RadioButton) findViewById(R.id.radio0);
        radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioButtonTwenty = (RadioButton) findViewById(R.id.twenty);
        radioButtonThirty= (RadioButton) findViewById(R.id.thirty);
        radioButtonForty = (RadioButton) findViewById(R.id.forty);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);

        boolean rb0 = customSharedPreference.getBoolean("radioButton0", false);
        boolean rb1 = customSharedPreference.getBoolean("radioButton1", false);
        boolean rbTwenty= customSharedPreference.getBoolean("radioButtonTwenty", false);
        boolean rbThirty = customSharedPreference.getBoolean("radioButtonThirty", false);
        boolean rbForty = customSharedPreference.getBoolean("radioButtonForty", false);


        radioButtonTwenty.setChecked(rbTwenty);
        radioButtonThirty.setChecked(rbThirty);
        radioButtonForty.setChecked(rbForty);
        radioButton0.setChecked(rb0);
        radioButton1.setChecked(rb1);


        //If checkbox is false, make radiogroup invisible
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        checkBox.setChecked(customSharedPreference.getBoolean("checkBoxPref", false));
        //For pref. - Needs to check if checkbox is not checked, if it isn't, it won't save
        // state; hence this if check
        if(!checkBox.isChecked()){
            for(int i = 0; i < radioGroup.getChildCount(); i++){
                (radioGroup.getChildAt(i)).setEnabled(false);
            }}

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    for (int i = 0; i < radioGroup.getChildCount(); i++) {
                        radioGroup.getChildAt(i).setEnabled(true);
                    }

                }
                else if(!b) {
                    for (int i = 0; i < radioGroup.getChildCount(); i++) {
                        radioGroup.getChildAt(i).setEnabled(false);
                    }
                    radioGroup.setAlpha(1f);
                }
            }
        });

    }

    private void seekBrightness(){

        //Adds brightness functionality to screen
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setMax(255);

        float currentBrightnessVal = 0;
        try {
            currentBrightnessVal = android.provider.Settings.System.getInt(
                    getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS);
//          TODO: Tried to compensate for <uses-permission android:name="android.permission.WRITE_SETTINGS"></uses-permission> SecurityException API 23<
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (Settings.System.canWrite(context) {
//                    // Do stuff here
//                }
//                else {
//                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
//                    intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                }
//            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        int screen_brightness = (int) currentBrightnessVal;
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
}