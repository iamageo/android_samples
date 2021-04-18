package com.iamageo.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamageo.recyclerview.R;
import com.iamageo.recyclerview.model.User;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.MyViewHolder> {

    //TODO: reference
    // https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=pt-br

    private ArrayList<User> userList;

    public userAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameText;

        public MyViewHolder(final View view) {
            super(view);
            nameText = view.findViewById(R.id.user);
        }
    }

    /**
     * Initialize the listview of the Adapter.
     * containing the data to populate views to be used
     * by RecyclerView.
     */
    @NonNull
    @Override
    public userAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Get element from your listitens at this position and replace the
        // contents of the view with that element
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull userAdapter.MyViewHolder holder, int position) {
        String name = userList.get(position).getUsername();
        holder.nameText.setText(name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return userList.size();
    }
}
