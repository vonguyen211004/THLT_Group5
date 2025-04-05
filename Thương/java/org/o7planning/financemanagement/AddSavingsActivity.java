package org.o7planning.financemanagement;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddSavingsActivity extends AppCompatActivity {

    private EditText dateEditText;
    private Spinner categorySpinner;
    private EditText amountEditText;
    private EditText expenseTitleEditText;
    private EditText messageEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_savings_layout);

        dateEditText = findViewById(R.id.date_edit_text);
        categorySpinner = findViewById(R.id.category_spinner);
        amountEditText = findViewById(R.id.amount_edit_text);
        expenseTitleEditText = findViewById(R.id.expense_title_edit_text);
        messageEditText = findViewById(R.id.message_edit_text);
        saveButton = findViewById(R.id.save_button);

        // Thiết lập DatePickerDialog khi nhấp vào trường Date
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddSavingsActivity.this,
                        (view, year1, monthOfYear, dayOfMonth) -> {
                            String formattedDate = String.format("%02d/%02d/%d", dayOfMonth, monthOfYear + 1, year1);
                            dateEditText.setText(formattedDate);
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

        // Thiết lập dữ liệu cho Spinner (ví dụ: các danh mục tiết kiệm)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.savings_categories, // Tạo một array trong res/values/strings.xml
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        // Xử lý sự kiện click nút Save
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = dateEditText.getText().toString();
                String category = categorySpinner.getSelectedItem().toString();
                String amount = amountEditText.getText().toString();
                String title = expenseTitleEditText.getText().toString();
                String message = messageEditText.getText().toString();

                // TODO: Lưu thông tin tiết kiệm vào database hoặc xử lý theo nghiệp vụ của bạn
                // Ví dụ: Hiển thị Toast thông báo đã lưu
            }
        });

        // ... (xử lý nút back nếu cần) ...
    }
}