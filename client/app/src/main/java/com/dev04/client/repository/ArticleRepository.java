package com.dev04.client.repository;



import com.dev04.client.viewObject.ArticleVO;
import com.dev04.client.viewObject.LoginInput;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Callback;

public class ArticleRepository {
    private ArticleService articleService;

    public ArticleRepository(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void readArticle(ArticleVO articleVO, Callback<ArticleVO> callback) {
        articleService.readArticle(articleVO).enqueue(callback);
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