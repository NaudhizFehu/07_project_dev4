package com.dev04.client.ui.list;

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
import androidx.recyclerview.widget.RecyclerView;

import com.dev04.client.MainActivity;
import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentArticleListBinding;
import com.dev04.client.ui.join.JoinFragment;
import com.dev04.client.ui.myPage.MyPageFragment;
import com.dev04.client.viewObject.ArticleVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListFragment extends Fragment {

    private FragmentArticleListBinding binding;
    private ArticleListViewModel articlelistViewModel;

    private ArticleListAdapter listAdapter;

    private Button prevButton;
    private Button nextButton;
    private Button writeButton;
    private Button myInfoButton;
    private Button logoutButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i("hans", "List, onCreateView");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i("hans", "List, onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        articlelistViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(ArticleListViewModel.class);

        prevButton = view.findViewById(R.id.prev_btn);
        nextButton = view.findViewById(R.id.next_btn);
        writeButton = view.findViewById(R.id.write_btn);
        myInfoButton = view.findViewById(R.id.my_page_btn);
        logoutButton = view.findViewById(R.id.logout_btn);

        Log.i("hans", "before ListAdapter");
        listAdapter = new ArticleListAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.list_recycler_view);
        recyclerView.setAdapter(listAdapter);

        updateList();

        myInfoButton.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).navigateTo(new MyPageFragment(), true);
        });
    }

    private void updateList(){
        articlelistViewModel.listArticle(new Callback<List<ArticleVO>>() {
            @Override
            public void onResponse(Call<List<ArticleVO>> call, Response<List<ArticleVO>> response) {
                if(response.isSuccessful()){
                    articlelistViewModel.getArticleList().setValue(response.body());
                    listAdapter.setArticleList(articlelistViewModel.getArticleList().getValue());
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
