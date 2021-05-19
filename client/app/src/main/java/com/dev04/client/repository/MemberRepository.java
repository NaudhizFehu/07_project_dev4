package com.dev04.client.repository;



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

//    public void signUpMember(Member member, File file, Callback<Void> callback) {
//        MultipartBody.Part profileFile = MultipartBody.Part.createFormData(
//                "profilePic",
//                file.getName(),
//                RequestBody.create(MediaType.parse("image/*"), file));
//
//        memberService.signUpMember(member, profileFile).enqueue(callback);
//    }
//
//    public void getAllMembers(Callback<List<Member>> callback) {
//        memberService.getAllMembers().enqueue(callback);
//    }
//
//    public void modifyMember(Member member, Callback<Void> callback) {
//        memberService.modifyMember(member).enqueue(callback);
//    }
//
//    public void modifyMember(Member member, File file, Callback<Void> callback) {
//        MultipartBody.Part profileFile = MultipartBody.Part.createFormData(
//                "profilePic",
//                file.getName(),
//                RequestBody.create(MediaType.parse("image/*"), file));
//
//        memberService.modifyMemberWithProfile(member, profileFile).enqueue(callback);
//    }
//
//    public void deleteMembers(String targets, Callback<Void> callback) {
//        memberService.deleteMembers(targets).enqueue(callback);
//    }
//
//    public void getMembersByName(String name, Callback<List<Member>> callback) {
//        memberService.getMembersByName(name).enqueue(callback);
//    }
}