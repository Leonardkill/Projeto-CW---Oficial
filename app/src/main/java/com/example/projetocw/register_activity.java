package com.example.projetocw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.InputMismatchException;

public class register_activity extends AppCompatActivity {

    EditText emailId, password ,nome1 , cpf;
    Button btnRegistrar;
    TextView tvRegistrar;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastroapos_activity);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.edit_email_register);
        password = findViewById(R.id.edit_senha_register);
        btnRegistrar = findViewById(R.id.btn_registrar);
        tvRegistrar = findViewById(R.id.txt_registrar);
        nome1 = findViewById(R.id.edit_nome_register);
        cpf = findViewById(R.id.edit_cpf_register);


        //Criando mascara para o campo de EditText
        // SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN - NN");
        // MaskTextWatcher mtw = new MaskTextWatcher(cpf,smf);
        // cpf.addTextChangedListener(mtw);
        //Fim da Mascara


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                final String ccpf = cpf.getText().toString();
                final String nome = nome1.getText().toString();
                final int ppontuacao = 0;



                if (nome.isEmpty()){
                    nome1.setError("Digite seu nome");
                    nome1.requestFocus();
                }

                else if (!isCPF(ccpf)){
                    cpf.setError("CPF invalido");
                    cpf.requestFocus();
                }

                else if(email.isEmpty()) {
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
                            if(task.isSuccessful()){
                                User user = new User(nome,ccpf,email,ppontuacao);
                                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(register_activity.this , "Registrado com sucesso" , Toast.LENGTH_LONG).show();
                                            Intent d = new Intent(register_activity.this,MainActivity.class);
                                            startActivity(d);

                                        }
                                        else {
                                            Toast.makeText(register_activity.this , "Erro ao cadastrar" , Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }

                            else {
                                Toast.makeText(register_activity.this , "Não foi possível fazer o registro , por favor tente de novo" , Toast.LENGTH_SHORT).show();
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


    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }


}