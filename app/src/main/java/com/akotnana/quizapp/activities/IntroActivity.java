package com.akotnana.quizapp.activities;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.akotnana.quizapp.R;
import com.akotnana.quizapp.layouts.CustomButton;
import com.akotnana.quizapp.utils.FontManager;

import mehdi.sakout.fancybuttons.FancyButton;

public class IntroActivity extends BaseActivity {

    public final String TAG = "IntroActivity";

    TextView logo;
    TextView logoDescription;
    EditText username;
    EditText password;
    CustomButton login;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        logo = (TextView) findViewById(R.id.logo_title);
        logoDescription = (TextView) findViewById(R.id.logo_description);
        username = (EditText) findViewById(R.id.username_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);

        login = (CustomButton) findViewById(R.id.login_layout);
        login.setText("Continue");

        login.setOnViewTouchedListener(new CustomButton.OnViewTouchedListener() {
            @Override
            public void onViewTouched(boolean clicked) {
                if(true)
                    Log.d(TAG, "clicked continue");
            }
        });


        forgotPassword = (TextView) findViewById(R.id.forgot_password_textview);

        logo.setTypeface(fontManager.getTypeFace());
        logoDescription.setTypeface(fontManager.getTypeFace());
        username.setTypeface(fontManager.getTypeFace());
        password.setTypeface(fontManager.getTypeFace());
        forgotPassword.setTypeface(fontManager.getTypeFace());



    }

}
