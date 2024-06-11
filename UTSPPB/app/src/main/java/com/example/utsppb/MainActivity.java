package com.example.utsppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etusername;
    private EditText etpassword;
    private Button btlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        btlogin = findViewById(R.id.btlogin);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                if (username.equals("user")&&password.equals("pass")){
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}