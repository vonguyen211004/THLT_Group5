package org.o7planning.financemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.o7planning.financemanagement.SavingsAdapter;

public class SavingsActivity extends AppCompatActivity {

    private GridView savingsGrid;
    private String[] savingsItems = {
            "Travel", "New House", "Car",
            "Wedding"
    };
    private Button addSavingsButton; // Khai báo biến cho nút

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savings_layout);

        savingsGrid = findViewById(R.id.savings_grid);
        addSavingsButton = findViewById(R.id.add_savings_button); // Ánh xạ nút

        // Tạo và thiết lập Adapter cho GridView Savings
        SavingsAdapter savingsAdapter = new SavingsAdapter(this, savingsItems);
        savingsGrid.setAdapter(savingsAdapter);

        // Thiết lập OnItemClickListener cho GridView Savings
        savingsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = savingsItems[position];
                if (selectedItem.equals("Travel")) {
                    Intent intent = new Intent(SavingsActivity.this, TravelActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SavingsActivity.this, "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
                    // Xử lý click cho các mục khác nếu cần
                }
            }
        });

    }
}