package com.example.projetocw.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetocw.R;

public class LineHolder extends RecyclerView.ViewHolder {

    private TextView viewNome;
    private TextView viewPonto;

    public LineHolder(@NonNull View itemView) {
        super(itemView);

        viewNome = itemView.findViewById(R.id.itemViewNome);
        viewPonto = itemView.findViewById(R.id.itemViewPonto);

    }

    public TextView getViewNome() {
        return viewNome;
    }

    public TextView getViewPonto() {
        return viewPonto;
    }
}
