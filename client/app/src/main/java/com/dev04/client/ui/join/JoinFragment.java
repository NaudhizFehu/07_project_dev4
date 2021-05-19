package com.dev04.client.ui.join;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentJoinBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 1000;

    private ImageView profileView;

    private FragmentJoinBinding binding;
    private JoinViewModel joinViewModel;

    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_join, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.context = requireContext().getApplicationContext();

        // Data Binding 연결
        joinViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(JoinViewModel.class);

        binding.setVm(joinViewModel);

//        profileView = view.findViewById(R.id.profile_view);
//        final ImageView addProfileView = view.findViewById(R.id.add_profile_view);

        // 프로필 사진 등록 이벤트 처리
//        addProfileView.setOnClickListener(v -> {
//            checkAndRequestPermission();
//
//            // 기기에서 이미지 가져오기
//            ImagePicker.create(this)
//                    .returnMode(ReturnMode.GALLERY_ONLY)
//                    .includeVideo(false)
//                    .includeAnimation(false)
//                    .single()
//                    .limit(1)
//                    .imageDirectory("Camera")
//                    .start();
//        });

        final Button joinButton = view.findViewById(R.id.join_btn);
        // 가입하기 버튼 클릭 이벤트 처리
        joinButton.setOnClickListener(v -> {
            if (!joinViewModel.validateIdAndName()) {
                Toast.makeText(context, "아이디나 이름에 공백을 포함할 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!joinViewModel.validatePassword()) {
                Toast.makeText(context, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!joinViewModel.validateEmail()) {
                Toast.makeText(context, "이메일 형식이 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!joinViewModel.validateJoinInfo()) {
                Toast.makeText(context, "빈 칸을 모두 채워주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

//            if (!joinViewModel.validateProfile()) {
//                Toast.makeText(context, "프로필 사진을 등록해주세요.", Toast.LENGTH_SHORT).show();
//                return;
//            }

            // 회원 가입 요청
            joinViewModel.join(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(context, "회원 가입 성공", Toast.LENGTH_SHORT).show();
                        // 이전 화면으로 돌아가기
                        requireActivity().onBackPressed();
                    } else {
                        Toast.makeText(context, "회원 가입 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "회원가입: 인터넷 오류", Toast.LENGTH_SHORT).show();
                }
            });
        });

        final Button cancelButton = view.findViewById(R.id.join_cancel_btn);
        // 취소 버튼 클릭 이벤트 처리
        cancelButton.setOnClickListener(v -> {
            // 이전 화면으로 돌아가기
            requireActivity().onBackPressed();
        });

        // 프로필 이미지 설정
//        signUpViewModel.profileUrl.observe(getViewLifecycleOwner(), url -> {
//            Glide.with(requireContext())
//                    .load(url)
//                    .apply(new RequestOptions().circleCrop())
//                    .into(profileView);
//        });
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
//            Image image = ImagePicker.getFirstImageOrNull(data);
//            if (image != null) {
//                signUpViewModel.profileUrl.setValue(image.getPath());
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    /**
     * 저장소 접근 권한 확인 및 요청
     */
//    private void checkAndRequestPermission() {
//        if (requireActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(
//                    new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
//                    PERMISSION_REQUEST_CODE
//            );
//        }
//    }
}

