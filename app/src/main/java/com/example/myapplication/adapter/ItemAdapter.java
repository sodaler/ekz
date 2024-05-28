package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.entity.Item;
import com.example.myapplication.fragments.ItemFragment;

import java.util.List;
import java.util.Objects;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private DatabaseHelper databaseHelper;

    public ItemAdapter(List<Item> itemList, DatabaseHelper databaseHelper) {
        this.itemList = itemList;
        this.databaseHelper = databaseHelper;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        String fio = "";

        if (!Objects.equals(item.getFio(), "")) {
            fio = item.getFio();
        }

        String result = item.getName() + " " + fio;

        holder.nameTextView.setText(result);
        holder.itemView.setOnClickListener(view -> {
            // Open Add/Edit Fragment
            FragmentManager fragmentManager = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
            ItemFragment itemFragment = ItemFragment.newInstance(item);
            itemFragment.show(fragmentManager, "ItemFragment");
        });

        holder.deleteButton.setOnClickListener(view -> {
            databaseHelper.deleteItem(item.getId());

            itemList.remove(position);

            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public Button deleteButton;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}

