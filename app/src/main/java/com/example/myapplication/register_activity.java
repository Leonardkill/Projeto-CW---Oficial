package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class register_activity extends AppCompatActivity {

    EditText emailId, password;
    Button btnRegistrar;
    TextView tvRegistrar;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_senha);
        btnRegistrar = findViewById(R.id.btn_registrar);
        tvRegistrar = findViewById(R.id.txt_registrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty()) {
                    emailId.setError("Por favor insira um e-mail");
                    emailId.requestFocus();
                }

                else if (pwd.isEmpty()){
                    password.setError("Digite uma senha");
                    password.requestFocus();
                }

                else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(register_activity.this , "Os campos estão vazio" , Toast.LENGTH_SHORT).show();
                }

                else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(register_activity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if(!task.isSuccessful()){

                                Toast.makeText(register_activity.this , "Não foi possível fazer o registro , por favor tente de novo" , Toast.LENGTH_SHORT).show();
                            }

                            else {
                                startActivity(new Intent(register_activity.this,MainActivity.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(register_activity.this , "Ocorreu um erro!" , Toast.LENGTH_SHORT).show();
                }

            }

        });

        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(register_activity.this,login_activity.class);
                startActivity(i);
            }
        });
    }
}
