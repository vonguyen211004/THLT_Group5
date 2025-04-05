package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

public class NewPasswordActivity extends AppCompatActivity {
    private TextInputEditText etNewPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        // Ánh xạ các view theo ID đúng
        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        Button btnChangePassword = findViewById(R.id.btnChangePassword);

        // Sự kiện nhấn nút "Change Password"
        btnChangePassword.setOnClickListener(v -> changePassword());
    }

    private void changePassword() {
        String newPassword = etNewPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        // Kiểm tra xem các trường có trống không
        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra xem mật khẩu xác nhận có khớp với mật khẩu mới không
        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Giả sử bạn đã xử lý thay đổi mật khẩu ở đây (gọi API, cập nhật vào cơ sở dữ liệu...)

        // Thông báo thay đổi mật khẩu thành công
        Toast.makeText(this, "Password changed successfully!", Toast.LENGTH_SHORT).show();

        // Chuyển sang giao diện đăng nhập sau khi thay đổi mật khẩu thành công
        Intent intent = new Intent(NewPasswordActivity.this, LoginActivity.class);

        // Cờ để làm mới Activity (xóa các activity trước đó trong stack)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        // Khởi động giao diện LoginActivity
        startActivity(intent);

        // Kết thúc activity hiện tại để không quay lại được khi nhấn nút back
        finish();
    }
}
