package com.example.our_graduationproject.UI.ArtBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.ChooseDesigner;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Display extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ImageView imageView =  findViewById(R.id.imageView2);
//        //Bitmap bitmap = getIntent().getParcelableExtra("drawing");
//        byte[] byteArray = getIntent().getByteArrayExtra("drawing");
//        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//        imageView.setImageBitmap(bitmap);




        String encodedImage = getIntent().getStringExtra("image_url");
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        File file = new File(getCacheDir(), "image.jpg");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            decodedByte.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

         Picasso.get().load(file).into(imageView);
        findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String filename = "my_image.jpg";
                File file = new File(getApplicationContext().getFilesDir(), filename);
                Order.setArtBoard(file);

//                File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "/MyApp/");
//                directory.mkdirs();

               // File file = new File(directory, filename);
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    decodedByte.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                    System.out.println("Image saved to " + file.getAbsolutePath());
                    Toast.makeText(Display.this, "Image saved to " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(Display.this, "Error saving image", Toast.LENGTH_SHORT).show();
                }
                 startActivity(new Intent(Display.this, ChooseDesigner.class));

            }
        });


    }

//    private void saveFile2() {
//        String fileName = "my_image.jpg";
//        String fileContents = "Hello, World!";
//
//        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        if (!downloadsDir.exists()) {
//            if (!downloadsDir.mkdirs()) {
//                // Failed to create the directory, handle it accordingly
//                Toast.makeText(this, "Failed to create the directory", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        }
//
//        File file = new File(downloadsDir, fileName);
//
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(fileContents.getBytes());
//            fos.close();
//            String savedFilePath = file.getAbsolutePath();
//            System.out.println("File saved successfully: " + savedFilePath);
//            Toast.makeText(this, "File saved successfully: " + savedFilePath, Toast.LENGTH_SHORT).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Failed to save file", Toast.LENGTH_SHORT).show();
//        }
//    }

}