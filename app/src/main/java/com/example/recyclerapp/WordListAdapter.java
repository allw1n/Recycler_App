package com.example.recyclerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final ArrayList<String> _wordList;
    private final LayoutInflater _layoutInflater;

    public WordListAdapter (Context context, ArrayList<String> wordList) {
        _layoutInflater = LayoutInflater.from(context);
        this._wordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = _layoutInflater.inflate(R.layout.word_list_item, parent, false);
        return new WordViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String currentWord = _wordList.get(position);
        holder.textViewWord.setText(currentWord);
    }

    @Override
    public int getItemCount() {
        return _wordList.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView textViewWord;
        final WordListAdapter wordListAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter wordListAdapter) {
            super(itemView);
            textViewWord = itemView.findViewById(R.id.word);
            this.wordListAdapter = wordListAdapter;
            textViewWord.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            String word = wordListAdapter._wordList.get(position);
            wordListAdapter._wordList.set(position, "Clicked " + word);
            wordListAdapter.notifyItemChanged(position);
        }
    }
}