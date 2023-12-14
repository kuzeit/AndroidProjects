package com.example.our_graduationproject.Controller;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.our_graduationproject.R;
import com.squareup.picasso.Picasso;

import java.io.File;

public class displayFile {
    Context context = null;
    TextView FileName;
    ImageView imgFileIcon;

    public displayFile(Context context, TextView fileName, ImageView imgFileIcon) {
        this.context = context;
        FileName = fileName;
        this.imgFileIcon = imgFileIcon;
    }

    public String getFileType(String fileName) {
        if (fileName.endsWith(".pdf")) {
            return "pdf";
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
            return "image";
        } else {
            return null; // Unknown file type
        }
    }
    private int getFileIconResource(String fileName) {
        return R.drawable.ic_pdf; // Replace with your implementation
    }
    private String getFileName(Uri uri) {

        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    public void displayFileAttachment(File file, Uri uri ) {
        String  fileName =getFileName(uri);
        Toast.makeText(context, fileName, Toast.LENGTH_SHORT).show();
        String fileType = getFileType(fileName);
        if (fileType != null) {
            FileName.setText(fileName);

            if (fileType.equals("image")) {

                Picasso.get().load(file).into(imgFileIcon);
            } else if (fileType.equals("pdf")) {
                imgFileIcon.setImageResource(getFileIconResource(fileName));

            } else {
            }
        }


    }
}
