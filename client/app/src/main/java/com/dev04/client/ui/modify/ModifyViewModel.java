package com.dev04.client.ui.modify;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev04.client.repository.MemberRepository;
import com.dev04.client.viewObject.AuthVO;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Callback;

public class ModifyViewModel extends ViewModel {

    private final MemberRepository repository;
    public MutableLiveData<String> id;
    public MutableLiveData<String> password;
    public MutableLiveData<String> passwordConfirm;
    public MutableLiveData<String> name;
    public MutableLiveData<String> email;
    public MutableLiveData<String> phone;
    //    public MutableLiveData<String> path;

    public ModifyViewModel(MemberRepository repository) {
        this.repository = repository;
        id = new MutableLiveData<>();
        password = new MutableLiveData<>();
        passwordConfirm = new MutableLiveData<>();
        name = new MutableLiveData<>();
        email = new MutableLiveData<>();
        phone = new MutableLiveData<>();
//        path = new MutableLiveData<>();
    }

    public void initMemberData(MemberVO memberVO){
        id.setValue(memberVO.getId());
        name.setValue(memberVO.getName());
        email.setValue(memberVO.getEmail());
        phone.setValue(memberVO.getPhoneNumber());
    }

    // 수정 요청
    public void modifyMember(Callback<Void> callback) {
        MemberVO memberVO = new MemberVO(
                id.getValue(),
                password.getValue(),
                name.getValue(),
                email.getValue(),
                phone.getValue()
//                , path.getValue()
        );
        //        File file = new File(path.getValue());

        // 리포지터리의 메소드 호출
        repository.modifyMember(memberVO, callback);
    }

    /**
     * 비어있는 정보나 잘못된 입력이 있는지 검사
     */
    boolean validateModifyInfo() {
        return validateIdAndName()
                && validatePassword()
                && validateEmail()
                && phone.getValue() != null;
    }

    /**
     *  비밀번호 & 비밀번호 확인 검사
     */
    boolean validatePassword() {
        return password.getValue() != null
                && passwordConfirm.getValue() != null
                && password.getValue().equals(passwordConfirm.getValue());
    }

    /**
     * 아이디와 이름 유효성 검사
     */
    boolean validateIdAndName() {
        return id.getValue() != null
                && !id.getValue().contains(" ")
                && name.getValue() != null
                && !name.getValue().contains(" ");
    }

    boolean validateEmail() {
        if (email.getValue() != null) {
            return email.getValue().matches("[\\S]+@[\\S]+");
        }
        return false;
    }

//    /**
//     * 썸네일 등록 여부 검사
//     */
//    boolean validateProfile() {
//        return profileUrl.getValue() != null;
//    }
}