package com.dev04.client;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.dev04.client.repository.MemberRepository;
import com.dev04.client.repository.NetworkAPI;
import com.dev04.client.ui.login.LoginViewModel;


public class ViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        MemberRepository memberRepository = new MemberRepository(NetworkAPI.getInstance().getMemberService());
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(memberRepository);
//        } else if (modelClass.isAssignableFrom(SignUpViewModel.class)) {
//            return (T) new SignUpViewModel(memberRepository);
//        } else if (modelClass.isAssignableFrom(ModifyViewModel.class)) {
//            return (T) new ModifyViewModel(memberRepository);
//        } else if (modelClass.isAssignableFrom(MemberListViewModel.class)) {
//            return (T) new MemberListViewModel(memberRepository);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}