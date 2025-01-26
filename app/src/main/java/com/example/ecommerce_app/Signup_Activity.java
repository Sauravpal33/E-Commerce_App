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


import com.google.firebase.auth.FirebaseAuth;

public class Signup_Activity extends AppCompatActivity {

    EditText signUpEmail,signUpPass,signUpName;
    Button signUpBtn;
    TextView loginText;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);


        auth = FirebaseAuth.getInstance();

        signUpName = findViewById(R.id.signUpName);
        signUpEmail = findViewById(R.id.signUpUsername);
        signUpPass = findViewById(R.id.signUpPassword);
        signUpBtn = findViewById(R.id.signUpButton);
        loginText = findViewById(R.id.loginTextClick);

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup_Activity.this, Login_Activity.class);
                startActivity(intent);
                finish();
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = signUpName.getText().toString();
                String email = signUpEmail.getText().toString();
                String password = signUpPass.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Signup_Activity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()){
                                Toast.makeText(Signup_Activity.this, "Account Created", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Signup_Activity.this,Login_Activity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(Signup_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}