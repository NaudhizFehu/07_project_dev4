package com.dev04.client;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.dev04.client.repository.ArticleRepository;
import com.dev04.client.repository.MemberRepository;
import com.dev04.client.repository.NetworkAPI;
import com.dev04.client.ui.join.JoinViewModel;
import com.dev04.client.ui.list.ArticleListViewModel;
import com.dev04.client.ui.login.LoginViewModel;
import com.dev04.client.ui.modify.ModifyViewModel;
import com.dev04.client.ui.myPage.MyPageViewModel;
import com.dev04.client.ui.quit.QuitViewModel;
import com.dev04.client.ui.read.ReadViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        MemberRepository memberRepository = new MemberRepository(NetworkAPI.getInstance().getMemberService());
        ArticleRepository articleRepository = new ArticleRepository(NetworkAPI.getInstance().getArticleService());
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(memberRepository);
        } else if (modelClass.isAssignableFrom(ReadViewModel.class)) {
            return (T) new ReadViewModel(articleRepository);
        } else if (modelClass.isAssignableFrom(JoinViewModel.class)) {
            return (T) new JoinViewModel(memberRepository);
        } else if (modelClass.isAssignableFrom(MyPageViewModel.class)) {
            return (T) new MyPageViewModel(memberRepository);
        } else if (modelClass.isAssignableFrom(ModifyViewModel.class)) {
            return (T) new ModifyViewModel(memberRepository);
        } else if (modelClass.isAssignableFrom(QuitViewModel.class)) {
            return (T) new QuitViewModel(memberRepository);
        } else if (modelClass.isAssignableFrom(ArticleListViewModel.class)) {
            return (T) new ArticleListViewModel(articleRepository);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}