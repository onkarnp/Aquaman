package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    private EditText loginEmail,loginPassword;
    private Button LogInButton;
    private FirebaseAuth mAuth;
    CheckBox showPassword;
    TextView btn,forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);     //removes tite bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();    //removes action bar
        setContentView(R.layout.activity_log_in);

        btn = findViewById(R.id.signUpText);
        loginEmail = findViewById(R.id.inputFullName);
        loginPassword = findViewById(R.id.inputPassword);
        LogInButton = findViewById(R.id.LoginButton);
        showPassword = findViewById(R.id.showPassword);
        forgotPassword = findViewById(R.id.forgotPassword);
        mAuth = FirebaseAuth.getInstance();

        LogInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                logInUser();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
            }
        });

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    loginPassword.setTransformationMethod(null);
                }
                else
                {
                    loginPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter your email to receive reset link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the mail and send reset link

                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LogInActivity.this, "Reset link has been sent to your mail :)", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LogInActivity.this, "Error :( Reset link is not sent." + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //closing dialogue
                    }
                });
                passwordResetDialog.create().show();
            }
        });
    }

    public void logInUser() {
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(LogInActivity.this, "Logged in successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LogInActivity.this,Dashboard.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LogInActivity.this, "Log in failed :(", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                showError(loginPassword, "Empty fields are not allowed.");
            }
        } else if(email.isEmpty())
        {
            showError(loginEmail,"Empty fields are not allowed.");
        }
        else{
            showError(loginEmail,"Please Enter correct Email.");
        }
    }


    public void showError(EditText input, String s)
    {
        input.setError(s);
        input.requestFocus();
    }
}