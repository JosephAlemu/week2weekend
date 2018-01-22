package com.example.user.week2weekendproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfviewerActivity extends AppCompatActivity {
    PDFView pdfViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        pdfViewer=(PDFView) findViewById(R.id.pdfviewer);
        pdfViewer.fromAsset("android_programming_cookbook.pdf").load();
    }
}


