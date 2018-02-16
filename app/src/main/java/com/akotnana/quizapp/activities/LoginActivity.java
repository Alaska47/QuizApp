package com.akotnana.quizapp.activities;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class LoginActivity extends BaseActivity {

    public final String TAG = "LoginActivity";

    TextView logo;
    TextView logoDescription;
    EditText username;
    EditText password;
    FancyButton login;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        logo = (TextView) findViewById(R.id.logo_title);
        logoDescription = (TextView) findViewById(R.id.logo_description);
        username = (EditText) findViewById(R.id.username_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);

        login = (FancyButton) findViewById(R.id.login_button);

        login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                            R.style.AppTheme_Dark_Dialog);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setCancelable(false);
                    progressDialog.setMessage("Signing in...");
                    progressDialog.show();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 1000);
                }
                return true;
            }
        });


        forgotPassword = (TextView) findViewById(R.id.forgot_password_textview);

        logo.setTypeface(fontManager.getTypeFaceRegular());
        logoDescription.setTypeface(fontManager.getTypeFaceRegular());
        username.setTypeface(fontManager.getTypeFaceRegular());
        password.setTypeface(fontManager.getTypeFaceRegular());
        forgotPassword.setTypeface(fontManager.getTypeFaceRegular());

    }

}
