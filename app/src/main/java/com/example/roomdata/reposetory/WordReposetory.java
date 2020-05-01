package com.example.roomdata.reposetory;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomdata.dao.WordsDao;
import com.example.roomdata.data.WordRoomDb;
import com.example.roomdata.ui.model.Words;

import java.util.List;

public class WordReposetory {

    WordsDao wordsDao;
    LiveData<List<Words>> getAllWords;

    public WordReposetory(Application application) {
        WordRoomDb db = WordRoomDb.getInstance(application);
        wordsDao = db.wordsDao();
        getAllWords = wordsDao.getAllWords();
    }

    public void insert(Words word) {
        new InsertTask(wordsDao).execute(word);
    }

    public void delete(Words word) {
        new DeleteTask(wordsDao).execute(word);
    }

    public void update(Words word) {
        new UpdateTask(wordsDao).execute(word);
    }

    public void detleteAll() {
        new DeleteAllTask(wordsDao).execute();
    }

    public LiveData<List<Words>> getAllWords() {
        return getAllWords;
    }

    private static class InsertTask extends AsyncTask<Words, Void, Void> {
        WordsDao wordsDao;

        public InsertTask(WordsDao dao) {
            wordsDao = dao;
        }

        @Override
        protected Void doInBackground(Words... word) {
            wordsDao.insert(word[0]);

            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Words, Void, Void> {
        WordsDao wordsDao;

        public DeleteTask(WordsDao dao) {
            wordsDao = dao;
        }

        @Override
        protected Void doInBackground(Words... word) {
            wordsDao.delete(word[0]);

            return null;
        }
    }

    private static class UpdateTask extends AsyncTask<Words, Void, Void> {
        WordsDao wordsDao;

        public UpdateTask(WordsDao dao) {
            wordsDao = dao;
        }

        @Override
        protected Void doInBackground(Words... word) {
            wordsDao.update(word[0]);

            return null;
        }
    }

    private static class DeleteAllTask extends AsyncTask<Void, Void, Void> {
        WordsDao wordsDao;

        public DeleteAllTask(WordsDao dao) {
            wordsDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordsDao.deleteAll();
            return null;
        }
    }

}
