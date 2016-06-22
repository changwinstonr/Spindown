package affinity.spindown;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TwoPlayerActivity extends Fragment {

    Button getRightP2, getLeftP2, getRightP1, getLeftP1, Reset;
    TextView tv, tv2;
    int counterPlayerOne, counterPlayerTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Edit counter with settings options; for now, default: 0
        counterPlayerOne = 20;
        counterPlayerTwo = 20;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_two_player, container, false);


        getRightP2  = (Button) view.findViewById(R.id.rightP2);
        getLeftP2   = (Button) view.findViewById(R.id.leftP2);
        getRightP1  = (Button) view.findViewById(R.id.rightP1);
        getLeftP1   = (Button) view.findViewById(R.id.leftP1);
        tv          = (TextView) view.findViewById(R.id.textViewP1);
        tv2         = (TextView) view.findViewById(R.id.textViewP2);
        Reset       = (Button) view.findViewById(R.id.button);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "YouRookMarbelous.ttf");
        getRightP2.setTypeface(tf);
        getLeftP2.setTypeface(tf);
        getRightP1.setTypeface(tf);
        getLeftP1.setTypeface(tf);
        tv.setTypeface(tf);
        tv2.setTypeface(tf);

        //Add to 1st player life
        getRightP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerOne += 1;
                String counter = Integer.toString(counterPlayerOne);
                tv.setText(counter);
            }
        });

        //Subtract to 1st player life
        getLeftP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerOne -= 1;
                String counter = Integer.toString(counterPlayerOne);
                tv.setText(counter);
            }
        });

        //Add to 2nd player life
        getRightP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerTwo += 1;
                String counter = Integer.toString(counterPlayerTwo);
                tv2.setText(counter);

            }
        });

        //Subtract to 2nd player life
        getLeftP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerTwo -= 1;
                String counter = Integer.toString(counterPlayerTwo);
                tv2.setText(counter);
            }
        });

        //Reset player 1 and 2 life
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerOne    = 20;
                counterPlayerTwo    = 20;
                String counter      = Integer.toString(counterPlayerOne);
                String counterTwo   = Integer.toString(counterPlayerTwo);
                tv.setText(counter);
                tv2.setText(counterTwo);
            }
        });

        return view;
    }
}


