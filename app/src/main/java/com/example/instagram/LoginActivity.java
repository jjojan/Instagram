package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser() != null){
            goMainActivity();
        }

        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "login button");
                String Username = etUsername.getText().toString();
                String Password = etPassword.getText().toString();
                loginUser(Username, Password);
            }
        });
    }

    private void loginUser(String Username, String Password){
        Log.i(TAG, "Attempting to log in user " + Username);
        ParseUser.logInInBackground(Username, Password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
            if(e != null){
                Log.e(TAG, "Error with Login");
                return;
            }
            goMainActivity();
                Toast.makeText(LoginActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
