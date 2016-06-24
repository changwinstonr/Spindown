package affinity.spindown.DieLogic;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import affinity.spindown.R;

/**
 * Created by 4th3ist on 6/24/2016.
 */
public class DieCheck extends AppCompatActivity{
    public void processFormula(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextDie);
        String formula = editText.getText().toString(); //Input

        if (formula.length()==0) { //Check input
            return;
        }
        formula.toLowerCase();
        int diceSize=0, diceCount=0, diceRoll=0;
        String formula_arr[] = StringUtils.separate(formula);
        if (formula_arr[1].equals("d")) {
            diceCount=Integer.parseInt(formula_arr[0], 10);
            diceSize=Integer.parseInt(formula_arr[2], 10);
            for(int d=1; d <= diceCount; d++){
                diceRoll += DiceRollerShared.rollDice(diceSize);
            }
        }
        if (formula_arr[0].equals("d")) {
            diceSize=Integer.parseInt(formula_arr[1], 10);
            diceRoll=DiceRollerShared.rollDice(diceSize);
        }
        //Display DiceRoll
    }

}
