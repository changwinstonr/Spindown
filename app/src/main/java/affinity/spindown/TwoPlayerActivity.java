package affinity.spindown;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TwoPlayerActivity extends Fragment {

    Button getRightP2, getLeftP2, getRight, getLeft;
    TextView getTopPlayerTop, getTopPlayerBottom, getBottomPlayerBottom, getBottomPlayerTop;
    TextView tv, tv2;
    int counterPlayerOne, counterPlayerTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Edit counter with settings options; for now, default: 0
        counterPlayerOne = 0;
        counterPlayerTwo = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_two_player, container, false);


        getRightP2 = (Button) view.findViewById(R.id.rightP2);
        getLeftP2 = (Button) view.findViewById(R.id.leftP2);
        getRight = (Button) view.findViewById(R.id.right);
        getLeft = (Button) view.findViewById(R.id.left);
        tv = (TextView) view.findViewById(R.id.textViewP1);
        tv2 = (TextView) view.findViewById(R.id.textViewP2);

//        getTopPlayerTop = (TextView) view.findViewById(R.id.topPlayerTop);
//        getTopPlayerBottom = (TextView) view.findViewById(R.id.topPlayerBottom);
//        getBottomPlayerTop = (TextView) view.findViewById(R.id.bottomPlayerTop);
//        getBottomPlayerBottom = (TextView) view.findViewById(R.id.bottomPlayerBottom);


        //Add to 1st player life
        getLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerOne += 1;
                String counter = Integer.toString(counterPlayerOne);
                tv.setText(counter);
            }
        });

        //Subtract to 1st player life
        getRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerOne -= 1;
                String counter = Integer.toString(counterPlayerOne);
                tv.setText(counter);
            }
        });

        //Add to 2nd player life
        getLeftP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerTwo += 1;
                String counter = Integer.toString(counterPlayerOne);
                tv2.setText(counter);

            }
        });

        //Subtract to 1st player life
        getRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPlayerTwo -= 1;
                String counter = Integer.toString(counterPlayerOne);
                tv2.setText(counter);
            }
        });

        return view;
    }
}


