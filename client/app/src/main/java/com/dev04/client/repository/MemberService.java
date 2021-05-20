package com.dev04.client.repository;


import com.dev04.client.viewObject.AuthVO;
import com.dev04.client.viewObject.MemberVO;

import java.lang.reflect.Member;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface MemberService {

//    @GET("member")
//    Call<List<Member>> getAllMembers();
//
    @POST("login")
    Call<MemberVO> loginMember(@Body MemberVO loginInput);

    @POST("join")
    Call<Void> joinMember(@Body MemberVO memberVo);
//    Call<Void> join(@Part("member") Member member, @Part MultipartBody.Part profileFile);

    @POST("myPage")
    Call<MemberVO> myPageMember(@Body MemberVO memberVO);

    @POST("changeMyInfo")
    Call<Void> modyfiMember(@Body MemberVO memberVO);
//    @Multipart
//    @POST("member/modify-profile")
//    Call<Void> modifyMemberWithProfile(@Part("member") Member member, @Part MultipartBody.Part profileFile);
//
//    @PUT("member/modify")
//    Call<Void> modifyMember(@Body Member member);
//
//    @DELETE("member")
//    Call<Void> deleteMembers(@Query("targets") String targets);
//
//    @GET("member/{name}")
//    Call<List<Member>> getMembersByName(@Path("name") String name);
}
