package com.crenu.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Button button1 = (Button) findViewById(R.id.button3) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator codeScanner = new IntentIntegrator(MainActivity.this);
                codeScanner.setBeepEnabled(false);
                codeScanner.setOrientationLocked(false);
                codeScanner.setPrompt("책 바코드를 인식해 주세요.");
                codeScanner.initiateScan();
            }
        });

        Button button2 = (Button) findViewById(R.id.button4) ;
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), BookActivity .class));
            }
        });










    }


}
