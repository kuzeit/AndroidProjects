package com.example.our_graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import android.Manifest;

public class download1 extends AppCompatActivity {


    public class MainActivity extends AppCompatActivity {

        private static final int PERMISSION_REQUEST_CODE = 1;
        private static final String FILE_URL = "http://example.com/file_url"; // Replace with your file URL

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Check if the READ_EXTERNAL_STORAGE permission is granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted, request it
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSION_REQUEST_CODE);
            } else {
                // Permission is already granted, start the file download
                downloadFile();
            }
        }

        private void downloadFile() {
            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, FILE_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // File download successful
                            // Assuming the response is a FileUri obtained from Volley
                            String fileUri = response;
                            convertFileUriToFile(fileUri);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // File download failed
                            Log.e("Volley", "Error downloading file: " + error.getMessage());
                        }
                    });

            queue.add(stringRequest);
        }

        private void convertFileUriToFile(String fileUri) {
            String filePath = fileUri;

            // Validate if the fileUri is a content URI
            if (fileUri.startsWith("content://")) {
                // Handle content URI using ContentResolver and openInputStream() method
                // Replace the following code with your implementation to handle content URIs
                Log.e("Volley", "Content URI not supported!");
                return;
            }

            // Create a File object from the fileUri
            File file = new File(filePath);

            // Now you have the File object which represents the file corresponding to the FileUri.
            // You can use this File object as needed.
            Log.d("Volley", "File path: " + file.getAbsolutePath());
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                               @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == PERMISSION_REQUEST_CODE) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, start the file download
                    downloadFile();
                } else {
                    // Permission denied
                    Log.e("Volley", "Permission denied!");
                }
            }
        }
    }}