package com.example.vnsmenon.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
        private int user_score;
        private int user_score_buff;
        private int comp_score;
        private int comp_buff_score;

       public Button Roll = (Button)findViewById(R.id.Roll);
       public Button Hold = (Button) findViewById(R.id.Hold);
       public Button Reset = (Button) findViewById(R.id.Reset);

        Random rand = new Random();

    final int[] diceArray = new int[]{R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    int i;

    final TextView CompScorer = (TextView) findViewById(R.id.CompScore);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView UserScorer = (TextView) findViewById(R.id.UserScore);


        UserScorer.setText("0");
        CompScorer.setText("0");


        final ImageView diceImage = (ImageView) findViewById(R.id.Dice);
        //Button Roll = (Button) findViewById(R.id.Roll);

        // calling onClick() method


        // Hold.setOnClickListener(this);

        //Reset.setOnClickListener(this);

        Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = rand.nextInt(diceArray.length);

                diceImage.setImageResource(diceArray[i]);
                switch (i) {
                    case 0:
                        user_score += user_score_buff;
                        UserScorer.setText(user_score);
                        user_score_buff = 0;
                        computerScore();

                        break;
                    case 1:
                        user_score_buff += 2;
                        user_score = user_score_buff;
                        break;
                    case 2:
                        user_score_buff += 3;
                        user_score = user_score_buff;
                        break;
                    case 3:
                        user_score_buff += 4;
                        user_score = user_score_buff;
                        break;
                    case 4:
                        user_score_buff += 5;
                        user_score = user_score_buff;
                        break;
                    case 5:
                        user_score_buff += 6;
                        user_score = user_score_buff;
                        break;
                }

            }
        });


        Hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserScorer.setText(user_score);
                user_score_buff = 0;
            }
        });


        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserScorer.setText("0");
                CompScorer.setText("0");
            }
        });
    }

    public void computerScore(){

        i= rand.nextInt(diceArray.length);
        Button Roll = (Button)findViewById(R.id.Roll);
        Button Hold = (Button)findViewById(R.id.Hold);
        Roll.setEnabled(false);
        Hold.setEnabled(false);

        while(i>0){
            switch (i) {
                case 0: CompScorer.setText(comp_score);
                        comp_buff_score = 0;
                        break;
                case 1:
                    comp_buff_score += 2;
                    comp_score = comp_buff_score;
                    break;
                case 2:
                    comp_buff_score += 3;
                    comp_score = comp_buff_score;
                    break;
                case 3:
                    comp_buff_score += 4;
                    comp_score = comp_buff_score;
                    break;
                case 4:
                    comp_buff_score += 5;
                    comp_score = comp_buff_score;
                    break;
                case 5:
                    comp_buff_score += 6;
                    comp_score = comp_buff_score;
                    break;
            }
            CompScorer.setText(comp_score);
        }
    }

}







