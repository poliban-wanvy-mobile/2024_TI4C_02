package com.example.utsppb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class skorActivity extends AppCompatActivity {
    private TextView Idskor;
    private TextView anggota;
    private Button btkeluar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_skor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Idskor = findViewById(R.id.Idskor);
        anggota = findViewById(R.id.anggota);
        btkeluar = findViewById(R.id.btkeluar);

        hasil();
        btkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    private void hasil(){
        int skor = getIntent().getIntExtra("skor", 0);

        Idskor.setText("skor anda : "+skor+"/100");

        String biodata = "Nama anggota :\n"+
                "1. Nur Mila Wati (C030322097)\n"+
                "2. Putri Fatimatuzzahra (C030322098)\n"+
                "3. Audy Rizki Maulidi (C030322073)\n"+
                "4. Akhmad Rizal Saputra (C030322071)\n"+
                "5. Muhammad Daffa Ilhamsyah (C030322087)";
        anggota.setText(biodata);
    }
    private void logout(){
        Intent intent = new Intent(skorActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}