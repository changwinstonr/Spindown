package affinity.spindown.DieLogic;

import java.util.Random;

/**
 * Created by 4th3ist on 6/24/2016.
 */
public class DiceRollerShared {
    private static Random rand=new Random();
    public static int rollDice(int size) {
        int min=1, max=size;
        int[] randomArray = new int[100];
        for (int i=0; i<100; i++) {
            randomArray[i]=rand.nextInt(max - min + 1) + min;
        }
        max=99;
        min=0;
        return randomArray[rand.nextInt(max - min + 1) + min];

    }

}