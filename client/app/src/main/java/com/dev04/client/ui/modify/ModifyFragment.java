package com.dev04.client.ui.modify;

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

import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentModifyBinding;
import com.dev04.client.databinding.FragmentMypageBinding;
import com.dev04.client.ui.myPage.MyPageViewModel;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifyFragment extends Fragment {

    private FragmentModifyBinding binding;
    private ModifyViewModel modifyViewModel;

    private MemberVO memberVO;
    private Context context;

    public ModifyFragment(MemberVO memberVO){
        super();
        this.memberVO = memberVO;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_modify, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context =requireActivity().getApplicationContext();

        modifyViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(ModifyViewModel.class);
        modifyViewModel.initMemberData(memberVO);
        binding.setVm(modifyViewModel);

        final Button modifySubmitButton = view.findViewById(R.id.modify_submit_btn);
        modifySubmitButton.setOnClickListener(v -> {
            if (!modifyViewModel.validateIdAndName()) {
                Toast.makeText(context, "아이디나 이름에 공백을 포함할 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!modifyViewModel.validatePassword()) {
                Toast.makeText(context, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!modifyViewModel.validateEmail()) {
                Toast.makeText(context, "이메일 형식이 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!modifyViewModel.validateModifyInfo()) {
                Toast.makeText(context, "빈 칸을 모두 채워주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

//            if (!joinViewModel.validateProfile()) {
//                Toast.makeText(context, "프로필 사진을 등록해주세요.", Toast.LENGTH_SHORT).show();
//                return;
//            }

            // 회원 정보 수정 요청
            modifyViewModel.modifyMember(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(context, "회원 정보 수정 성공", Toast.LENGTH_SHORT).show();
                        // 이전 화면으로 돌아가기
                        requireActivity().onBackPressed();
                    } else {
                        Toast.makeText(context, "회원 정보 수정 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "회원정보수정: 인터넷 오류", Toast.LENGTH_SHORT).show();
                }
            });
        });

        final Button cancelButton = view.findViewById(R.id.modify_cancel_btn);
        // 취소 버튼 클릭 이벤트 처리
        cancelButton.setOnClickListener(v -> {
            // 이전 화면으로 돌아가기
            requireActivity().onBackPressed();
        });

//        final Button modifyButton = view.findViewById(R.id.modify_btn);
//        modifyButton.setOnClickListener(v -> {
////            ((MainActivity) requireActivity()).navigateTo(new ModifyFragment(), true);
//        });
//
//        final Button quitButton = view.findViewById(R.id.quit_btn);
//        quitButton.setOnClickListener(v -> {
////            ((MainActivity) requireActivity()).navigateTo(new QuitFragment(), true);
//        });

    }


}
