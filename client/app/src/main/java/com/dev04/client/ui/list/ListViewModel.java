package com.dev04.client.ui.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev04.client.repository.ArticleRepository;
import com.dev04.client.viewObject.ArticleVO;

import java.util.List;

import retrofit2.Callback;

public class ListViewModel extends ViewModel {

    private final ArticleRepository repository;

    private MutableLiveData<List<ArticleVO>> articleList;

    public ListViewModel(ArticleRepository repository) {
        this.repository = repository;

        articleList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ArticleVO>> getArticleList() {
        return articleList;
    }

    // 리포지터리 메소드 호출
    public void listArticle(Callback<List<ArticleVO>> callback){
        repository.listArticle(callback);
    }

    // 게시글 읽기 메소드


}
