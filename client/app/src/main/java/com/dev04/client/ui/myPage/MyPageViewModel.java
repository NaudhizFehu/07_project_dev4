package com.dev04.client.ui.myPage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev04.client.repository.MemberRepository;
import com.dev04.client.viewObject.AuthVO;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Callback;


public class MyPageViewModel extends ViewModel {

    private final MemberRepository repository;

    // 요청값
    private MemberVO authVO = AuthVO.getInstance().getMemberVO();

    // 응답값
    private MemberVO memberVO;

    public MyPageViewModel(MemberRepository repository){
        this.repository = repository;
    }

    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public void myPage(Callback<MemberVO> callback){
        repository.myPageMember(authVO, callback);
    }
}
