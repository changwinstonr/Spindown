package affinity.spindown;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class OnePlayerActivity extends Fragment {

        Button getBottomRight, getBottomLeft, getRight, getLeft;
        //    TextView getTopPlayerTop, getTopPlayerBottom, getBottomPlayerBottom, getBottomPlayerTop;
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
            View view = inflater.inflate(R.layout.activity_main, container, false);


//        getBottomRight = (Button) view.findViewById(R.id.bottomRight);
//        getBottomLeft = (Button) view.findViewById(R.id.bottomLeft);
            getRight = (Button) view.findViewById(R.id.right);
            getLeft = (Button) view.findViewById(R.id.left);
            tv = (TextView) view.findViewById(R.id.textView);

//        getTopPlayerTop = (TextView) view.findViewById(R.id.topPlayerTop);
//        getTopPlayerBottom = (TextView) view.findViewById(R.id.topPlayerBottom);
//        getBottomPlayerTop = (TextView) view.findViewById(R.id.bottomPlayerTop);
//        getBottomPlayerBottom = (TextView) view.findViewById(R.id.bottomPlayerBottom);


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

