package com.colman.fitme;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.colman.fitme.model.Categorie;
import com.colman.fitme.model.CategorieAdpater;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CategoriesActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference categorieRef = db.collection("categories");

    private CategorieAdpater adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        setUpRecyclerView();

    }

    private void setUpRecyclerView(){
        Query query = categorieRef.orderBy("name");

        FirestoreRecyclerOptions<Categorie> options = new FirestoreRecyclerOptions.Builder<Categorie>()
                .setQuery(query,Categorie.class)
                .build();

        adapter = new CategorieAdpater(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}
