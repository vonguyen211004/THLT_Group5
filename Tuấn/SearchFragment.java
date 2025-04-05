package com.example.financetracker.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.financetracker.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchFragment extends Fragment {

    private ImageButton btnBack;
    private ImageButton btnDatePicker;
    private TextView tvDate;
    private Spinner spinnerCategory;
    private RadioButton radioIncome;
    private RadioButton radioExpense;
    private Button btnSearchSubmit;
    private Calendar calendar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        btnBack = view.findViewById(R.id.btn_back);
        btnDatePicker = view.findViewById(R.id.btn_date_picker);
        tvDate = view.findViewById(R.id.tv_date);
        spinnerCategory = view.findViewById(R.id.spinner_category);
        radioIncome = view.findViewById(R.id.radio_income);
        radioExpense = view.findViewById(R.id.radio_expense);
        btnSearchSubmit = view.findViewById(R.id.btn_search_submit);

        calendar = Calendar.getInstance();
        setupSpinner();
        setupListeners();
        updateDateText();

        return view;
    }

    private void setupSpinner() {
        // Sample categories
        String[] categories = {"Select the category", "Food", "Transport", "Rent", "Groceries", "Salary", "Others"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);
    }

    private void setupListeners() {
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });

        btnDatePicker.setOnClickListener(v -> showDatePickerDialog());

        btnSearchSubmit.setOnClickListener(v -> {
            // Perform search operation
            Toast.makeText(getContext(), "Searching...", Toast.LENGTH_SHORT).show();
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getContext(),
                (view, year, month, dayOfMonth) -> {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateDateText();
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void updateDateText() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd /MMM/yyyy", Locale.getDefault());
        tvDate.setText(dateFormat.format(calendar.getTime()).toUpperCase());
    }
}

