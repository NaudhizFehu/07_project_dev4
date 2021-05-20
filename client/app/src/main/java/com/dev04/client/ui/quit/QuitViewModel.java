package com.dev04.client.ui.quit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev04.client.repository.ArticleRepository;
import com.dev04.client.repository.MemberRepository;
import com.dev04.client.viewObject.ArticleVO;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Callback;

public class QuitViewModel extends ViewModel {

    private MemberRepository repository;

    public MutableLiveData<String> id;
    public MutableLiveData<String> password;

    public QuitViewModel(MemberRepository repository) {
        this.repository = repository;

        this.id = new MutableLiveData<>();
        this.password = new MutableLiveData<>();
    }

    public void initMemberDatea(MemberVO memberVO) {
        id.setValue(memberVO.getId());
    }

    public void quitMember(Callback<Void> callback) {
        repository.quitMembers(new MemberVO(id.getValue(), password.getValue()), callback);
    }
}
