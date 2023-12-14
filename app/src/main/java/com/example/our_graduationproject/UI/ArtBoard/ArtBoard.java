package com.example.our_graduationproject.UI.ArtBoard;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.ChooseDesigner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import petrov.kristiyan.colorpicker.ColorPicker;


public class ArtBoard extends AppCompatActivity {

    DrawingView drawingView;
    SeekBar seekBar;
    EditText editText ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art_boardd);
editText = findViewById(R.id.editText);
        drawingView = findViewById(R.id.canvas);
        drawingView.setOnTouchListener(new TouchListener());
        seekBar = findViewById(R.id.seekBar);
        drawingView.setEditText(editText);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                drawingView.setCurrentColor(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


             Bitmap bitmap = Bitmap.createBitmap(drawingView.getWidth(), drawingView.getHeight(), Bitmap.Config.ARGB_8888);

             Canvas canvas = new Canvas(bitmap);
            drawingView.draw(canvas);

             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);

            Intent intent = new Intent(ArtBoard.this, Display.class);
            intent.putExtra("image_url", encodedImage);

            if (!drawingView.getPaths().isEmpty()) {
                Toast.makeText(ArtBoard.this, "yes", Toast.LENGTH_SHORT).show();
//                File file = new File(getExternalFilesDir(null), "image.png");
//                try {
//                    FileOutputStream outputStream = new FileOutputStream(file);
//                    outputStream.write(byteArray);
//                    outputStream.flush();
//                    outputStream.close();
//                    // File saved successfully
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    // Error saving file
//                }



            }else
                Toast.makeText(ArtBoard.this, "noo", Toast.LENGTH_SHORT).show();

            startActivity(intent);


            }
            });


   }

    public void delete(View view )
    {
        drawingView.setCurrentColor(Color.WHITE);
        drawingView.setCurrentWidth(seekBar.getProgress() * 4);// Set the color of the eraser to white

    }






    public void drawing(View view )
{drawingView.setCurrentWidth(seekBar.getProgress());

    ColorPicker colorPicker = new ColorPicker(ArtBoard.this);
    colorPicker.setDefaultColorButton(R.color.white);

    colorPicker.show();
    colorPicker.setDefaultColorButton(R.color.white);
    colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
        @Override
        public void onChooseColor(int position,int color) {
setColor(view,color);        }

        @Override
        public void onCancel(){
            // put code
        }
    });
}
    public void deleteDrawing(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to erase everything?")
                .setTitle("Delete Drawing")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        drawingView.erase();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    public void setColor(View view , int color) {
         drawingView.setCurrentColor(color);
        if (view.getTag() != null && view.getTag().equals("eraser")) {
            drawingView.setCurrentWidth(seekBar.getProgress() * 4);
        } else {
            drawingView.setCurrentWidth(seekBar.getProgress());
        }
    }
}
