package com.example.projetocw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class User_infomation_activity extends Fragment {

    TextView txtemail,txtnome,txtpontuacao;
    FirebaseAuth mFirebaseAuth;

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_usuario,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        txtemail = getView().findViewById(R.id.txt_user_email);
        txtnome = getView().findViewById(R.id.txt_user_id);
        txtpontuacao = getView().findViewById(R.id.txt_user_pontuacao);
        mFirebaseAuth = FirebaseAuth.getInstance();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String txt_email_valor = dataSnapshot.child("Users").child(mFirebaseAuth.getCurrentUser().getUid()).child("email").getValue().toString();
                String txt_nome_valor = dataSnapshot.child("Users").child(mFirebaseAuth.getCurrentUser().getUid()).child("nome").getValue().toString();
                String txt_pontuacao_valor = dataSnapshot.child("Users").child(mFirebaseAuth.getCurrentUser().getUid()).child("pontuacao").getValue().toString();


                txtemail.setText(txt_email_valor);
                txtemail.setTextSize(17);
                txtnome.setText(txt_nome_valor);
                txtnome.setTextSize(17);
                txtpontuacao.setText(txt_pontuacao_valor);
                txtpontuacao.setTextSize(23);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
