package com.example.appdetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        pdfView = findViewById(R.id.pdfView);

        int pos = getIntent().getIntExtra("position", 0);

        if (pos==0){

            pdfView.fromAsset("prog pdf.pdf").load();
        } else if (pos==1) {

            pdfView.fromAsset("the-pragmatic-programmer.pdf").load();
        }
    }
}