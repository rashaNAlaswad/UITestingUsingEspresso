package com.example.uiautomationtestingusingespresso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.uiautomationtestingusingespresso.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.hiddenView.getVisibility() == View.VISIBLE) {
                    binding.hiddenView.setVisibility(View.INVISIBLE);
                } else {
                    binding.hiddenView.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            }
        });
    }

@Override
protected void onDestroy() {
    super.onDestroy();
    Log.d("MainActivity", "onDestroy called");
}

@Override
protected void onResume() {
    super.onResume();
    Log.d("MainActivity", "onResume called");
}
}