package com.dev04.client.ui.read;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev04.client.repository.ArticleRepository;
import com.dev04.client.viewObject.ArticleVO;

import retrofit2.Callback;

public class ReadViewModel extends ViewModel {

    private ArticleRepository repository;

    // 서버에 요청하기위한 게시글 번호
    private MutableLiveData<Integer> articleNo;

    // 서버의 응답을 담기위한 게시글
    private MutableLiveData<ArticleVO> articleVO;


    public ReadViewModel(ArticleRepository repository) {
        this.repository = repository;

        this.articleNo = new MutableLiveData<>();
        this.articleVO = new MutableLiveData<>();
    }

    public MutableLiveData<ArticleVO> getArticleVO() {
        return articleVO;
    }

    public void readArticle(Callback<ArticleVO> callback) {
//        repository.readArticle(new ArticleVO(articleNo.getValue()), callback);
        repository.readArticle(new ArticleVO(1), callback);
    }
}
