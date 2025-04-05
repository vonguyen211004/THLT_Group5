package com.example.financetracker.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class QuicklyAnalysisFragment extends Fragment {

    private ImageButton btnBack;
    private ImageButton btnSearch;
    private ImageButton btnCalendar;
    private BarChart barChart;
    private ProgressBar progressCircular;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quickly_analysis, container, false);

        btnBack = view.findViewById(R.id.btn_back);
        btnSearch = view.findViewById(R.id.btn_search);
        btnCalendar = view.findViewById(R.id.btn_calendar_analysis);
        barChart = view.findViewById(R.id.bar_chart);
        progressCircular = view.findViewById(R.id.progress_circular);

        setupListeners();
        setupChart();
        progressCircular.setProgress(75);

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
    }

    private void setupChart() {
        // Sample data for the chart
        List<BarEntry> entries = new ArrayList<>();

        // Weekly data
        entries.add(new BarEntry(0, new float[]{500, 1000}));
        entries.add(new BarEntry(1, new float[]{2000, 500}));
        entries.add(new BarEntry(2, new float[]{1000, 3000}));
        entries.add(new BarEntry(3, new float[]{5000, 2000}));

        BarDataSet dataSet = new BarDataSet(entries, "Weekly Expenses");
        dataSet.setColors(getResources().getColor(R.color.income_green), getResources().getColor(R.color.expense_blue));
        dataSet.setStackLabels(new String[]{"Income", "Expense"});
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(10f);

        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.5f);

        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);

        // X-axis setup
        String[] weeks = new String[]{"1st Week", "2nd Week", "3rd Week", "4th Week"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(weeks));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);

        barChart.invalidate();
    }
}

