package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecurityPinActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_pin);

        Button btnAccept = findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityPinActivity.this, NewPasswordActivity.class);
            startActivity(intent);
        });
    }
}
