package com.example.tri_eco;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG= "onLoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

     /*   if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }*/

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignup);

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG, "onClick login button");
//                String username = etUsername.getText().toString();
//                String password = etPassword.getText().toString();
//                loginUser(username, password);
//            }
//        });

    }


    public void login(View view) {
        if( TextUtils.isEmpty(etUsername.getText())){
            etUsername.setError( "Username is required!" );
        }else if( TextUtils.isEmpty(etPassword.getText())){
            etPassword.setError( "Password is required!" );
        }else{
            final ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser.logInInBackground(etUsername.getText().toString(), etPassword.getText().toString() , new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    progress.dismiss();
                    if (parseUser != null) {
                        Toast.makeText(LoginActivity.this, "Welcome back!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }


//    private void loginUser(String username, String password){
//        Log.i(TAG, "Attempting to login user");
//        //navigate to main activity if user has logged in correctly
//        ParseUser.logInInBackground(username, password, new LogInCallback() {
//            @Override
//            public void done(ParseUser user, ParseException e) {
//                //if there is a problem, e will not be null
//                if (e != null) {
//                    Log.e(TAG, "Incorrect username or password", e);
//                    Toast.makeText(LoginActivity.this, "Issue with Login", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                //if login successful, go to MainActivity
//                goMainActivity();
//                Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void signUp(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);

    }

//    public void forgotPassword(View view) {
//        Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
//        startActivity(intent);
//    }


    private void goMainActivity(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}