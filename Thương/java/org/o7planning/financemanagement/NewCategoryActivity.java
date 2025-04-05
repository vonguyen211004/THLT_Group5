package org.o7planning.financemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewCategoryActivity extends AppCompatActivity {

    private EditText categoryNameEditText;
    private Button saveButton;
    private Button cancelButton; // Khai báo nút Cancel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_category_layout);

        categoryNameEditText = findViewById(R.id.category_name_edittext);
        saveButton = findViewById(R.id.save_button);
        cancelButton = findViewById(R.id.cancel_button); // Ánh xạ nút Cancel

        // ... (code xử lý nút Save nếu có) ...

        // Thiết lập OnClickListener cho nút Cancel
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi finish() để quay trở lại Activity trước đó
                finish();
            }
        });
    }
}