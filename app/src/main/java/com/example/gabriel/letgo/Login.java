package com.example.gabriel.letgo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    Button createAccBTN;
    Button loginBTN;
    EditText emailField;
    EditText passField;

    // must be signed into google play services
    // must have updated version


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createAccBTN = (Button)findViewById(R.id.createAcc);
        loginBTN = (Button)findViewById(R.id.signIn);


        emailField = (EditText)findViewById(R.id.emailField);
        passField = (EditText)findViewById(R.id.passwordField);

        mAuth = FirebaseAuth.getInstance();

        createAccBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(Login.this, "attempting to create new account", Toast.LENGTH_SHORT).show();
                createAccount(emailField.getText().toString(), passField.getText().toString());
            }
        });

        loginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(Login.this, "attempting to login", Toast.LENGTH_SHORT).show();
                signIn(emailField.getText().toString(), passField.getText().toString());
            }
        });

    }



    @Override
    protected void onStart() {
        super.onStart();
        // check if user is signed in (non-null) and update ui
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){    // user is signed in
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "user is signed in", Toast.LENGTH_SHORT).show();
        }
        else{   // user is not signed in since currentUser came back as null
            Toast.makeText(this, "user is not signed in", Toast.LENGTH_SHORT).show();
        }
    }

    public void createAccount(final String email, String password){
        if(!validateForm()){
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "successfully created account as " + email, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else{
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    private void signIn(String email, String password){
        if (!validateForm()){
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // signed in successfully
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Login.this, "successfully signed in as " + user.getEmail(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(Login.this, "authentication failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    // this section is unfinished
    private boolean validateForm(){ // check form
        boolean valid = true;
        String email = emailField.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailField.setError("Required.");
            valid = false;
        }else {
            emailField.setError(null);
        }

        String password = passField.getText().toString();
        if(TextUtils.isEmpty(password)){
            passField.setError("Required.");
            valid = false;
        }
        else{
            passField.setError(null);
        }
        return valid;
    }

}
