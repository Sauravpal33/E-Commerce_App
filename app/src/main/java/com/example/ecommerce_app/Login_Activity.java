package com.example.ecommerce_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {

    EditText loginUser,loginPass;
    TextView signUpText;
    Button loginBtn;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        auth = FirebaseAuth.getInstance();

        loginUser = findViewById(R.id.loginUsername);
        loginPass = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginButton);
        signUpText = findViewById(R.id.signupText);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, Signup_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginUser.getText().toString();
                String pass = loginPass.getText().toString();

                if (email.isEmpty() || pass.isEmpty()){
                    Toast.makeText(Login_Activity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(Login_Activity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Login_Activity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}