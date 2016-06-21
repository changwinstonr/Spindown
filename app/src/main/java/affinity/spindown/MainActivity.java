package affinity.spindown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declare our variables
    Spinner mSpinner;
    ArrayAdapter<CharSequence> mSpinnerAdapter;
    FragmentManager fragmentManager;
    Fragment fragment, fragmentTwo, fragmentThree, fragmentFour;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Create our  menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate our spinner
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);

        mSpinner = (Spinner) MenuItemCompat.getActionView(item);
        mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.numberPlayer, android.R.layout.simple_spinner_item);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mSpinnerAdapter);
        mSpinner.setOnItemSelectedListener(this);

        return true;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        fragmentManager = getFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.main_activity);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
