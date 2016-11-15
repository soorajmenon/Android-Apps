package com.example.vnsmenon.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    boolean cpuTurn;

        public Button Roll, Hold, Reset;

        Random rand = new Random();

    final int[] diceArray = new int[]{R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    int i;

    TextView CompScorer, UserScorer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpuTurn = false;
        Roll = (Button) findViewById(R.id.Roll);
        Hold = (Button) findViewById(R.id.Hold);
        Reset = (Button) findViewById(R.id.Reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_score = 0;
                comp_score = 0;
                comp_buff_score = 0;
                user_score_buff = 0;
                UserScorer.setText("0");
                CompScorer.setText("0");
                Roll.setEnabled(true);
                Hold.setEnabled(true);
            }
        });

        CompScorer = (TextView) findViewById(R.id.CompScore);

        UserScorer = (TextView) findViewById(R.id.UserScore);
        user_score = 0;
        comp_score = 0;

        UserScorer.setText("0");
        CompScorer.setText("0");
        Roll.setEnabled(true);
        Hold.setEnabled(true);


        Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ImageView diceImage = (ImageView) findViewById(R.id.Dice);
                i = rand.nextInt(diceArray.length);
                user_score = Integer.parseInt(UserScorer.getText().toString());
                diceImage.setImageResource(diceArray[i]);
                Log.i("Number" , Integer.toString(i));
                switch (i) {
                    case 0:
                        user_score += user_score_buff;
                        UserScorer.setText(Integer.toString(user_score));
                        user_score_buff = 0;
                        cpuTurn = true;
                        computerScore();
                        break;
                    case 1:
                        user_score_buff += 2;
                        user_score = user_score_buff;
                        UserScorer.setText(Integer.toString(user_score));
                        break;
                    case 2:
                        user_score_buff += 3;
                        user_score = user_score_buff;
                        UserScorer.setText(Integer.toString(user_score));
                        break;
                    case 3:
                        user_score_buff += 4;
                        user_score = user_score_buff;
                        UserScorer.setText(Integer.toString(user_score));
                        break;
                    case 4:
                        user_score_buff += 5;
                        user_score = user_score_buff;
                        UserScorer.setText(Integer.toString(user_score));
                        break;
                    case 5:
                        user_score_buff += 6;
                        user_score = user_score_buff;
                        UserScorer.setText(Integer.toString(user_score));
                        break;
                }

            }

        });


        Hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserScorer.setText(Integer.toString(user_score));
                user_score_buff = 0;
            }
        });

    }







    /* public void user(){

         Roll.setEnabled(true);
         Hold.setEnabled(true);


            Roll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final ImageView diceImage = (ImageView) findViewById(R.id.Dice);
                    i = rand.nextInt(diceArray.length);
                    user_score = Integer.parseInt(UserScorer.getText().toString());
                    diceImage.setImageResource(diceArray[i]);
                    Log.i("Number" , Integer.toString(i));
                    switch (i) {
                        case 0:
                            user_score += user_score_buff;
                            UserScorer.setText(Integer.toString(user_score));
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

            });*/








    public void computerScore(){



        Roll.setEnabled(false);
        Hold.setEnabled(false);
        loop:
        while(cpuTurn){
            i= rand.nextInt(diceArray.length);
            Log.i("Entered Loop" , "Entered Loop");
            if (i == 0) {
                CompScorer.setText(Integer.toString(comp_score));
                comp_buff_score = 0;
                Roll.setEnabled(true);
                Hold.setEnabled(true);
                cpuTurn = false;
                break loop;
            }
            switch (i) {
                case 1:
                    comp_buff_score += 2;
                    comp_score = comp_buff_score;
                    CompScorer.setText(Integer.toString(comp_score));
                    break;
                case 2:

                    comp_buff_score += 3;
                    comp_score = comp_buff_score;
                    CompScorer.setText(Integer.toString(comp_score));
                    break;
                case 3:
                    comp_buff_score += 4;
                    comp_score = comp_buff_score;
                    CompScorer.setText(Integer.toString(comp_score));
                    break;
                case 4:
                    comp_buff_score += 5;
                    comp_score = comp_buff_score;
                    CompScorer.setText(Integer.toString(comp_score));
                    break;
                case 5:
                    comp_buff_score += 6;
                    comp_score = comp_buff_score;
                    CompScorer.setText(Integer.toString(comp_score));
                    break;
            }
            CompScorer.setText(Integer.toString(comp_score));
            Roll.setEnabled(true);
            Hold.setEnabled(true);


        }


    }


}







