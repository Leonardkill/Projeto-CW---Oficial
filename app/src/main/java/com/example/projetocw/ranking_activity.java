package com.example.projetocw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetocw.adapter.UserAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ranking_activity extends Fragment {

    private List<User> lista = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ranking,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        recyclerView = getView().findViewById(R.id.lstPontuacao);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        final UserAdapter adapter = new UserAdapter(lista);
        recyclerView.setAdapter(adapter);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lista.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    User user = data.getValue(User.class);
                    lista.add(user);
                }

                Collections.sort(lista);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void initializeData(){
        lista = new ArrayList<>();

        User user1 = new User();
        user1.setNome("Nome 1");
        user1.setPontuacao(100);
        lista.add(user1);

        User user2 = new User();
        user2.setNome("Nome 2");
        user2.setPontuacao(200);
        lista.add(user2);

        User user3 = new User();
        user3.setNome("Nome 3");
        user3.setPontuacao(50);
        lista.add(user3);


    }

}
