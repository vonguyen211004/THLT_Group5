package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import adapter.TransactionAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private RecyclerView rvTransactions;
    private Button btnDaily, btnWeekly, btnMonthly;
    private ImageButton btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        rvTransactions = findViewById(R.id.rvTransactions);
        btnDaily = findViewById(R.id.btnDaily);
        btnWeekly = findViewById(R.id.btnWeekly);
        btnMonthly = findViewById(R.id.btnMonthly);
        btnNotification = findViewById(R.id.btnNotification);

        // Set up bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        // Set up transactions recycler view
        setupTransactionsRecyclerView();

        // Set up time filter buttons
        btnDaily.setOnClickListener(v -> {
            Toast.makeText(this, "Daily view selected", Toast.LENGTH_SHORT).show();
        });

        btnWeekly.setOnClickListener(v -> {
            Toast.makeText(this, "Weekly view selected", Toast.LENGTH_SHORT).show();
        });

        btnMonthly.setOnClickListener(v -> {
            Toast.makeText(this, "Monthly view selected", Toast.LENGTH_SHORT).show();
        });

        btnNotification.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, NotificationActivity.class);
            startActivity(intent);
        });
    }

    private void setupTransactionsRecyclerView() {
        // Create sample transaction data
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Salary", "17:00 - April 24", 4000.00, true));
        transactions.add(new Transaction("Groceries", "17:00 - April 24", 100.00, false));
        transactions.add(new Transaction("Rent", "16:30 - April 24", 874.40, false));

        // Set up adapter and layout manager
        TransactionAdapter adapter = new TransactionAdapter(transactions);
        rvTransactions.setAdapter(adapter);
        rvTransactions.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            return true;

        } else if (itemId == R.id.nav_transactions) {
            Toast.makeText(this, "Transactions clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.nav_profile) {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

    // Transaction model class
    public static class Transaction {
        private final String title;
        private final String time;
        private final double amount;
        private final boolean isIncome;

        public Transaction(String title, String time, double amount, boolean isIncome) {
            this.title = title;
            this.time = time;
            this.amount = amount;
            this.isIncome = isIncome;
        }

        public String getTitle() {
            return title;
        }

        public String getTime() {
            return time;
        }

        public double getAmount() {
            return amount;
        }

        public boolean isIncome() {
            return isIncome;
        }
    }
}