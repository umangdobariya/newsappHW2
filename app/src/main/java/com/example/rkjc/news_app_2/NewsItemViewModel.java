package com.example.rkjc.news_app_2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.AndroidViewModel;

import java.util.List;

public class NewsItemViewModel extends AndroidViewModel {

    private NewsItemRepository mNewsItemRepository;

    private LiveData<List<NewsItem>> mAllWords;

    public NewsItemViewModel (Application application) {
        super(application);
        mNewsItemRepository = new NewsItemRepository(application);
        mAllWords = mNewsItemRepository.getAllWords();
    }

    public LiveData<List<NewsItem>> getAllWords() {
        return mAllWords;
    }

    public void insert(NewsItem word) {
        mNewsItemRepository.insert(word);
    }

    public void delete(NewsItem word){
        mNewsItemRepository.delete(word);
    }

}
