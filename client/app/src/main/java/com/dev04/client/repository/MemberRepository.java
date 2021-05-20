package com.dev04.client.repository;



import android.util.Log;

import com.dev04.client.viewObject.AuthVO;
import com.dev04.client.viewObject.MemberVO;

import java.io.File;
import java.lang.reflect.Member;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;

public class MemberRepository {
    private MemberService memberService;

    public MemberRepository(MemberService memberService) {
        this.memberService = memberService;
    }

    public void loginMember(MemberVO loginInput, Callback<MemberVO> callback) {
        memberService.loginMember(loginInput).enqueue(callback);
    }

    public void joinMember(MemberVO memberVO, Callback<Void> callback){
        memberService.joinMember(memberVO).enqueue(callback);
    }

    public void myPageMember(MemberVO memberVO, Callback<MemberVO> callback){
        memberService.myPageMember(memberVO).enqueue(callback);
    }

    public void modifyMember(MemberVO memberVO, Callback<Void> callback){
        memberService.modyfiMember(memberVO).enqueue(callback);
    }

    public void quitMembers(MemberVO memberVO, Callback<Void> callback) {
        memberService.quitMember(memberVO).enqueue(callback);
    }
}