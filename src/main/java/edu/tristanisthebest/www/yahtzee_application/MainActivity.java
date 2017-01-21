package edu.tristanisthebest.www.yahtzee_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * This is the main class for the Application where the imageviews, a button and the dice are set up,
 * Also, when the button is clicked it will go through all of the dice and randomize an image/roll
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    roll[] rolls = new roll[5];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the imageviews and the 5 five dice using those locations
        ImageView iv1 = (ImageView)findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView)findViewById(R.id.imageView2);
        ImageView iv3 = (ImageView)findViewById(R.id.imageView3);
        ImageView iv4 = (ImageView)findViewById(R.id.imageView4);
        ImageView iv5 = (ImageView)findViewById(R.id.imageView5);

        rolls[0] = new roll(iv1);
        rolls[1] = new roll(iv2);
        rolls[2] = new roll(iv3);
        rolls[3] = new roll(iv4);
        rolls[4] = new roll(iv5);


        //I wanted to get this working so it didn't have to be repetitive, but I didn't figure it out in time
        //I will still try to figure it out and consider using this if I do my final project on mobile

       // RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);

        //RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
        //     RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // lp.addRule(RelativeLayout.BELOW, R.id.Button);
        // lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

       // for (int i = 0; i < 5; i++) {
       //     ImageView d = new ImageView(this);
       //     d.setLayoutParams(new android.view.ViewGroup.LayoutParams(350,350));
       //     rolls[i] = new roll(d);
       //    layout.addView(d, lp);
       // }

        //This creates a button, that when clicked will go through each dice and the run() function:randomizes the image
        Button b = (Button)this.findViewById(R.id.Button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    for (int i = 0; i < 5; i++)
                        MainActivity.this.rolls[i].run();
            }
        });

    }

    public void onClick(View v) {

    }
}
