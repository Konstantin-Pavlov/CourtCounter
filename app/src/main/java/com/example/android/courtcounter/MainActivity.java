package com.example.android.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA;
    int scoreTeamB;
    boolean hasWon;
    final int maxScore = 10;
    String A_won;
    String B_won;
    String new_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        hasWon = false ;
        A_won = getString(R.string.team_A_won);
        B_won = getString(R.string.team_B_won);
        new_game = getString(R.string.new_game);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        switch(v.getId()){

            case R.id.addOneForTeamA:
                scoreTeamA += 1;
                displayForTeamA(scoreTeamA);
                checkIsWin(scoreTeamA, A_won);
                break;

            case R.id.addTwoForTeamA:
                scoreTeamA += 2;
                displayForTeamA(scoreTeamA);
                checkIsWin(scoreTeamA, A_won);
                break;

            case R.id.addThreeForTeamA:
                scoreTeamA += 3;
                displayForTeamA(scoreTeamA);
                checkIsWin(scoreTeamA, A_won);
                break;

            case R.id.addOneForTeamB:
                scoreTeamB += 1;
                displayForTeamB(scoreTeamB);
                checkIsWin(scoreTeamB, B_won);
                break;

            case R.id.addTwoForTeamB:
                scoreTeamB += 2;
                displayForTeamB(scoreTeamB);
                checkIsWin(scoreTeamB, B_won);
                break;

            case R.id.addThreeForTeamB:
                scoreTeamB += 3;
                displayForTeamB(scoreTeamB);
                checkIsWin(scoreTeamB, B_won);
                break;

            case R.id.reset_button:
                resetScores();
                break;
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
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

    public void checkIsWin(int score, String team) {
        if (score >= maxScore && !hasWon) {
            if (!((scoreTeamA > maxScore) && (scoreTeamB > maxScore))) {
                display_us_who_won(team);
                hasWon = true;
                new_game(new_game);
            }
        }
    }

    private void resetScores() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        display_us_who_won("");
        new_game("");
        hasWon = false;
    }
}
