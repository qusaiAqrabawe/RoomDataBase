package com.example.roomdata.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdata.dao.WordsDao;
import com.example.roomdata.ui.model.Words;

@Database(entities = Words.class,version = 1)
public abstract  class WordRoomDb extends RoomDatabase {

    private static WordRoomDb instance;
    public abstract WordsDao wordsDao();

    public static synchronized WordRoomDb getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),WordRoomDb.class,"words-db")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

}
