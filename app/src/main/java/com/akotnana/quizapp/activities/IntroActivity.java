package com.akotnana.quizapp.activities;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akotnana.quizapp.R;
import com.akotnana.quizapp.utils.FontManager;

import mehdi.sakout.fancybuttons.FancyButton;

public class IntroActivity extends BaseActivity {

    TextView logo;
    TextView logoDescription;
    EditText username;
    EditText password;
    FancyButton login;
    FancyButton loginClicked;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        logo = (TextView) findViewById(R.id.logo_title);
        logoDescription = (TextView) findViewById(R.id.logo_description);
        username = (EditText) findViewById(R.id.username_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);
        login = (FancyButton) findViewById(R.id.btn_login);
        loginClicked = (FancyButton) findViewById(R.id.btn_login_clicked);
        forgotPassword = (TextView) findViewById(R.id.forgot_password_textview);

        logo.setTypeface(fontManager.getTypeFace());
        logoDescription.setTypeface(fontManager.getTypeFace());
        username.setTypeface(fontManager.getTypeFace());
        password.setTypeface(fontManager.getTypeFace());
        login.setCustomTextFont("Ubuntu-R");
        forgotPassword.setTypeface(fontManager.getTypeFace());

        login.setGhost(true);

        login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction()==MotionEvent.ACTION_UP) {
                    login.setVisibility(View.GONE);
                    int finalRadius = Math.max(loginClicked.getWidth(), loginClicked.getHeight()) / 2;
                    Animator anim = ViewAnimationUtils.createCircularReveal(loginClicked, (int) arg1.getX(), (int) arg1.getY(), 0, finalRadius);
                    // make the view visible and start the animation
                    loginClicked.setVisibility(View.VISIBLE);
                    anim.start();
                }
                return true;
            }
        });

    }

}
