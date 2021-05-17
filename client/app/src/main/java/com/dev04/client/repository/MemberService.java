package com.dev04.client.repository;


import com.dev04.client.viewObject.LoginInput;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MemberService {

//    @GET("member")
//    Call<List<Member>> getAllMembers();
//
    @POST("member/login")
    Call<MemberVO> loginMember(@Body LoginInput loginInput);
//
//    @Multipart
//    @POST("member/sign-up")
//    Call<Void> signUpMember(@Part("member") Member member, @Part MultipartBody.Part profileFile);
//
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
