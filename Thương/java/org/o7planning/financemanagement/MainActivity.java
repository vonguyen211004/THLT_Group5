package org.o7planning.financemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView incomeAmount = findViewById(R.id.income_amount);
        TextView expenseAmount = findViewById(R.id.expense_amount);
        GridView categoriesGrid = findViewById(R.id.categories_grid);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        // Chuẩn bị dữ liệu cho GridView
        String[] categoryNames = {
                "Food", "Transport", "Medicine",
                "Groceries", "Rent", "Gifts",
                "Savings", "More"
        };

        // Tạo và thiết lập Adapter cho GridView
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categoryNames);
        categoriesGrid.setAdapter(categoryAdapter); // Thiết lập adapter cho GridView

        categoriesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // Thiết lập onItemClickListener cho GridView
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == categoryNames.length - 2) { // Kiểm tra nếu là item "Savings"
                    Intent intent = new Intent(MainActivity.this, SavingsActivity.class);
                    startActivity(intent);
                } else if (position == categoryNames.length - 1) { // Kiểm tra nếu là item "More"
                    Intent intent = new Intent(MainActivity.this, NewCategoryActivity.class);
                    startActivity(intent);
                }
            }
        });


        // Code xử lý bottom navigation (set onItemSelectedListener)

    }
}