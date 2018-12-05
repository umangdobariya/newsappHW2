package com.example.rkjc.news_app_2;

import android.arch.lifecycle.LiveData;
import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import java.util.List;

public class NewsItemRepository {
    private NewsItemDao newsItemDao;
    private LiveData<List<NewsItem>> mAllWords;


    public NewsItemRepository(Application application){
         NewsItemRoomDatabase NIR =  NewsItemRoomDatabase.getDatabase(application.getApplicationContext());
        newsItemDao = NIR.newsItemDao();
        mAllWords = newsItemDao.getAllWords();
    }

    LiveData<List<NewsItem>> getAllWords() {
        return mAllWords;
    }

    public void insert (NewsItem newsItem) {
        new insertAsyncTask(newsItemDao).execute(newsItem);
    }

    public void delete(NewsItem newsItem){
        new deleteAsyncTask(newsItemDao).execute(newsItem);
    }

    private static class insertAsyncTask extends AsyncTask<NewsItem, Void, Void> {
        private NewsItemDao mAsyncTaskDao;
        insertAsyncTask(NewsItemDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final NewsItem... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<NewsItem, Void, Void> {
        private NewsItemDao mAsyncTaskDao;
        deleteAsyncTask(NewsItemDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final NewsItem... params) {
         //   Log.d("mycode", "deleteding word: " + params[0].getWord());
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}
