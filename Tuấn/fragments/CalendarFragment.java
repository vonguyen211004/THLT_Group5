package com.example.financetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.financetracker.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarFragment extends Fragment {

    private ImageButton btnBack;
    private TextView tvMonth;
    private TextView tvYear;
    private GridView calendarGrid;
    private Button btnSpends;
    private Button btnCategories;
    private Calendar currentCalendar;
    private CalendarAdapter calendarAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        btnBack = view.findViewById(R.id.btn_back);
        tvMonth = view.findViewById(R.id.tv_month);
        tvYear = view.findViewById(R.id.tv_year);
        calendarGrid = view.findViewById(R.id.calendar_grid);
        btnSpends = view.findViewById(R.id.btn_spends);
        btnCategories = view.findViewById(R.id.btn_categories);

        currentCalendar = Calendar.getInstance();
        setupCalendar();
        setupListeners();

        return view;
    }

    private void setupCalendar() {
        // Set month and year text
        tvMonth.setText(getMonthName(currentCalendar.get(Calendar.MONTH)));
        tvYear.setText(String.valueOf(currentCalendar.get(Calendar.YEAR)));

        // Setup calendar grid
        calendarAdapter = new CalendarAdapter();
        calendarGrid.setAdapter(calendarAdapter);
    }

    private void setupListeners() {
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });

        btnSpends.setOnClickListener(v -> updateTabSelection(true));
        btnCategories.setOnClickListener(v -> updateTabSelection(false));
    }

    private void updateTabSelection(boolean isSpends) {
        if (isSpends) {
            btnSpends.setBackgroundResource(R.drawable.bg_button);
            btnSpends.setTextColor(getResources().getColor(R.color.white));
            btnCategories.setBackgroundResource(R.drawable.bg_search);
            btnCategories.setTextColor(getResources().getColor(R.color.text_primary));
        } else {
            btnCategories.setBackgroundResource(R.drawable.bg_button);
            btnCategories.setTextColor(getResources().getColor(R.color.white));
            btnSpends.setBackgroundResource(R.drawable.bg_search);
            btnSpends.setTextColor(getResources().getColor(R.color.text_primary));
        }
    }

    private String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[month];
    }

    private class CalendarAdapter extends BaseAdapter {
        private List<String> days;

        public CalendarAdapter() {
            days = new ArrayList<>();
            populateDays();
        }

        private void populateDays() {
            days.clear();
            
            // Get the first day of the month
            Calendar calendar = (Calendar) currentCalendar.clone();
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            int firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            
            // Adjust for Monday as first day of week
            if (firstDayOfMonth == 0) firstDayOfMonth = 7;
            firstDayOfMonth -= 1;
            
            // Add empty spaces for days before the 1st of the month
            for (int i = 0; i < firstDayOfMonth; i++) {
                days.add("");
            }
            
            // Add days of the month
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int i = 1; i <= daysInMonth; i++) {
                days.add(String.valueOf(i));
            }
        }

        @Override
        public int getCount() {
            return days.size();
        }

        @Override
        public Object getItem(int position) {
            return days.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_calendar_day, parent, false);
            }
            
            TextView tvDay = convertView.findViewById(R.id.tv_day);
            String day = days.get(position);
            tvDay.setText(day);
            
            // Highlight current day
            if (!day.isEmpty()) {
                int dayNum = Integer.parseInt(day);
                if (dayNum == currentCalendar.get(Calendar.DAY_OF_MONTH)) {
                    tvDay.setBackgroundResource(R.drawable.bg_circle_blue);
                    tvDay.setTextColor(getResources().getColor(R.color.white));
                } else {
                    tvDay.setBackground(null);
                    tvDay.setTextColor(getResources().getColor(R.color.text_primary));
                }
            }
            
            return convertView;
        }
    }
}

