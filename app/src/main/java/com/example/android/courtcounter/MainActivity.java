package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;



public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    boolean hasWon = false ;
    final int maxScore = 10;
    String A_won, B_won, new_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        A_won = getString(R.string.team_A_won);
        B_won = getString(R.string.team_B_won);
        new_game = getString(R.string.new_game);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //displayForTeamA(0);
        //displayForTeamB(0);
    }


    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
        checkIsWin(scoreTeamA, A_won);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
        checkIsWin(scoreTeamA, A_won);
    }


    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
        checkIsWin(scoreTeamA, A_won);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }



    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
        checkIsWin(scoreTeamB, B_won);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v)  { //throws InterruptedException
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
        checkIsWin(scoreTeamB, B_won);
    }


    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
        checkIsWin(scoreTeamB, B_won);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void display_us_who_won(String text) {
        TextView scoreView = (TextView) findViewById(R.id.who_won);
        scoreView.setText(String.valueOf(text));
    }

    public void new_game(String text) {
        TextView scoreView = (TextView) findViewById(R.id.suggest_new_game);
        scoreView.setText(String.valueOf(text));
    }

    public void checkIsWin(int score, String team) { // throws InterruptedException

        if (score >= maxScore && !hasWon) {
            if (!((scoreTeamA > maxScore) && (scoreTeamB > maxScore))) {
                display_us_who_won(team);
                hasWon = true;
                new_game(new_game);
                //Thread.sleep(3000);
                //resetScores();

            }
        }
    }

    private void resetScores() {
        /*
        try {
            Thread.currentThread().sleep(3000) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        display_us_who_won("");
        new_game("");
        hasWon = false;
    }

    public void reset(View v) {
        resetScores();

        /*
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        */
    }

}
