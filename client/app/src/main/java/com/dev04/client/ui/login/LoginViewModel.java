package com.dev04.client.ui.login;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev04.client.repository.MemberRepository;
import com.dev04.client.viewObject.LoginInput;
import com.dev04.client.viewObject.Member;

import retrofit2.Callback;

public class LoginViewModel extends ViewModel {
    private final MemberRepository repository;
    public MutableLiveData<String> id;
    public MutableLiveData<String> password;

    public LoginViewModel(MemberRepository repository) {
        this.repository = repository;
        id = new MutableLiveData<>();
        password = new MutableLiveData<>();
    }

    /**
     * 로그인 요청
     * @param callback 요청에 대한 응답 콜백
     */
    void login(Callback<Member> callback) {
        repository.loginMember(new LoginInput(id.getValue(), password.getValue()), callback);
    }

    /**
     * 아이디 비밀번호가 비어있진 않은지 검사
     */
    boolean validateLoginInfo() {
        return id.getValue() != null && password.getValue() != null;
    }
}