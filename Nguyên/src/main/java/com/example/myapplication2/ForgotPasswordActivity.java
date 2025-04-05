package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText etUsernameOrEmail;
    private Button btnNextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Ánh xạ view
        etUsernameOrEmail = findViewById(R.id.etEmail);
        btnNextStep = findViewById(R.id.btnNextStep);

        btnNextStep.setOnClickListener(v -> {
            String userInput = etUsernameOrEmail.getText().toString().trim();

            if (TextUtils.isEmpty(userInput)) {
                Toast.makeText(ForgotPasswordActivity.this, "Please enter your email or username", Toast.LENGTH_SHORT).show();
            } else {
                // TODO: Xác thực username/email nếu cần thiết tại đây (gọi API, kiểm tra DB, v.v.)

                // Chuyển sang giao diện nhập mã pin
                Intent intent = new Intent(ForgotPasswordActivity.this, SecurityPinActivity.class);
                // Nếu muốn truyền dữ liệu:
                // intent.putExtra("username", userInput);
                startActivity(intent);
            }
        });
    }
}
