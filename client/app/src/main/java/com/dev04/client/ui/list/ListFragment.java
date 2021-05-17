package com.dev04.client.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.dev04.client.R;
import com.dev04.client.ViewModelFactory;
import com.dev04.client.databinding.FragmentListBinding;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private ListViewModel listViewModel;

//    private ListAdapter listAdapter;

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

//        listAdapter = new ListAdapter();
//        RecyclerView recyclerView = view.
    }
}
