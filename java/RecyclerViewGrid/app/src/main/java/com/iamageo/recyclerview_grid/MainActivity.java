package com.iamageo.recyclerview_grid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.iamageo.recyclerview_grid.adapter.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewUser;
    List<String> usernames;
    List<Integer> user_images;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initComponents();

        usernames = new ArrayList<>();
        user_images = new ArrayList<>();

        usernames.add("João");
        usernames.add("Maria");
        usernames.add("José");
        usernames.add("Carlos");

        user_images.add(R.drawable.ic_baseline_spa_24);
        user_images.add(R.drawable.ic_baseline_sports_basketball_24);
        user_images.add(R.drawable.ic_baseline_stay_primary_portrait_24);
        user_images.add(R.drawable.ic_baseline_supervised_user_circle_24);

        adapter = new Adapter(this, usernames, user_images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewUser.setLayoutManager(gridLayoutManager);
        recyclerViewUser.setAdapter(adapter);

    }

    public void initComponents() {
        recyclerViewUser = findViewById(R.id.RecyclerViewUser);
    }
}