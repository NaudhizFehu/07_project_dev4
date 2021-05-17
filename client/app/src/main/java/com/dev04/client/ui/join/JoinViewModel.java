package com.dev04.client.ui.join;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev04.client.repository.MemberRepository;
import com.dev04.client.viewObject.MemberVO;

import java.io.File;

import retrofit2.Callback;

public class JoinViewModel extends ViewModel {

    private final MemberRepository repository;

    // 뷰단에서 입력된 데이터를 가져오기 위한 코드
    public MutableLiveData<String> id;
    public MutableLiveData<String> password;
    public MutableLiveData<String> passwordConfirm;
    public MutableLiveData<String> name;
    public MutableLiveData<String> email;
    public MutableLiveData<String> phone;
    public MutableLiveData<String> path;

    public JoinViewModel(MemberRepository repository) {
        this.repository = repository;
        id = new MutableLiveData<>();
        password = new MutableLiveData<>();
        passwordConfirm = new MutableLiveData<>();
        name = new MutableLiveData<>();
        email = new MutableLiveData<>();
        phone = new MutableLiveData<>();
        path = new MutableLiveData<>();
    }

    // 회원가입 버튼
    void Join(Callback<Void> callback) {
        MemberVO member = new MemberVO(
                id.getValue(),
                password.getValue(),
                name.getValue(),
                email.getValue(),
                phone.getValue(),
                path.getValue()
        );

        File file = new File(path.getValue());

        // 리포지터리의 메소드 호출
//        repository.signUpMember(member, file, callback);
    }

    // 데이터 유효성 검사
    boolean validateJoinInfo() {
        return validateIdAndName()
                && validatePassword()
                && validateEmail()
                && phone.getValue() != null;
    }

    // ID, 이름 유효성 검사
    boolean validateIdAndName() {
        return id.getValue() != null
                && !id.getValue().contains(" ")
                && name.getValue() != null
                && !name.getValue().contains(" ");
    }

    // 비밀번호 유효성 검사 및 일치 여부 확인
    boolean validatePassword() {
        return password.getValue() != null
                && passwordConfirm.getValue() != null
                && password.getValue().equals(passwordConfirm.getValue());
    }

    // 이메일 유효성 검사
    boolean validateEmail() {
        if (email.getValue() != null) {
            return email.getValue().matches("[\\S]+@[\\S]+");
        }
        return false;
    }

    // 썸네일 유효성 검사
    boolean validateProfile() {
        return path.getValue() != null;
    }
}