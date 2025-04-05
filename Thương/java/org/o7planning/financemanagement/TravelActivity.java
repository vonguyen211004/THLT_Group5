package org.o7planning.financemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Import Button
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TravelActivity extends AppCompatActivity {

    private Button addSavingsButton; // Khai báo biến Button
    private RecyclerView transactionsRecyclerView;
    private TransactionAdapter transactionsAdapter;
    private List<Transaction> transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_layout);

        ImageView goalImage = findViewById(R.id.goal_image);
        goalImage.setImageResource(R.drawable.ic_airplane); // Đặt icon máy bay

        ProgressBar savingsProgress = findViewById(R.id.savings_progress);
        TextView progressPercentage = findViewById(R.id.progress_percentage);
        TextView progressAmount = findViewById(R.id.progress_amount);

        savingsProgress.setMax(196293);
        savingsProgress.setProgress(65331);
        progressPercentage.setText("33%");
        progressAmount.setText("653.31 of 1,962.93");

        transactionsRecyclerView = findViewById(R.id.transactions_recycler_view);
        transactionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo dữ liệu giao dịch mẫu
        transactionList = new ArrayList<>();
        transactionList.add(new Transaction("Travel Deposit", "12:30 - April 20", 217.77));
        transactionList.add(new Transaction("Travel Deposit", "10:45 - April 14", 217.77));
        transactionList.add(new Transaction("Travel Deposit", "09:00 - April 07", 217.77));

        transactionsAdapter = new TransactionAdapter(transactionList);
        transactionsRecyclerView.setAdapter(transactionsAdapter);

        addSavingsButton = findViewById(R.id.add_savings_button); // Ánh xạ Button
        addSavingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelActivity.this, AddSavingsActivity.class);
                startActivity(intent);
            }
        });
    }
}