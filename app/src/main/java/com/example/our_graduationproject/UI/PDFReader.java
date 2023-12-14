package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.our_graduationproject.Controller.msgModelclass;
import com.example.our_graduationproject.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PDFReader extends AppCompatActivity {
PDFView pdfView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfreader);
        pdfView=findViewById(R.id.pdfView);
//        Intent intent = getIntent();
//        msgModelclass message = (msgModelclass) intent.getSerializableExtra("message");
//        pdfView.fromFile(message.getFile()).load();

             // Find the PDFView by ID
            pdfView = findViewById(R.id.pdfView);

            // Retrieve the msgModelclass object from the Intent
            Intent intent = getIntent();
            msgModelclass message = (msgModelclass) intent.getSerializableExtra("message");

            if (message != null) {
                // Load the PDF file using the File object from message
                File pdfFile = message.getFile();
                if (pdfFile != null && pdfFile.exists()) {
                    pdfView.fromFile(pdfFile).load();
                } else {
                    // Handle the case where the PDF file is not available
                }
            } else {
                // Handle the case where the message object is null
            }
        }
    }
