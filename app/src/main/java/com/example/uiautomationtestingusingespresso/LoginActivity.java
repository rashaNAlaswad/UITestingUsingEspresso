package com.example.uiautomationtestingusingespresso;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uiautomationtestingusingespresso.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
                validatePassword();
            }
        });
    }

    private void validateEmail() {
        String email = binding.emailEditText.getText().toString().trim();
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailValidationText.setVisibility(View.VISIBLE);
        } else {
            binding.emailValidationText.setVisibility(View.INVISIBLE);
        }
    }

    private void validatePassword() {
        String password = binding.passwordEditText.getText().toString().trim();
        if (password.length() >= 6) {
            binding.passwordValidationText.setVisibility(View.VISIBLE);
        } else {
            binding.passwordValidationText.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LoginActivity", "onDestroy called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LoginActivity", "onResume called");
    }
}