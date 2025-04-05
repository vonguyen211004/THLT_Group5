package com.example.financetracker;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.financetracker.fragments.AnalysisFragment;
import com.example.financetracker.fragments.CalendarFragment;
import com.example.financetracker.fragments.QuicklyAnalysisFragment;
import com.example.financetracker.fragments.SearchFragment;
import com.example.financetracker.fragments.TransactionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Load default fragment
        loadFragment(new TransactionFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.menu_home) {
            fragment = new QuicklyAnalysisFragment();
        } else if (item.getItemId() == R.id.menu_analysis) {
            fragment = new AnalysisFragment();
        } else if (item.getItemId() == R.id.menu_transaction) {
            fragment = new TransactionFragment();
        } else if (item.getItemId() == R.id.menu_category) {
            // Placeholder for Category fragment
            fragment = new TransactionFragment();
        } else if (item.getItemId() == R.id.menu_profile) {
            // Placeholder for Profile fragment
            fragment = new TransactionFragment();
        }

        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    // Method to navigate to search fragment
    public void navigateToSearch() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new SearchFragment())
                .addToBackStack(null)
                .commit();
    }

    // Method to navigate to calendar fragment
    public void navigateToCalendar() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new CalendarFragment())
                .addToBackStack(null)
                .commit();
    }
}

