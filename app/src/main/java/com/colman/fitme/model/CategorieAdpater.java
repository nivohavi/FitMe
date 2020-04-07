package com.colman.fitme.model;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.colman.fitme.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CategorieAdpater extends FirestoreRecyclerAdapter<Categorie, CategorieAdpater.CategorieHolder> {

    public CategorieAdpater(FirestoreRecyclerOptions<Categorie> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(CategorieHolder categorieHolder, int i, Categorie categorie) {
        categorieHolder.textViewName.setText(categorie.name);
        categorieHolder.imageUrl.setText(categorie.image);
    }

    @NonNull
    @Override
    public CategorieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorie_item,
                parent, false);
        return new CategorieHolder(v);
    }

    class CategorieHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView imageUrl;

        public CategorieHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_title);
            imageUrl = itemView.findViewById(R.id.text_view_description);
        }
    }
}
