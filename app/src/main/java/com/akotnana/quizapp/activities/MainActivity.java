package com.akotnana.quizapp.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akotnana.quizapp.R;

public class MainActivity extends BaseActivity {

    TextView name;
    TextView level;
    Button quizButton;
    Button profileButton;
    Button challengeButton;
    Button leaderboardButton;
    Button settingsButton;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.profile_name);
        level = (TextView) findViewById(R.id.profile_level);
        quizButton = (Button) findViewById(R.id.quizes_button);
        profileButton = (Button) findViewById(R.id.profile_button);
        challengeButton = (Button) findViewById(R.id.challenge_button);
        leaderboardButton = (Button) findViewById(R.id.leaderboard_button);
        logoutButton = (Button) findViewById(R.id.log_out_button);
        settingsButton = (Button) findViewById(R.id.settings_button);


        name.setTypeface(fontManager.getTypeFaceBold());
        level.setTypeface(fontManager.getTypeFaceLight());
        quizButton.setTypeface(fontManager.getTypeFaceRegular());
        profileButton.setTypeface(fontManager.getTypeFaceRegular());
        challengeButton.setTypeface(fontManager.getTypeFaceRegular());
        leaderboardButton.setTypeface(fontManager.getTypeFaceRegular());
        logoutButton.setTypeface(fontManager.getTypeFaceLight());
        settingsButton.setTypeface(fontManager.getTypeFaceLight());

    }
}
