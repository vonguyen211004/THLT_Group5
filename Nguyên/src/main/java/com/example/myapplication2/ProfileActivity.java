package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private LinearLayout btnLogout; // Khai báo biến để lưu trữ nút Logout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Set layout cho Activity này

        // Khởi tạo các phần tử giao diện
        btnLogout = findViewById(R.id.btnLogout); // Tìm nút Logout trong layout

        // Xử lý sự kiện khi người dùng nhấn vào nút "Logout"
        btnLogout.setOnClickListener(v -> {
            // Hiển thị thông báo Logout
            Toast.makeText(ProfileActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();

            // Đóng tất cả các Activity trong stack và kết thúc ứng dụng
            finishAffinity(); // Kết thúc tất cả các Activity đang chạy và thoát ứng dụng
        });
    }
}
