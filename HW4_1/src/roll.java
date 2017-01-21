import java.awt.*;
import java.net.URL;
import java.util.Random;
import javax.swing.*;

/**
 * This class creates a roll object that contains a label, that can have its image changed randomly when a new thread is created
 * @author thildahl20
 * @version 1.0
 */
public class roll implements Runnable{

	private JLabel dice;
	private int num;
	
	//Constructor that initializes a roll object with a JLabel
	public roll(JLabel label) {
		dice = label;
		num = 0;
	}
	
	//When a new thread is created, randomize the label of the roll object to different sides of a dice 
	//Will stop on a random image at a random time
	public void run() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int endRoll = 0;
		
		while (endRoll != 1) {
			
			//This will create a random number to decide which side of the dice is shown
			Random rnd = new Random();
			int r = rnd.nextInt(6) + 1;
			
			//This will create a random number that has a 1/20 chance of equaling 1
			//Thus this will make the dice stop rolling at a random time
			Random stop = new Random();
			endRoll = stop.nextInt(20);
		
			URL imgURL;
			
			//Get the dice image depending on the random rnd/ int num
			if (r == 1) {
				imgURL = getClass().getResource("/pictures/dice1.png");
				num = 1;
			}
			else if (r == 2) {
				imgURL = getClass().getResource("/pictures/dice2.png");
				num = 2;
			}
			else if (r == 3) {
				imgURL = getClass().getResource("/pictures/dice3.png");
				num = 3;
			}
			else if (r == 4) {
				imgURL = getClass().getResource("/pictures/dice4.png");
				num = 4;
			}
			else if (r == 5) {
				imgURL = getClass().getResource("/pictures/dice5.png");
				num = 5;
			}
			else if (r == 6){
				imgURL = getClass().getResource("/pictures/dice6.png");
				num = 6;
			}
			else
				imgURL = getClass().getResource("/pictures/dice1.png");
			
			Image img = toolkit.getImage(imgURL);
			img = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(img);
			
			dice.setIcon(icon);
			
			//This is when I was outputting numbers instead of pictures
			//String number = String.format("%d", num);
			//dice.setText(number);
			
			//Have the thread wait for a brief time for changing image again
			try {
				Thread.sleep(150);
			}
			catch (InterruptedException ex) {;}
		}
		
	}
	
	public int getNum() {
		return num;
	}

}
