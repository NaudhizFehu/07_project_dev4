package com.dev04.client.ui.myPage;

import android.os.Bundle;
import android.util.Log;
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
import com.dev04.client.databinding.FragmentMypageBinding;
import com.dev04.client.ui.join.JoinFragment;
import com.dev04.client.ui.modify.ModifyFragment;
import com.dev04.client.ui.quit.QuitFragment;
import com.dev04.client.ui.read.ReadViewModel;
import com.dev04.client.viewObject.ArticleVO;
import com.dev04.client.viewObject.MemberVO;

import java.lang.reflect.Member;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPageFragment extends Fragment {

    private FragmentMypageBinding binding;
    private MyPageViewModel myPageViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mypage, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myPageViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(MyPageViewModel.class);
        myPageViewModel.myPage(new Callback<MemberVO>() {
            @Override
            public void onResponse(Call<MemberVO> call, Response<MemberVO> response) {
                if(response.isSuccessful()){
                    myPageViewModel.getMemberVO().setValue(response.body());
                    MemberVO vo = myPageViewModel.getMemberVO().getValue();
                    binding.mypageId.setText(vo.getId());
                    binding.mypageName.setText(vo.getName());
                    binding.mypageEmail.setText(vo.getEmail());
                    binding.mypagePhone.setText(vo.getPhoneNumber());
                } else if (requireActivity() != null){
                    Toast.makeText(requireActivity().getApplicationContext(), "마이페이지 읽기 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MemberVO> call, Throwable t) {
                if (requireActivity() != null){
                    Toast.makeText(requireActivity().getApplicationContext(), "인터넷?", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button modifyButton = view.findViewById(R.id.modify_btn);
        modifyButton.setOnClickListener(v -> {
            MemberVO vo = myPageViewModel.getMemberVO().getValue();
            ((MainActivity) requireActivity()).navigateTo(new ModifyFragment(vo), true);
        });

        final Button quitButton = view.findViewById(R.id.quit_btn);
        quitButton.setOnClickListener(v -> {
            MemberVO vo = myPageViewModel.getMemberVO().getValue();
            ((MainActivity) requireActivity()).navigateTo(new QuitFragment(vo), true);
        });

    }


}
