package com.example.utsppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {

    private TextView tvpertanyaan;
    private RadioGroup radiogrup;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Button btquiz;
    //array pertanyaan
    private String[] pertanyaan = {
            "Berapa hasil dari 2 + 2?",
            "Apa nama ibukota dari negara francis?",
            "Planet apa yang dikenal dengan nama planet merah",
            "Apa nama samudra terbesar di bumi",
            "Berapa jumlah provinsi di indonesia"
    };
    //array opsi jawaban untuk setiap pertanyaan
    private String[][] pilihan = {
            {"1","2","3","4"},
            {"Berlin","Madrid","Paris","Roma"},
            {"Bumi","Mars","Jupiter","Saturnus"},
            {"Atlantic","Hindia","Pasifik","Arctic"},
            {"38","35","34","37"},
    };
    //indeks jawaban benar untuk setiap pertanyaan
    private int[] jawabanbenar = {3,2,1,2,0};
    private int pertanyaansekarang = 0;
    private int skor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvpertanyaan = findViewById(R.id.tvpertanyaan);
        radiogrup = findViewById(R.id.radiogrup);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        btquiz = findViewById(R.id.btquiz);

        loadQuestion();

        btquiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int selecttedid = radiogrup.getCheckedRadioButtonId();
                if (selecttedid != -1){
                    int pilihansoal = radiogrup.indexOfChild(findViewById(selecttedid));
                    if (pilihansoal == jawabanbenar[pertanyaansekarang]){
                        skor += 20;
                    }
                    pertanyaansekarang++;
                    if (pertanyaansekarang < pertanyaan.length){
                        loadQuestion();
                    }else {
                        Intent intent = new Intent(QuizActivity.this, skorActivity.class);
                        intent.putExtra("skor", skor);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
    private void loadQuestion(){
        tvpertanyaan.setText(pertanyaan[pertanyaansekarang]);
        radio1.setText(pilihan[pertanyaansekarang][0]);
        radio2.setText(pilihan[pertanyaansekarang][1]);
        radio3.setText(pilihan[pertanyaansekarang][2]);
        radio4.setText(pilihan[pertanyaansekarang][3]);
    }
}