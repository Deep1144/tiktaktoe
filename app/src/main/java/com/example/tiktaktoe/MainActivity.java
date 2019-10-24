package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //player represtation
    //0 - x
    //1 - o

    int activePlayer  = 0 ;
    boolean gameActive =true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    /*state : 0 - x
              1 - o
              2 - Null
    *
    * */

    //0  1  2
    //3  4  5
    //6  7  8

    int[][] winPositions = {{0,1,2} , {3,4,5} , {6,7,8} ,
            {0,3,6} , {1,4,7} , {2,5,8} ,
            {0,4,8} , {2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void playerTap(View view) {
        ImageView img = (ImageView) view;

        int tappedImage = Integer.parseInt(img.getTag().toString());

        if (!gameActive){
            reset(view);
        }

        if (gameState[tappedImage] == 2  && gameActive){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);

            if(activePlayer == 0){
                activePlayer=1;
                img.setImageResource(R.drawable.x);

                TextView status = findViewById(R.id.status);
                status.setText("o's - Turn");

                TextView heading = findViewById(R.id.textView);
                heading.setText("C'mon O");
            }
            else{
                activePlayer=0;
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.status);
                status.setText("x's - Turn");



                TextView heading = findViewById(R.id.textView);
                heading.setText("C'mon X");
            }
        }
        img.animate().translationYBy(1000f).setDuration(300);

        for (int winPosition[] :winPositions){
            if( gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]]
                &&gameState[winPosition[2]] != 2){
                String winStr;
                gameActive = false;
                if (activePlayer == 0){
                    winStr = "player 0 has won";

                    TextView heading = findViewById(R.id.textView);
                    heading.setText("0 jit gaya !!");

                }
                else{
                    winStr = "player x has won";

                    TextView heading = findViewById(R.id.textView);
                    heading.setText("X jit gaya !!");
                }
                TextView status = findViewById(R.id.status);
                status.setText(winStr);


            }
        }
    }

    public void reset(View view){
        activePlayer = 0 ;
        gameActive = true;
        for (int i = 0; i<gameState.length ; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("x's - Turn");


    }



}
