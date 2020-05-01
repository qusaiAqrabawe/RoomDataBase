package com.example.roomdata.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdata.R;
import com.example.roomdata.ui.model.Words;
import com.example.roomdata.ui.adapter.WordsAdapter;
import com.example.roomdata.ui.view_model.WordsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordsViewModel wordsViewModel;
    EditText word,mean,type;
    Button insert ;
    RecyclerView Rv;
    LinearLayoutManager linearLayout;
    WordsAdapter wordsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert=findViewById(R.id.insert);
        word=findViewById(R.id.word);
        mean=findViewById(R.id.mean);
        type=findViewById(R.id.type);
Rv=findViewById(R.id.Rv);
        linearLayout=new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        Rv.setHasFixedSize(true);
        Rv.setLayoutManager(linearLayout);

        wordsViewModel= ViewModelProviders.of(this).get(WordsViewModel.class);
        wordsViewModel.allWords.observe(this, new Observer<List<Words>>() {
            @Override
            public void onChanged(List<Words> words) {
                Toast.makeText(MainActivity.this,"Words Size="+words.size(),Toast.LENGTH_LONG).show();
wordsAdapter.notifyAdapter(words);
            }
        });
        wordsAdapter=new WordsAdapter(this,wordsViewModel.allWords.getValue());
        Rv.setAdapter(wordsAdapter);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wordValue=word.getText().toString();
                String meanValue=mean.getText().toString();
                String mtypeValue=type.getText().toString();

                if (!wordValue.isEmpty()&&!meanValue.isEmpty()&&!mtypeValue.isEmpty()){
                    Words word=new Words(wordValue,meanValue,mtypeValue);
                    wordsViewModel.insert(word);
                }else{
                    Toast.makeText(MainActivity.this,"Please fill the form",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    }

