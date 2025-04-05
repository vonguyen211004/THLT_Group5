package com.example.financetracker.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.financetracker.MainActivity;
import com.example.financetracker.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class AnalysisFragment extends Fragment {

    private ImageButton btnBack;
    private ImageButton btnSearch;
    private ImageButton btnCalendar;
    private Button btnDaily;
    private Button btnWeekly;
    private Button btnMonthly;
    private Button btnYear;
    private BarChart barChart;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_analysis, container, false);

        btnBack = view.findViewById(R.id.btn_back);
        btnSearch = view.findViewById(R.id.btn_search);
        btnCalendar = view.findViewById(R.id.btn_calendar_analysis);
        btnDaily = view.findViewById(R.id.btn_daily);
        btnWeekly = view.findViewById(R.id.btn_weekly);
        btnMonthly = view.findViewById(R.id.btn_monthly);
        btnYear = view.findViewById(R.id.btn_year);
        barChart = view.findViewById(R.id.bar_chart);
        progressBar = view.findViewById(R.id.progress_bar);

        setupListeners();
        setupChart();
        progressBar.setProgress(30);

        return view;
    }

    private void setupListeners() {
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });

        btnSearch.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).navigateToSearch();
            }
        });

        btnCalendar.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).navigateToCalendar();
            }
        });

        // Time period buttons
        btnDaily.setOnClickListener(v -> updateTimePeriod(btnDaily));
        btnWeekly.setOnClickListener(v -> updateTimePeriod(btnWeekly));
        btnMonthly.setOnClickListener(v -> updateTimePeriod(btnMonthly));
        btnYear.setOnClickListener(v -> updateTimePeriod(btnYear));
    }

    private void updateTimePeriod(Button selectedButton) {
        // Reset all buttons
        btnDaily.setBackgroundResource(R.drawable.bg_tab_unselected);
        btnDaily.setTextColor(getResources().getColor(R.color.text_primary));
        btnWeekly.setBackgroundResource(R.drawable.bg_tab_unselected);
        btnWeekly.setTextColor(getResources().getColor(R.color.text_primary));
        btnMonthly.setBackgroundResource(R.drawable.bg_tab_unselected);
        btnMonthly.setTextColor(getResources().getColor(R.color.text_primary));
        btnYear.setBackgroundResource(R.drawable.bg_tab_unselected);
        btnYear.setTextColor(getResources().getColor(R.color.text_primary));

        // Set selected button
        selectedButton.setBackgroundResource(R.drawable.bg_tab_selected);
        selectedButton.setTextColor(getResources().getColor(R.color.white));

        // Update chart data based on selected time period
        setupChart();
    }

    private void setupChart() {
        // Sample data for the chart
        List<BarEntry> incomeEntries = new ArrayList<>();
        List<BarEntry> expenseEntries = new ArrayList<>();

        // Daily data (Mon to Sun)
        incomeEntries.add(new BarEntry(0, 3000));
        incomeEntries.add(new BarEntry(1, 1500));
        incomeEntries.add(new BarEntry(2, 2500));
        incomeEntries.add(new BarEntry(3, 1000));
        incomeEntries.add(new BarEntry(4, 8000));
        incomeEntries.add(new BarEntry(5, 500));
        incomeEntries.add(new BarEntry(6, 2000));

        expenseEntries.add(new BarEntry(0, 1000));
        expenseEntries.add(new BarEntry(1, 500));
        expenseEntries.add(new BarEntry(2, 1500));
        expenseEntries.add(new BarEntry(3, 800));
        expenseEntries.add(new BarEntry(4, 2000));
        expenseEntries.add(new BarEntry(5, 1000));
        expenseEntries.add(new BarEntry(6, 1200));

        BarDataSet incomeDataSet = new BarDataSet(incomeEntries, "Income");
        incomeDataSet.setColor(getResources().getColor(R.color.income_green));
        incomeDataSet.setValueTextColor(Color.BLACK);
        incomeDataSet.setValueTextSize(10f);

        BarDataSet expenseDataSet = new BarDataSet(expenseEntries, "Expense");
        expenseDataSet.setColor(getResources().getColor(R.color.expense_blue));
        expenseDataSet.setValueTextColor(Color.BLACK);
        expenseDataSet.setValueTextSize(10f);

        BarData barData = new BarData(incomeDataSet, expenseDataSet);
        barData.setBarWidth(0.3f);

        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);

        // X-axis setup
        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);

        // Group bars
        float groupSpace = 0.1f;
        float barSpace = 0.05f;
        barData.groupBars(0, groupSpace, barSpace);

        barChart.invalidate();
    }
}

