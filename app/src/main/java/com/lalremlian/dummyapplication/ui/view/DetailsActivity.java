package com.lalremlian.dummyapplication.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lalremlian.dummyapplication.R;

public class DetailsActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = findViewById(R.id.details_tv);

        Intent intent = getIntent();
        String str = intent.getStringExtra("DATA");

        textView.setText(str);
    }
}