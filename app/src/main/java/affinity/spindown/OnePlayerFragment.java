package affinity.spindown;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class OnePlayerFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    Button getRight, getLeft;
    TextView tv;
    int counterPlayer;
    Spinner mSpinner;
    List<String> mList;
    ArrayAdapter<String> mSpinnerAdapter;
    FragmentManager fragmentManager;
    Fragment fragmentTwo, fragmentThree, fragmentFour;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Edit counter with settings options; for now, default: 0
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_one_player, container, false);

            getRight = (Button) view.findViewById(R.id.right);
            getLeft  = (Button) view.findViewById(R.id.left);
            tv       = (TextView) view.findViewById(R.id.textView);

            Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "YouRookMarbelous.ttf");
            getRight.setTypeface(tf);
            getLeft.setTypeface(tf);
            tv.setTypeface(tf);

            //Add to 1st player life
            getRight.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    counterPlayer+=1;
                    String counter = Integer.toString(counterPlayer);
                    tv.setText(counter);
                }
            });

            //Subtract to 1st player life
            getLeft.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    counterPlayer-=1;
                    String counter = Integer.toString(counterPlayer);
                    tv.setText(counter);
                }
            });

            return view;
        }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //Inflate our spinner
        inflater.inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        mList = new ArrayList<>();
        mList.add(Integer.toString(1));
        mList.add(Integer.toString(2));
        mList.add(Integer.toString(3));
        mList.add(Integer.toString(4));

        mSpinner = (Spinner) MenuItemCompat.getActionView(item);
        mSpinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, mList);
        mSpinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
//        mSpinnerAdapter.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode
//                .DARKEN);
        mSpinner.setBackgroundResource(R.drawable.ic_players_gold_36x);
        mSpinner.setAdapter(mSpinnerAdapter);
        mSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //User selects settings icon
        if (item.getItemId() == R.id.reset) {
            updateUI();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
     }

    public void updateUI(){
        SharedPreferences customSharedPreference = getActivity().getSharedPreferences
                ("customSharedPrefs",
                        Activity.MODE_PRIVATE);

        if(customSharedPreference.getBoolean("radioButtonTwenty", false)){
            counterPlayer = 20;
        }
        else if(customSharedPreference.getBoolean("radioButtonThirty", false)){
            counterPlayer = 30;
        }
        else if(customSharedPreference.getBoolean("radioButtonForty", false)){
            counterPlayer = 40;
        }

        String counter = Integer.toString(counterPlayer);
        tv.setText(counter);
    }

    //Out of desperation.
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        fragmentManager = getFragmentManager();
        switch (i) {
            //Creates our Player 1
            //Creates our Player 2
            case 1:
                fragmentTwo = fragmentManager.findFragmentById(R.id.two_player);
                if (fragmentTwo == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new TwoPlayerFragment()).commit();
                }

                Toast.makeText(getActivity(), "Two Players", Toast.LENGTH_SHORT).show();
                break;

            //Creates our Player 3
            case 2:
                fragmentThree = fragmentManager.findFragmentById(R.id.three_player);
                if (fragmentThree == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new
                            ThreePlayerFragment()).commit();
                }
                Toast.makeText(getActivity(), "Three Players", Toast.LENGTH_SHORT).show();
                break;

            //Creates our Player 4
            case 3:
                fragmentFour = fragmentManager.findFragmentById(R.id.four_player);
                if (fragmentFour == null) {
                    fragmentManager.beginTransaction().add(R.id.fragmentHolder, new
                            FourPlayerFragment()).commit();
                }
                Toast.makeText(getActivity(), "Four Players", Toast.LENGTH_SHORT).show();
                break;

            //Default to a toast. Needn't be worried by this, gov'nor!
//            default:
//                Toast.makeText(getActivity(), "No Players..?", Toast.LENGTH_SHORT).show();
//                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


