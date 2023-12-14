package com.example.our_graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.our_graduationproject.UI.GET_POST.FileDownloader;

import java.io.File;

//public class Download extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_download);
//        Intent intent = getIntent();
//
//         String fileUrl1 = intent.getStringExtra("file");
//
//        String fileUrloo= "http://192.168.43.116:8000/storage/orders-images/hnZOnq9anuOD3D27eoERK2BYiEGuBugsM3rARDML.pdf";
//        //String url = "http://192.168.43.116:8000/storage/http://192.168.43.116:8000/storage/orders-images/hnZOnq9anuOD3D27eoERK2BYiEGuBugsM3rARDML.pdf";
//        //String prefix = "http://192.168.43.116:8000/storage/";
//
//        //String fileUrlhh = url.replaceFirst("^" + prefix, "");
//        //System.out.println("fileUrl :"+fileUrl);
//        //String fileUrl ="http://192.168.43.116:8000/assets/images/background/beauty.jpg";
//        findViewById(R.id.ff).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FileDownloader.downloadFile(Download.this, fileUrloo, new FileDownloader.DownloadListener() {
//                    @Override
//                    public void onDownloadComplete(File file) {
//                        System.out.println("File downloaded successfully");
//                        Toast.makeText(Download.this, "File downloaded successfully", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onDownloadError(VolleyError error) {
//                        String errorMessage = error.getMessage();
//                        System.out.println("Erorrrr "+errorMessage);
//                        System.out.println("Error downloading file:");
//
//                        Toast.makeText(Download.this, "Error downloading file: " + errorMessage, Toast.LENGTH_SHORT).show();
//                    }        });
//
//            }
//        });
//
//
//    }}
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.io.File;

//public class Download extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_download);
//
//   String fileUrlق= "http://192.168.43.116:8000/storage/orders-images/hnZOnq9anuOD3D27eoERK2BYiEGuBugsM3rARDML.pdf";
//        String fileUrlb = "http://example.com/sample.pdf";
// String fileUrl ="https://www.africau.edu/images/default/sample.pdf";
//
//        findViewById(R.id.ff).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FileDownloader.downloadFile(Download.this, fileUrl, new FileDownloader.DownloadListener() {
//                    @Override
//                    public void onDownloadComplete(File file) {
//                        // File downloaded successfully
//                        Toast.makeText(Download.this, "File downloaded successfully", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onDownloadError(VolleyError error) {
//                        // Error occurred while downloading the file
//                        Toast.makeText(Download.this, "Error downloading file: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//    }
//}
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.android.volley.VolleyError;
import java.io.File;
import android.net.Uri;
import android.content.Intent;

public class Download extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
System.out.println("tokenn : "+MainActivity.token);
        String fileUrl =
    "http://192.168.43.116:8000/storage/orders-images/8AMnhNpq1cqEFxvMib5uqTAqfjbMF8J0Uw2ZSktb.png";

        findViewById(R.id.ff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileDownloader.downloadFile(Download.this, fileUrl, new FileDownloader.DownloadListener() {
                    @Override
                    public void onDownloadComplete(File file) {
                        Toast.makeText(Download.this, "yessss", Toast.LENGTH_SHORT).show();
                       System.out.println("yessss");
                        //openPdfFile(file);
                    }

                    @Override
                    public void onDownloadError(VolleyError error) {
                        // Error occurred while downloading the file
                        Toast.makeText(Download.this, "Error downloading file: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void openPdfFile(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        Intent chooser = Intent.createChooser(intent, "Open PDF");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        } else {
            Toast.makeText(this, "No PDF reader app found on the device", Toast.LENGTH_SHORT).show();
        }
    }
}