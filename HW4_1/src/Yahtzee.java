import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class creates a frame with 5 blank labels and a button
 * When the button is pressed create 5 threads that will make the labels randomize to different dice sides
 * @author thildahl20
 * @version 1.0
 */
public class Yahtzee implements ActionListener{

	JFrame frame;
	
	//Constructor for initializing a new frame
	Yahtzee() {
		frame = new JFrame("Yahtzee");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
	}
	
	//This will create a Yahtzee object with a frame, then create 5 labels and a button on the frame
	public static void main(String[] args) {
		Yahtzee game = new Yahtzee();
		roll[] rolls = new roll[5];
		
		//Create a roll object for each of the 5 labels
		for (int i=0; i < 5; i++) {
			JLabel label = new JLabel();
			rolls[i] = new roll(label);
			game.frame.add(label);
		}
		
		//Create a button to roll the dice
		JButton button = new JButton("Roll");
		game.frame.add(button);
		
		//When the button is pressed, create a new thread for each label that will randomize the numbers
		button.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i<5; i++) {
						Thread t = new Thread(rolls[i]);
						t.start();
					}
			}
		});
		
		//Create a button to calculate the sum
		JButton calculate = new JButton("Calculate");
		game.frame.add(calculate);
		
		JLabel num = new JLabel();
		game.frame.add(num);
		

		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum = 0;
				for (int i = 0; i<5; i++) {	
						int n = rolls[i].getNum();
						sum = sum + n;
					}
				String labelNum = String.format("%d", sum);
			num.setText(labelNum);
			
			}
		});
		
		game.frame.setVisible(true);
		
	
		}

	public void actionPerformed(ActionEvent e) {
		
	}

}
