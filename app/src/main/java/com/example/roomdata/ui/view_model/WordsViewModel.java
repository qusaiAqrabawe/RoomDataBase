package com.example.roomdata.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdata.reposetory.WordReposetory;
import com.example.roomdata.ui.model.Words;

import java.util.List;

public class WordsViewModel extends AndroidViewModel {

    public WordReposetory wordReposetory;
    public LiveData<List<Words>> allWords;

    public WordsViewModel(@NonNull Application application) {
        super(application);
        wordReposetory=new WordReposetory(application);
        allWords=wordReposetory.getAllWords();
    }

    public void insert(Words words){
        wordReposetory.insert(words);
    }

    public void delete(Words words){
        wordReposetory.delete(words);
    }
    public void update(Words words){
        wordReposetory.update(words);
    }
}
