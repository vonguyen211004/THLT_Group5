package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    private TextInputLayout tilFullName;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPhone;
    private TextInputLayout tilDateOfBirth;
    private TextInputLayout tilPassword;
    private TextInputLayout tilConfirmPassword;
    private Button btnSignup;
    private TextView tvTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        tilFullName = findViewById(R.id.tilFullName);
        tilEmail = findViewById(R.id.tilEmail);
        tilPhone = findViewById(R.id.tilPhone);
        tilDateOfBirth = findViewById(R.id.tilDateOfBirth);
        tilPassword = findViewById(R.id.tilPassword);
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);
        btnSignup = findViewById(R.id.btnSignup);
        tvTerms = findViewById(R.id.tvTerms);

        // Set click listeners
        btnSignup.setOnClickListener(v -> {
            // Validate input
            if (validateInput()) {
                // Quay lại màn hình đăng nhập sau khi đăng ký thành công
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Đóng SignupActivity để không quay lại được khi nhấn Back
            }
        });
    }

    private boolean validateInput() {
        boolean isValid = true;

        String fullName = tilFullName.getEditText().getText().toString().trim();
        String email = tilEmail.getEditText().getText().toString().trim();
        String phone = tilPhone.getEditText().getText().toString().trim();
        String dateOfBirth = tilDateOfBirth.getEditText().getText().toString().trim();
        String password = tilPassword.getEditText().getText().toString().trim();
        String confirmPassword = tilConfirmPassword.getEditText().getText().toString().trim();

        if (fullName.isEmpty()) {
            tilFullName.setError("Full name cannot be empty");
            isValid = false;
        } else {
            tilFullName.setError(null);
        }

        if (email.isEmpty()) {
            tilEmail.setError("Email cannot be empty");
            isValid = false;
        } else {
            tilEmail.setError(null);
        }

        if (phone.isEmpty()) {
            tilPhone.setError("Phone number cannot be empty");
            isValid = false;
        } else {
            tilPhone.setError(null);
        }

        if (dateOfBirth.isEmpty()) {
            tilDateOfBirth.setError("Date of birth cannot be empty");
            isValid = false;
        } else {
            tilDateOfBirth.setError(null);
        }

        if (password.isEmpty()) {
            tilPassword.setError("Password cannot be empty");
            isValid = false;
        } else {
            tilPassword.setError(null);
        }

        if (confirmPassword.isEmpty()) {
            tilConfirmPassword.setError("Confirm password cannot be empty");
            isValid = false;
        } else if (!confirmPassword.equals(password)) {
            tilConfirmPassword.setError("Passwords do not match");
            isValid = false;
        } else {
            tilConfirmPassword.setError(null);
        }

        return isValid;
    }
}