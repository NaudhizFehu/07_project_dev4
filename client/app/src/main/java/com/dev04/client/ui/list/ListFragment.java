package com.dev04.client.ui.list;

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
import androidx.recyclerview.widget.RecyclerView;

import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentListBinding;
import com.dev04.client.viewObject.ArticleVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private ListViewModel listViewModel;

    private ListAdapter listAdapter;

    private Button prevButton;
    private Button nextButton;
    private Button writeButton;
    private Button myInfoButton;
    private Button logoutButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(ListViewModel.class);




        prevButton = view.findViewById(R.id.prev_btn);
        nextButton = view.findViewById(R.id.next_btn);
        writeButton = view.findViewById(R.id.write_btn);
        myInfoButton = view.findViewById(R.id.my_page_btn);
        logoutButton = view.findViewById(R.id.logout_btn);

        listAdapter = new ListAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.list_recycler_view);
        recyclerView.setAdapter(listAdapter);

        updateList();
    }

    private void updateList(){
        listViewModel.listArticle(new Callback<List<ArticleVO>>() {
            @Override
            public void onResponse(Call<List<ArticleVO>> call, Response<List<ArticleVO>> response) {
                if(response.isSuccessful()){
                    listViewModel.getArticleList().setValue(response.body());
                    listAdapter.setArticleList(listViewModel.getArticleList().getValue());
                } else if (requireActivity() != null){
                    Toast.makeText(requireActivity().getApplicationContext(), "게시글 조회 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ArticleVO>> call, Throwable t) {
                if (requireActivity() != null) {
                    Toast.makeText(requireActivity().getApplicationContext(), "게시글리스트: 통신실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
