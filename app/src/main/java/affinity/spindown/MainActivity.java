package affinity.spindown;

import android.annotation.TargetApi;
import android.os.Build;
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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declare our variables
    Spinner mSpinner;
    ArrayAdapter<CharSequence> mSpinnerAdapter;
    FragmentManager fragmentManager;
    Fragment fragment, fragmentTwo, fragmentThree, fragmentFour;
    RelativeLayout playerOneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneLayout = (RelativeLayout) findViewById(R.id.one_player);

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



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        fragmentManager = getFragmentManager();
        switch(position){
            case 0:
                fragment = fragmentManager.findFragmentById(R.id.one_player);
                if (fragment == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new OnePlayerActivity()).commit();
                }
//                else if((fragmentManager.findFragmentById(R.id.one_player) !=
//                        null) && fragmentTwo != null){
//                    fragmentManager.beginTransaction().remove(fragmentManager
//                            .findFragmentById(R.id
//                            .two_player)).commit();
//                }

                Toast.makeText(MainActivity.this, "One Player", Toast.LENGTH_SHORT).show();

                break;
            case 1:
                fragmentTwo = fragmentManager.findFragmentById(R.id.two_player);
                if (fragmentTwo == null ) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new TwoPlayerActivity()).commit();
                }
//                else if(fragmentTwo != null && (fragmentManager.findFragmentById(R.id.one_player) !=
//                    null)){
////                    playerOneLayout.setVisibility(parent.GONE);
//                    fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id
//                            .one_player)).commit();
//                }


                Toast.makeText(MainActivity.this, "Two Players", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                fragmentThree = fragmentManager.findFragmentById(R.id.three_player);
                if (fragmentThree == null ) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new
                            ThreePlayerActivity()).commit();
                }

                Toast.makeText(MainActivity.this, "Three Players", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "Four Players", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(MainActivity.this, "No Players..?", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
