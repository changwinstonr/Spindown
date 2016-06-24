package affinity.spindown;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class OnePlayerActivity extends Fragment {

        Button getRight, getLeft;
        TextView tv;
        int counterPlayer;

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
        //Inflate our spinner; this is a special case because of fragment (needs inflater)
        menu.clear();
        inflater.inflate(R.menu.menu_layout, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //User selects settings icon
        if (item.getItemId() == R.id.reset) {
            updateUI();
        }
        return false;
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
}


