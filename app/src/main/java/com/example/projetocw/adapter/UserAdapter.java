package com.example.projetocw.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetocw.R;
import com.example.projetocw.User;
import com.example.projetocw.adapter.viewholder.LineHolder;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<LineHolder> {

    private List<User> mUsers;

    public UserAdapter(List<User> mUsers) {
        this.mUsers = mUsers;
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_pontos, viewGroup, false);
        return new LineHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder viewHolder, int i) {
        viewHolder.getViewNome().setText(String.format("%sº - %s", i+1,  mUsers.get(i).getNome()));
        viewHolder.getViewPonto().setText(String.valueOf(mUsers.get(i).getPontuacao()));
    }

    @Override
    public int getItemCount() {
        return this.mUsers.size();
    }

}
