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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;


public class CustomPref extends AppCompatActivity {

    private EditText prefEditText;
    private CheckBox prefCheckbox;
    private RadioGroup prefRadioGroup;
    private SeekBar seekBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_pref);

        SharedPreferences customSharedPreference = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);

        prefEditText = (EditText) findViewById(R.id.editText1);
        prefEditText.setText(customSharedPreference.getString("myEditTextPref", ""));

        //If checkbox is false, make radiogroup invisible
        prefCheckbox = (CheckBox) findViewById(R.id.checkBox1);
        prefCheckbox.setChecked(customSharedPreference.getBoolean("myCheckBoxPref", false));

        prefRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton radioButton0 = (RadioButton) findViewById(R.id.radio0);
        prefRadioGroup.check(customSharedPreference.getInt("myRadioGroupPref",radioButton0.getId()));

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

        SharedPreferences customSharedPreference = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = customSharedPreference.edit();
        editor.putString("myEditTextPref", prefEditText.getText().toString());
        editor.putBoolean("myCheckBoxPref",prefCheckbox.isChecked());
        editor.putInt("myRadioGroupPref", prefRadioGroup.getCheckedRadioButtonId());
        editor.commit();

        RadioButton radioButton = (RadioButton) findViewById(prefRadioGroup.getCheckedRadioButtonId());
        Log.v("Preferences:", "Radio Text: " + radioButton.getText());
    }
}