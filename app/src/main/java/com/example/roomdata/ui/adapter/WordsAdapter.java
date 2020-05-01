package com.example.roomdata.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdata.R;
import com.example.roomdata.ui.model.Words;

import java.util.List;


public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordsHolser> {
Context context;
List<Words>words;
public WordsAdapter(Context context,List<Words>words){
    this.context=context;
    this.words=words;
}

    @NonNull
    @Override
    public WordsHolser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.words_row,parent,false);
        return new WordsHolser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsHolser holder, int position) {
holder.word.setText(words.get(position).getWordName());
    }

    @Override
    public int getItemCount() {
    if (words==null)
        return 0;
    else
        return words.size();
    }

    public class  WordsHolser extends RecyclerView.ViewHolder{
    TextView word;
        public WordsHolser(@NonNull View itemView) {
            super(itemView);
            word=itemView.findViewById(R.id.word);
        }
    }
    public void notifyAdapter(List<Words>words){
    this.words=words;
    notifyDataSetChanged();
    }
}
