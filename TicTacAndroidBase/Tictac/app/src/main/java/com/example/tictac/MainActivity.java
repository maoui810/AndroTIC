package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Manpreet" ;
    int [] gameState= {2,2,2,2,2,2,2,2,2};



    int [][] winningSlots ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int player=0;

    boolean checkWinner = true;

    public void dropIn(View view){



        ImageView counter=(ImageView) view;


        //Log.i("Tag",counter.getTag().toString());
        int tagCounter=Integer.parseInt(counter.getTag().toString());

        if(gameState[tagCounter]==2 &&checkWinner) {
            gameState[tagCounter] = player;
            counter.setTranslationY(-1500);

            if (player == 0) {
                counter.setImageResource(R.drawable.ooo);
                player = 1;
            } else {

                counter.setImageResource(R.drawable.xme);
                player = 0;
            }
            counter.animate().alpha(0);
            counter.animate().alpha(1).setDuration(700).translationYBy(1500).setDuration(300);

            for (int[] winningSlot : winningSlots) {
                if (gameState[winningSlot[0]] == gameState[winningSlot[1]]) {
                    if (gameState[winningSlot[1]] == gameState[winningSlot[2]]) {
                        if (gameState[winningSlot[0]] != 2) {
                            checkWinner=false;
                            String winner = "";
                            if (player == 1) {
                                winner = "player O";
                            } else {
                                winner = "Player X";
                            }

                           // Toast.makeText(this, winner + " is the Winner", Toast.LENGTH_SHORT).show();
                            Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

                            TextView winnerTextView = (TextView) findViewById(R.id.WinnerTextView);

                            winnerTextView.setText(winner + " has won!");

                            playAgainButton.setVisibility(View.VISIBLE);

                            winnerTextView.setVisibility(View.VISIBLE);
                        }

                    }

                }
            }
        }
    }


    public void playAgain(View view) {
        Button playAgainButton=(Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView=(TextView) findViewById(R.id.WinnerTextView);

        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i = 0; i<gridLayout.getChildCount(); i++){
            ImageView counter2  = (ImageView) gridLayout.getChildAt(i);

            counter2.setImageDrawable(null);
        }

        for (int i = 0; i<gameState.length; i++){
            Log.i(TAG,"Something" );
            gameState[i] = 2;
        }



         player=0;

         checkWinner = true;


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}