package com.crenu.library_manager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator codeScanner = new IntentIntegrator(BookActivity.this);
                codeScanner.setBeepEnabled(false);
                codeScanner.setOrientationLocked(false);
                codeScanner.setPrompt("책 바코드를 인식해 주세요.");
                codeScanner.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "취소됨", Toast.LENGTH_LONG).show();
            } else {
                Snackbar.make(findViewById(R.id.BookManage), "책 스캔 완료 : " + result.getContents(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
