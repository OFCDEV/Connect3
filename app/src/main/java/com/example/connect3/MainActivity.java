package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0 = Cross 1=Circle

    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    //2 means unplayed

    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6} };
    public void dropIn(View view) {

        ImageView counter = (ImageView) view;


        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter]==2) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.cross);

                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.circle);

                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);
            //We can add more animation such as Rotation...etc

            for(int[]winningPosition : winningPositions){

                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] ==gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2);

                String winner = "Circle";

                if(gameState[winningPosition[0]]==0){

                    winner = "Cross";
                }

                TextView winnerMessage = (TextView)findViewById(R.id.winnerMessage);
                winnerMessage.setText(winner +"has won!");

                LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

                layout.setVisibility(View.VISIBLE);

            }
        }
    }

    public void playAgain(){
        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;

       // for(int j=0, j<gameState.length,j++){
        //    gameState[j]=2;

        //}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}