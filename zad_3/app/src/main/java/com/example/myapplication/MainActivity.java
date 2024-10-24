package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private CountViewModel viewModel;
    private TextView countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeViewModel();
        setUpListeners();
    }

    private void initializeViews() {
        countTextView = findViewById(R.id.textViewCount);
        Button incrementButton = findViewById(R.id.buttonIncrement);
    }

    private void initializeViewModel() {
        viewModel = new ViewModelProvider(this).get(CountViewModel.class);
        updateCountDisplay();
    }

    private void setUpListeners() {
        findViewById(R.id.buttonIncrement).setOnClickListener(view -> {
            viewModel.incrementCount();
            updateCountDisplay();
        });
    }

    private void updateCountDisplay() {
        countTextView.setText(String.format("Licznik: %d", viewModel.getCount()));
    }
}
