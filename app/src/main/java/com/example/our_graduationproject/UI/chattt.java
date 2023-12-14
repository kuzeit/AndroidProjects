//package com.example.our_graduationproject.UI;
//
//package com.example.our_graduationproject.UI;
//
//import android.content.Intent;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.PopupMenu;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.our_graduationproject.Controller.messagesAdpter;
//import com.example.our_graduationproject.Controller.msgModelclass;
//import com.example.our_graduationproject.R;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//public class chatwindo extends AppCompatActivity {
//    String reciverimg, reciverUid,reciverName,SenderUID;
//    private static final int REQUEST_PICK_IMAGE = 1;
//    private static final int REQUEST_PICK_DOCUMENT = 2;
//
//    private ImageView imageView;
//    private ImageView imageView2;
//
//    private ProgressBar progressBar;
//
//    CircleImageView profile;
//    TextView reciverNName;
//    //FirebaseDatabase database;
//    //FirebaseAuth firebaseAuth;
//    public  static String senderImg;
//    public  static String reciverIImg;
//    ImageView sendbtn;
//    EditText textmsg;
//
//    String senderRoom,reciverRoom;
//    RecyclerView messageAdpter;
//    ArrayList<msgModelclass> messagesArrayList;
//    messagesAdpter mmessagesAdpter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chatwindo);
//        getSupportActionBar().hide();
////        database = FirebaseDatabase.getInstance();
////        firebaseAuth = FirebaseAuth.getInstance();
//        senderImg=reciverIImg=String.valueOf(R.drawable.profil_img);
//        reciverName = "amani";
//        reciverimg = String.valueOf(R.drawable.ic_profile);
//        reciverUid = "kcfF2othNvRWYRueoF6BhKnVWpZ2";
//
//        messagesArrayList = new ArrayList<>();
//        imageView = findViewById(R.id.s);
//        sendbtn = findViewById(R.id.sendbtnn);
//        textmsg = findViewById(R.id.textmsg);
//        reciverNName = findViewById(R.id.recivername);
//        profile = findViewById(R.id.profileimgg);
//        messageAdpter = findViewById(R.id.msgadpter);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setStackFromEnd(true);
//        messageAdpter.setLayoutManager(linearLayoutManager);
//        mmessagesAdpter = new messagesAdpter(chatwindo.this,messagesArrayList);
//        messageAdpter.setAdapter(mmessagesAdpter);
//
//
//        //Picasso.get().load(R.drawable.i).into(profile);
//        reciverNName.setText(""+reciverName);
//
//        SenderUID =  "PcZHhRTjKLhr5RLK4CKusZMPBKC2";
//
//        senderRoom = SenderUID+reciverUid;
//        reciverRoom = reciverUid+SenderUID;
//
//
//
//
//        msgModelclass messages = new msgModelclass("hello","8",7777);
//        messagesArrayList.add(messages);
//        messages = new msgModelclass("how are you ","8",7777);
//        messagesArrayList.add(messages);
//
//        mmessagesAdpter.notifyDataSetChanged();
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPopupMenu();
//
//            }
//        });
//        sendbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String message = textmsg.getText().toString();
//                if (message.isEmpty()) {
//                    Toast.makeText(chatwindo.this, "Enter The Message First", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                textmsg.setText("");
//
//                // Create a new msgModelclass object for the user's message
//                Date date = new Date();
//
//                msgModelclass userMessage = new msgModelclass(message, SenderUID, date.getTime());
//
//                // Add the user's message to the messagesArrayList
//                messagesArrayList.add(userMessage);
//                mmessagesAdpter.notifyDataSetChanged();
//
//                // Optionally, you can scroll to the bottom of the message list
//                messageAdpter.scrollToPosition(messagesArrayList.size() - 1);
//            }
//        });
//
//
//
//
//
//
//
//
//    }
//
//
//
//
//    private void showPopupMenu() {
//        PopupMenu popupMenu = new PopupMenu(this, imageView);
//        popupMenu.getMenuInflater().inflate(R.menu.menu_image_document, popupMenu.getMenu());
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.menu_choose_image:
//                        openImagePicker();
//                        return true;
//                    case R.id.menu_choose_document:
//                        openDocumentPicker();
//                        return true;
//                    default:
//                        return false;
//                }
//            }
//        });
//        popupMenu.show();
//    }
//
//    private void openImagePicker() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent, REQUEST_PICK_IMAGE);
//    }
//
//    private void openDocumentPicker() {
//        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        intent.setType("*/*");
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        startActivityForResult(intent, REQUEST_PICK_DOCUMENT);
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK) {
//            if (requestCode == REQUEST_PICK_IMAGE) {
//                if (data != null) {
//                    Uri imageUri = data.getData();
//                    // Handle the selected image
//                    Toast.makeText(this, "Image selected: " + imageUri.toString(), Toast.LENGTH_SHORT).show();
//
//                    Date date = new Date();
//
//                    msgModelclass userMessage = new msgModelclass();
//                    userMessage.setUrl(imageUri.toString());
//                    userMessage.setSenderid(SenderUID);
//                    userMessage.setDate(String.valueOf(date));
//
//                    // Add the user's message to the messagesArrayList
//                    messagesArrayList.add(userMessage);
//                    mmessagesAdpter.notifyDataSetChanged();
//
//
//
//                    //uploadPhoto();
//                }
//            } else if (requestCode == REQUEST_PICK_DOCUMENT) {
//                if (data != null) {
//                    Uri documentUri = data.getData();
//                    // Handle the selected document
//                    Toast.makeText(this, "Document selected: " + documentUri.toString(), Toast.LENGTH_SHORT).show();
//                    Date date = new Date();
//
//                    msgModelclass userMessage = new msgModelclass();
//                    userMessage.setFileName("hghjghjgh");
//                    userMessage.setSenderid(SenderUID);
//                    userMessage.setDate(String.valueOf(date));
//
//                    // Add the user's message to the messagesArrayList
//                    messagesArrayList.add(userMessage);
//                    mmessagesAdpter.notifyDataSetChanged();
//                }
//            }
//        }
//    }
//
//    private void showProgressBar() {
//        // progressBar.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressBar() {
//        // progressBar.setVisibility(View.GONE);
//    }
//
//    private void uploadPhoto() {
//        // Simulating the upload process with a delay
//        showProgressBar();
//        imageView.setVisibility(View.INVISIBLE);
//
//        // Simulate the photo upload process
//        // Replace this with your actual upload logic
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000); // Simulate a 3-second delay
//
//                    // Update the UI on the main thread
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            hideProgressBar();
//
//
//                            Toast.makeText(chatwindo.this, "Photo uploaded", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        Uri fileUri;
////        super.onActivityResult(requestCode, resultCode, data);
////        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
////            fileUri = data.getData();
////            String fileName = getFileName(fileUri);
////
////            // Set the file name in the TextView
////           // fileTextView.setText(fileName);
////        }
////    }
//
//    private String getFileName(Uri uri) {
//        String result = null;
//        if (uri.getScheme().equals("content")) {
//            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//            try {
//                if (cursor != null && cursor.moveToFirst()) {
//                    result = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME));
//                }
//            } finally {
//                if (cursor != null) {
//                    cursor.close();
//                }
//            }
//        }
//        if (result == null) {
//            result = uri.getPath();
//            int cut = result.lastIndexOf('/');
//            if (cut != -1) {
//                result = result.substring(cut + 1);
//            }
//        }
//        return result;
//    }
//
//
//
//
//
//
//}