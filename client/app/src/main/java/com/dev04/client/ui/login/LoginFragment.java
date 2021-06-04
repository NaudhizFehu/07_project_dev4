package com.dev04.client.ui.login;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dev04.client.MainActivity;
import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentLoginBinding;
import com.dev04.client.ui.join.JoinFragment;
import com.dev04.client.ui.list.ArticleListFragment;
import com.dev04.client.viewObject.AuthVO;
import com.dev04.client.viewObject.MemberVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    // DataBinding에 의해 자동으로 생성된 클래스
    private FragmentLoginBinding binding;

    private LoginViewModel loginViewModel;



    @Nullable
    @Override
    // 프라그먼트 실행시 장치에 출력될 화면 구성
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Data Binding 연결
        loginViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(LoginViewModel.class);
        binding.setVm(loginViewModel);

        final Button loginButton = view.findViewById(R.id.login_btn);
        final Button joinButton = view.findViewById(R.id.join_btn);

        loginButton.setOnClickListener(v -> {
            // ID, PW 비어있는지 확인
            if (!loginViewModel.validateLoginInfo()) {
                Toast.makeText(requireActivity().getApplicationContext(), "아이디, 비밀번호는 반드시 입력해야합니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            loginViewModel.login(new Callback<MemberVO>() {
                /**
                 * 로그인 성공
                 */
                @Override
                public void onResponse(Call<MemberVO> call, Response<MemberVO> response) {
                    if (response.isSuccessful()) {
                        MemberVO memberVO = response.body();
                        // 로그인된 회원 정보 저장
                        AuthVO.getInstance().setMember(memberVO);

                        // 팝업 메세지
                        if (requireActivity() != null) {
                            Toast.makeText(requireActivity().getApplicationContext().getApplicationContext(), String.format("%s 회원님, 환영합니다.", memberVO.getName()), Toast.LENGTH_SHORT).show();
                        }

                        // 로그인시 화면 전환
                        Log.i("hans", "go to List");
                        ((MainActivity) requireActivity()).navigateTo(new ArticleListFragment(), false);
                    } else if (requireActivity() != null) {
                        Toast.makeText(requireActivity().getApplicationContext(), "회원가입을 해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }

                /**
                 * 로그인 실패
                 */
                @Override
                public void onFailure(Call<MemberVO> call, Throwable t) {
                    if (requireActivity() != null) {
                        Toast.makeText(requireActivity().getApplicationContext(), "로그인 실패. 인터넷 연결 상태를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });

        joinButton.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).navigateTo(new JoinFragment(), true);
        });
    }
}