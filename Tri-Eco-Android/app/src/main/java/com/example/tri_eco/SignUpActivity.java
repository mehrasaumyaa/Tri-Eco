package com.example.tri_eco;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG= "SignupActivity";
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private Button btnSignUp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();

               // signUpUser(username,password, email);
            }
        });
    }


    public void signup(View view) {
        if( TextUtils.isEmpty(etUsername.getText())){
            etUsername.setError( "Name is required!" );
        }else if( TextUtils.isEmpty(etEmail.getText())){
            etEmail.setError( "Email is required!" );
        }else if( TextUtils.isEmpty(etPassword.getText())){
            etPassword.setError( "Password is required!" );

        }else{

            final ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser user = new ParseUser();
            user.setUsername(etUsername.getText().toString().trim());
            user.setEmail(etEmail.getText().toString().trim());
            user.setPassword(etPassword.getText().toString());
            user.put("name", etUsername.getText().toString().trim());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    progress.dismiss();
                    if (e == null) {
                        Toast.makeText(SignUpActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

//    private void signUpUser(String username, String password, String email){
//        // Create the ParseUser
//        ParseUser user = new ParseUser();
//        // Set core properties
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);
//        // Invoke signUpInBackground
//        user.signUpInBackground(new SignUpCallback() {
//            public void done(ParseException e) {
//                if (e != null) {
//                    Log.e(TAG, "Issue with sign up", e);
//                    Toast.makeText(SignUpActivity.this, "Issue with sign up",Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    goMainActivity();
//                }
//            }
//        });
//    }

//    private void goMainActivity(){
//        Intent i = new Intent(this,MainActivity.class);
//        startActivity(i);
//        finish();
//    }

}
