package com.dev04.client.ui.list;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.dev04.client.BR;
import com.dev04.client.R;
import com.dev04.client.viewObject.ArticleVO;

import java.util.ArrayList;
import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_POSITION = 0;

    private List<ArticleVO> articleList = new ArrayList<>();

    public void setArticleList(List<ArticleVO> articleList) {
        this.articleList = articleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        if (viewType == R.layout.item_list_header) {
            return new HeaderViewHolder(binding.getRoot());
        } else {
            return new ArticleViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  ArticleViewHolder) {
            ((ArticleViewHolder) holder).bind(articleList.get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return articleList.size() + 1;   // Header 가 있기 때문에 + 1
    }

    @Override
    public int getItemViewType(int position) {
        if (position == HEADER_POSITION) {
            return R.layout.item_list_header;
        }
        return R.layout.item_list;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        private HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class ArticleViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        private TextView article_no;    // 순번 텍스트
        private TextView article_readCnt;    // 순번 텍스트

        private ArticleVO articleVO;

        private ArticleViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            View itemView = binding.getRoot();
            article_no = itemView.findViewById(R.id.article_no);
            article_readCnt = itemView.findViewById(R.id.article_readCnt);
        }

        private void bind(ArticleVO articleVO) {
            this.articleVO = articleVO;

            // 데이터 바인딩 연동
            binding.setVariable(BR.article, articleVO);
            binding.executePendingBindings();

            article_no.setText(String.valueOf(articleVO.getNo()));
            article_readCnt.setText(String.valueOf(articleVO.getReadCnt()));

        }
    }
}
