package com.iamageo.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.iamageo.recyclerview.adapter.userAdapter;
import com.iamageo.recyclerview.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> userArrayList;
    private userAdapter userAdapter;
    private RecyclerView recyclerViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.usersRecyclerView);

        userArrayList = new ArrayList<>();

        setUserInfo();

        setAdapter();

    }

    private void setAdapter() {
        userAdapter = new userAdapter(userArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerViewUser.setLayoutManager(layoutManager);
        recyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUser.setAdapter(userAdapter);
    }

    private void setUserInfo() {
        userArrayList.add(new User("Jhon"));
        userArrayList.add(new User("Paulo"));
        userArrayList.add(new User("Ricardo"));
        userArrayList.add(new User("Rebeca"));
        userArrayList.add(new User("Herald"));

    }
}