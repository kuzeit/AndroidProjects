package com.example.our_graduationproject.UI;


import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.MessagesAdpter;
import com.example.our_graduationproject.Controller.msgModelclass;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.GET_POST.Chat;
import com.example.our_graduationproject.UI.GET_POST.GetChat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class chatwindo extends AppCompatActivity {
    String reciverimg, reciverUid,reciverName,SenderUID;
     private ImageView imageView;
     CircleImageView profile;
    TextView reciverNName;
     public  static String senderImg;
    public  static String reciverIImg;
    ImageView sendbtn;
    EditText textmsg;

    String senderRoom,reciverRoom;
    RecyclerView messageAdpter;
    ArrayList<msgModelclass> messagesArrayList;
    MessagesAdpter mmessagesAdpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatwindo);
        getSupportActionBar().hide();
//        database = FirebaseDatabase.getInstance();
//        firebaseAuth = FirebaseAuth.getInstance();
        senderImg=reciverIImg=String.valueOf(R.drawable.profil_img);
        reciverName = IDD.name;
        reciverimg = String.valueOf(R.drawable.ic_profile);
        reciverUid = "kcfF2othNvRWYRueoF6BhKnVWpZ2";

        messagesArrayList = new ArrayList<>();
        imageView = findViewById(R.id.s);
        sendbtn = findViewById(R.id.sendbtnn);
        textmsg = findViewById(R.id.textmsg);
        reciverNName = findViewById(R.id.recivername);
        profile = findViewById(R.id.profileimgg);
        messageAdpter = findViewById(R.id.msgadpter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        messageAdpter.setLayoutManager(linearLayoutManager);
        mmessagesAdpter = new MessagesAdpter(chatwindo.this,messagesArrayList);
        messageAdpter.setAdapter(mmessagesAdpter);


        //Picasso.get().load(R.drawable.i).into(profile);
        reciverNName.setText(""+reciverName);

       // SenderUID =  "PcZHhRTjKLhr5RLK4CKusZMPBKC2";
        SenderUID = SessionManager.getInstance(chatwindo.this).getToken().getToken();
        senderRoom = SenderUID+reciverUid;
        reciverRoom = reciverUid+SenderUID;



        msgModelclass messages = new msgModelclass("hello","8",7777);
        messagesArrayList.add(messages);
        msgModelclass messages2 = new msgModelclass("","8",7777);
        messages2.setUrlFile("https://www.africau.edu/images/default/sample.pdf");
        messagesArrayList.add(messages2);
        messages = new msgModelclass("how are you ","8",7777);
        messagesArrayList.add(messages);
        GetChat.getData(chatwindo.this,mmessagesAdpter,messagesArrayList,1);
        mmessagesAdpter.notifyDataSetChanged();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker();

            }
        });
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textmsg.getText().toString();
                if (message.isEmpty()) {
                    Toast.makeText(chatwindo.this, "Enter The Message First", Toast.LENGTH_SHORT).show();
                    return;
                }
                textmsg.setText("");

                // Create a new msgModelclass object for the user's message
                Date date = new Date();

                msgModelclass userMessage = new msgModelclass(message, SenderUID, date.getTime());

                // Add the user's message to the messagesArrayList
                messagesArrayList.add(userMessage);
                mmessagesAdpter.notifyDataSetChanged();

                // Optionally, you can scroll to the bottom of the message list
                messageAdpter.scrollToPosition(messagesArrayList.size() - 1);
                ///////Chat.getData(chatwindo.this,message,1);
            }
        });








    }
    private static final int FILE_REQUEST_CODE = 1;

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Accept all file types
        startActivityForResult(intent, FILE_REQUEST_CODE);
    }

     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

 //
        File file = null;
        String filePath = null;
        Uri fileUri  =null ;

        if (requestCode == FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                  fileUri = data.getData();
                  file = null;

                if (fileUri != null) {
                     if (ContentResolver.SCHEME_CONTENT.equals(fileUri.getScheme())) {
                        ContentResolver contentResolver = getContentResolver();
                          filePath = null;

                        try (InputStream inputStream = contentResolver.openInputStream(fileUri)) {
                            if (inputStream != null) {
                                // Create a temporary file using a unique name
                                File tempFile = File.createTempFile("temp", null, getCacheDir());
                                // Copy the content of the input stream to the temporary file
                                copyInputStreamToFile(inputStream, tempFile);
                                // Set the temporary file as the final file
                                file = tempFile;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (ContentResolver.SCHEME_FILE.equals(fileUri.getScheme())) {
                        // If the URI scheme is "file", directly create a file object
                        file = new File(fileUri.getPath());
                    }
                }

                if (file != null && file.exists()) {
                    // Set the file in your message object
                    Toast.makeText(chatwindo.this, "  exist", Toast.LENGTH_SHORT).show();
                    // Continue processing the message or perform any required actions
                    // ...
                } else {
                    Toast.makeText(chatwindo.this, "File does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        }





                textmsg.setText("");
String message="";
                // Create a new msgModelclass object for the user's message
                Date date = new Date();

                msgModelclass userMessage = new msgModelclass(message, SenderUID, date.getTime());
        userMessage.setFile(file);

        if(userMessage.getFile().exists())
            Toast.makeText(this, "ghghghghghghghghghghghghghg", Toast.LENGTH_LONG).show();
                userMessage.setFileName(getFileName(fileUri));
                // Add the user's message to the messagesArrayList
                messagesArrayList.add(userMessage);

                mmessagesAdpter.notifyDataSetChanged();


                ///displayFileAttachment(fileUri);
            }


    private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }




    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
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






}