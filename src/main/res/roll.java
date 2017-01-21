import java.util.Random;

import edu.tristanisthebest.www.yahtzee_application.R;

/**
 * Created by thildahl20 on 1/20/2017.
 */
public class roll {
    ImageView dice;
    int num;

    //Constructor that initializes a roll object with a JLabel
    public roll() {
        dice = new ImageView();
        num = 0;
    }

    /**
     *When a new thread is created, randomize the label of the roll object to different sides of a dice
     *Will stop on a random image at a random time
     */
    public void run() {
        int endRoll = 0;
        while (endRoll != 1) {
            //This will create a random number to decide which side of the dice is shown
            Random rnd = new Random();
            int r = rnd.nextInt(6) + 1;

            //This will create a random number that has a 1/20 chance of equaling 1
            //Thus this will make the dice stop rolling at a random time
            Random stop = new Random();
            endRoll = stop.nextInt(20);
        }

        //Get the dice image depending on the random rnd/ int num
        if (r == 1) {
            dice.setImageResource(R.drawable.dice1);
            num = 1;
        }
        else if (r == 2) {
            dice.setImageResource(R.drawable.dice2);
            num = 2;
        }
        else if (r == 3) {
            dice.setImageResource(R.drawable.dice3);
            num = 3;
        }
        else if (r == 4) {
            dice.setImageResource(R.drawable.dice4);
            num = 4;
        }
        else if (r == 5) {
            dice.setImageResource(R.drawable.dice5);
            num = 5;
        }
        else if (r == 6){
            dice.setImageResource(R.drawable.dice6);
            num = 6;
        }
        else
            dice.setImageResource(R.drawable.dice1);

            //Have the thread wait for a brief time for changing image again
            try {
                Thread.sleep(150);
            }
            catch (InterruptedException ex) {;}
    }

}


}
