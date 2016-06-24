package affinity.spindown;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declare our local variables
    Spinner mSpinner;
    List<String> mList;
    ArrayAdapter<String> mSpinnerAdapter;
    FragmentManager fragmentManager;
    Fragment fragment, fragmentTwo, fragmentThree, fragmentFour;
    long mLastPress;
//    @NOTE: Attempted to hide layout when another fragment is initiated. Another try at hiding fragments.
//    RelativeLayout playerOneLayout;

    private Toolbar toolbar;

    @NotNull
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        playerOneLayout = (RelativeLayout) findViewById(R.id.one_player);
//        DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }

    //Create our  menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate our spinner
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        mList = new ArrayList<>();
        mList.add(Integer.toString(1));
        mList.add(Integer.toString(2));
        mList.add(Integer.toString(3));
        mList.add(Integer.toString(4));

        mSpinner = (Spinner) MenuItemCompat.getActionView(item);
        mSpinnerAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, mList);
        mSpinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
//        mSpinnerAdapter.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode
//                .DARKEN);
        mSpinner.setBackgroundResource(R.drawable.ic_players_gold_36x);
        mSpinner.setAdapter(mSpinnerAdapter);
        mSpinner.setOnItemSelectedListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //User selects settings icon
        if (item.getItemId() == R.id.settings) {
            Intent settingsActivity = new Intent(getBaseContext(),
                    CustomPref.class);
            startActivity(settingsActivity);
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        fragmentManager = getFragmentManager();
        switch (position) {
            //Creates our Player 1
            case 0:
                fragment = fragmentManager.findFragmentById(R.id.one_player);
                if (fragment == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new OnePlayerActivity()).commit();
                }
//                @NOTE: Manage this when you can! Try one at hiding fragments/visibility
//                else if((fragmentManager.findFragmentById(R.id.one_player) !=
//                        null) && fragmentTwo != null){
//                    fragmentManager.beginTransaction().remove(fragmentManager
//                            .findFragmentById(R.id
//                            .two_player)).commit();
//                }
                Toast.makeText(MainActivity.this, "One Player", Toast.LENGTH_SHORT).show();
                break;

            //Creates our Player 2
            case 1:
                fragmentTwo = fragmentManager.findFragmentById(R.id.two_player);
                if (fragmentTwo == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new TwoPlayerActivity()).commit();
                }

                Toast.makeText(MainActivity.this, "Two Players", Toast.LENGTH_SHORT).show();
                break;

            //Creates our Player 3
            case 2:
                fragmentThree = fragmentManager.findFragmentById(R.id.three_player);
                if (fragmentThree == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new
                            ThreePlayerActivity()).commit();
                }
                Toast.makeText(MainActivity.this, "Three Players", Toast.LENGTH_SHORT).show();
                break;

            //Creates our Player 4
            case 3:
                fragmentFour = fragmentManager.findFragmentById(R.id.four_player);
                if (fragmentFour == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new
                            FourPlayerActivity()).commit();
                }
                Toast.makeText(MainActivity.this, "Four Players", Toast.LENGTH_SHORT).show();
                break;

            //Default to a toast. Needn't be worried by this, gov'nor!
            default:
                Toast.makeText(MainActivity.this, "No Players..?", Toast.LENGTH_SHORT).show();
        }
//        diceRoll = fragmentManager.findFragmentById(R.id.fragment_dice)
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Asks user to press BACK twice to exit. Prevents accidental app close on main/frags
    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - mLastPress > 5000){
            Toast.makeText(getBaseContext(), "Press BACK again to exit.", Toast.LENGTH_SHORT).show();
            mLastPress = currentTime;
        }else{
           super.onBackPressed();
        }
    }
}



