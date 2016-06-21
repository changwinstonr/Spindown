package affinity.spindown;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
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
            counterPlayer = 0;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
                savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_one_player, container, false);

            getRight = (Button) view.findViewById(R.id.right);
            getLeft = (Button) view.findViewById(R.id.left);
            tv = (TextView) view.findViewById(R.id.textView);

            //Add to 1st player life
            getLeft.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    counterPlayer+=1;
                    String counter = Integer.toString(counterPlayer);
                    tv.setText(counter);

                }
            });

            //Subtract to 1st player life
            getRight.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    counterPlayer-=1;
                    String counter = Integer.toString(counterPlayer);
                    tv.setText(counter);
                }
            });

            return view;
        }
    }

