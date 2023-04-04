package com.lalremlian.dummyapplication.ui.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lalremlian.dummyapplication.R;
import com.lalremlian.dummyapplication.data.model.Post;
import com.lalremlian.dummyapplication.ui.viewModel.DetailsViewModel;
import com.lalremlian.dummyapplication.ui.viewModel.PostListViewModel;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    TextView textView;
    TextView title;
    Toolbar toolbar;

    Post postList;

    DetailsViewModel listViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String id = intent.getStringExtra("DATA");
        String stTitle = intent.getStringExtra("TITLE");

        Log.e("TAG", "onCreate: " + stTitle);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            showCustomUI();
        }
        toolbar = findViewById(R.id.toolbar);
        title = findViewById(R.id.txtToolbar);

        title.setText(stTitle);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        textView = findViewById(R.id.details_tv);

        listViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        listViewModel.getPostListObserver().observe(this, postModel -> {
            if (postModel != null) {
                postList = postModel;

                textView.setText(postList.getBody());
            }
            if (postModel == null) {
                textView.setText("No Data Found");
            }
        });
        listViewModel.makeApiCall(id);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showCustomUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}