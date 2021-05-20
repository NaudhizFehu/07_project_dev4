package com.dev04.client.ui.quit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dev04.client.MainActivity;
import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentQuitBinding;
import com.dev04.client.ui.login.LoginFragment;
import com.dev04.client.ui.modify.ModifyViewModel;
import com.dev04.client.ui.myPage.MyPageFragment;
import com.dev04.client.viewObject.AuthVO;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuitFragment extends Fragment {

    private FragmentQuitBinding binding;
    private QuitViewModel quitViewModel;

    private MemberVO memberVO;
    private Context context;

    public QuitFragment(MemberVO memberVO){
        super();
        this.memberVO = memberVO;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quit, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = requireActivity().getApplicationContext();

        quitViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(QuitViewModel.class);
        quitViewModel.initMemberDatea(memberVO);
        binding.setVm(quitViewModel);

        final Button modifySubmitButton = view.findViewById(R.id.quit_submit_btn);
        modifySubmitButton.setOnClickListener(v -> {

            quitViewModel.quitMember(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        AuthVO.getInstance().setMember(null);
                        Toast.makeText(context, "탈퇴 성공", Toast.LENGTH_SHORT).show();
                        ((MainActivity) requireActivity()).navigateTo(new LoginFragment(), false);
                    } else {
                        Toast.makeText(context, "탈퇴 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "회원탈퇴: 인터넷 오류", Toast.LENGTH_SHORT).show();
                }
            });
        });

        final Button cancelButton = view.findViewById(R.id.quit_cancle_btn);
        // 취소 버튼 클릭 이벤트 처리
        cancelButton.setOnClickListener(v -> {
            // 이전 화면으로 돌아가기
            requireActivity().onBackPressed();
        });
    }


}
