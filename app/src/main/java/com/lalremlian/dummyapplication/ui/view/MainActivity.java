package com.lalremlian.dummyapplication.ui.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lalremlian.dummyapplication.R;
import com.lalremlian.dummyapplication.adapters.RecyclerAdapter;
import com.lalremlian.dummyapplication.data.model.Post;
import com.lalremlian.dummyapplication.ui.viewModel.PostListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Post> postList;
    PostListViewModel listViewModel;
    RecyclerAdapter adapter;
    TextView textView;
    TextView title;

    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCustomUI();

        toolbar = findViewById(R.id.toolbar);
        title = findViewById(R.id.txtToolbar);

        title.setText("Posts");

        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.data_not_found_tv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter(postList, this);
        recyclerView.setAdapter(adapter);

        listViewModel = new ViewModelProvider(this).get(PostListViewModel.class);
        listViewModel.getPostListObserver().observe(this, postModel -> {
            if (postModel != null) {
                postList = postModel;
                adapter.updatepostlist(postModel);
                textView.setVisibility(View.GONE);
            }
            if (postModel == null) {
                recyclerView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
            }
        });
        listViewModel.makeApiCall();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showCustomUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}