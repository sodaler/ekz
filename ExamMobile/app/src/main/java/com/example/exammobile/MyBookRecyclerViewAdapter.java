package com.example.exammobile;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.exammobile.Database.Book;
import com.example.exammobile.databinding.LayoutItemBookBinding;

import java.util.List;

public class MyBookRecyclerViewAdapter extends RecyclerView.Adapter<MyBookRecyclerViewAdapter.ViewHolder> {

    private final List<Book> mValues;
    private OnItemClickListener listener;

    public MyBookRecyclerViewAdapter(List<Book> items, OnItemClickListener listener) {
        mValues = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Book book = mValues.get(position);
        holder.bookName.setText(book.getName());
        holder.bookAuthor.setText(book.getAuthor());
        holder.bookIzdName.setText(book.getIzdName());
        holder.bookIzd.setText(book.getIzdDate());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(position)); // Передача позиции
    }



    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView bookName;
        public final TextView bookAuthor;
        public final TextView bookIzd;
        public final TextView bookIzdName;


        public ViewHolder(LayoutItemBookBinding binding) {
            super(binding.getRoot());
            bookName = binding.itemBookName;
            bookAuthor = binding.itemBookAuthor;
            bookIzdName = binding.itemBookIzdName;
            bookIzd = binding.itemBookIzdDate;

        }
    }
}