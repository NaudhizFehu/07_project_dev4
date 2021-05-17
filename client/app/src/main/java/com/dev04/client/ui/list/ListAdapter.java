package com.dev04.client.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.dev04.client.R;
import com.dev04.client.viewObject.ArticleVO;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
        if (viewType == R.layout.item_list_header){
            return new HeaderViewListHolder(binding.getRoot());
        } else {
            return new ViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof View)
    }

    @Override
    public int getItemCount() {
        return articleList.size() +1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == HEADER_POSITION){
            return R.layout.item_list_header;
        }
        return R.layout.item_list;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        private ImageView checkView;

        private HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

//            checkView = itemView.findViewById(R.id.check_image_view);

            checkView.setOnClickListener(v -> {

            });
        }
    }
}
