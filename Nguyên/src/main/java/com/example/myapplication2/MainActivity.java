package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set sự kiện khi chọn item trong Bottom Navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Ở lại MainActivity
                return true;
            } else if (id == R.id.nav_transactions) {
                // Chưa có chức năng
                return true;
            } else if (id == R.id.nav_categories) {
                // Chuyển sang CategoriesActivity
                Intent intentCategories = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(intentCategories);
                return true;
            } else if (id == R.id.nav_profile) {
                // Chưa có chức năng
                return true;
            } else if (id == R.id.nav_analysis) {
                // Chưa có chức năng
                return true;
            }

            return false;
        });
    }
}
