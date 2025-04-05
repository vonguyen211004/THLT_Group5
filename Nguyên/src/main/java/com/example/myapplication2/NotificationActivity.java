package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<Object> notificationList;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        recyclerView = findViewById(R.id.recyclerView);
        btnBack = findViewById(R.id.btnBack);

        // Xử lý sự kiện Back để quay lại HomeActivity
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(NotificationActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        // Khởi tạo danh sách thông báo
        notificationList = new ArrayList<>();
        notificationList.add(new NotificationHeader("Today"));
        notificationList.add(new NotificationItem("Reminder!", "Set up your automatic savings...", "17:00 - April 24"));
        notificationList.add(new NotificationItem("New Update", "Set up your automatic savings...", "17:00 - April 24"));

        notificationList.add(new NotificationHeader("Yesterday"));
        notificationList.add(new NotificationItem("Transactions", "A new transaction has been registered\nGroceries | Pantry | -$100.00", "17:00 - April 23"));
        notificationList.add(new NotificationItem("Reminder!", "Set up your automatic savings...", "17:00 - April 23"));

        notificationList.add(new NotificationHeader("This Weekend"));
        notificationList.add(new NotificationItem("Expense Record", "We recommend that you be more attentive to your finances.", "17:00 - April 22"));
        notificationList.add(new NotificationItem("Transactions", "A new transaction has been registered\nCool Drinks | Cafe | -$5.00", "17:00 - April 21"));

        // Cấu hình RecyclerView
        adapter = new NotificationAdapter(notificationList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
