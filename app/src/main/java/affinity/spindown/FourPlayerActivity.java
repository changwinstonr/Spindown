package affinity.spindown;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FourPlayerActivity extends Fragment {


    Button getRightP4, getLeftP4, getRightP3, getLeftP3, getRightP2, getLeftP2, getRightP1,
            getLeftP1, Reset;
    TextView tv, tv2, tv3, tv4;
    int counterPlayerOne, counterPlayerTwo, counterPlayerThree, counterPlayerFour;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Edit counter with settings options; for now, default: 0
        counterPlayerOne = 0;
        counterPlayerTwo = 0;
        counterPlayerThree = 0;
        counterPlayerFour = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_four_player, container, false);

        getRightP4  = (Button) view.findViewById(R.id.rightP4);
        getLeftP4   = (Button) view.findViewById(R.id.leftP4);
        getRightP3  = (Button) view.findViewById(R.id.rightP3);
        getLeftP3   = (Button) view.findViewById(R.id.leftP3);
        getRightP2  = (Button) view.findViewById(R.id.rightP2);
        getLeftP2   = (Button) view.findViewById(R.id.leftP2);
        getRightP1    = (Button) view.findViewById(R.id.rightP1);
        getLeftP1     = (Button) view.findViewById(R.id.leftP1);
        tv          = (TextView) view.findViewById(R.id.textViewP1);
        tv2         = (TextView) view.findViewById(R.id.textViewP2);
        tv3         = (TextView) view.findViewById(R.id.textViewP3);
        tv4         = (TextView) view.findViewById(R.id.textViewP4);
        Reset       = (Button) view.findViewById(R.id.button);


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


        //Add to 3rd player life
        getRightP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerThree += 1;
                String counter = Integer.toString(counterPlayerThree);
                tv3.setText(counter);
            }
        });

        //Subtract to 3rd player life
        getLeftP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerThree -= 1;
                String counter = Integer.toString(counterPlayerThree);
                tv3.setText(counter);
            }
        });


        //Add to 4th player life
        getRightP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerFour += 1;
                String counter = Integer.toString(counterPlayerFour);
                tv4.setText(counter);
            }
        });

        //Subtract to 4th player life
        getLeftP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerFour -= 1;
                String counter = Integer.toString(counterPlayerFour);
                tv4.setText(counter);
            }
        });

        //Reset player 1 and 2 and 3 and 4 life
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerOne=0;
                counterPlayerTwo=0;
                counterPlayerThree=0;
                counterPlayerFour=0;
                String counter = Integer.toString(counterPlayerOne);
                String counterTwo = Integer.toString(counterPlayerTwo);
                String counterThree = Integer.toString(counterPlayerThree);
                String counterFour = Integer.toString(counterPlayerFour);
                tv.setText(counter);
                tv2.setText(counterTwo);
                tv3.setText(counterThree);
                tv4.setText(counterFour);
            }
        });

        return view;
    }

}
