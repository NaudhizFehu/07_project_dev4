package com.dev04.client.ui.read;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentReadBinding;
import com.dev04.client.viewObject.ArticleVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadFragment extends Fragment {

    private FragmentReadBinding binding;
    private ReadViewModel readViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_read, container, true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(ReadViewModel.class);
        readViewModel.readArticle(new Callback<ArticleVO>() {
            @Override
            public void onResponse(Call<ArticleVO> call, Response<ArticleVO> response) {
                if(response.isSuccessful()){
                    readViewModel.getArticleVO().setValue(response.body());
                    ArticleVO vo = readViewModel.getArticleVO().getValue();
                    binding.title.setText(vo.getTitle());
                    binding.writerName.setText(vo.getWriterName());
                    binding.content.setText(vo.getContent());
                } else if (requireActivity() != null){
                    Toast.makeText(requireActivity().getApplicationContext(), "게시글 읽기 싪패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArticleVO> call, Throwable t) {
                if (requireActivity() != null){
                    Toast.makeText(requireActivity().getApplicationContext(), "인터넷?", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
