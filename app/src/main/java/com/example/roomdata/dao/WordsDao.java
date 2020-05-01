package com.example.roomdata.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdata.ui.model.Words;

import java.util.List;

@Dao
public interface WordsDao {
    @Insert
    void insert(Words words);
    @Update
    void update(Words words);
    @Delete
    void  delete(Words words);
    @Query("DELETE FROM wordTable")
    void deleteAll();
    @Query("SELECT * FROM wordTable")
    LiveData<List<Words>> getAllWords();
}
