package com.example.our_graduationproject.Controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.FullOrder2;
import com.example.our_graduationproject.UI.GET_POST.FileDownloader;
import com.example.our_graduationproject.UI.PDFReader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessagesAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<msgModelclass> messagesAdapterArrayList;
    int ITEM_SEND = 1;
    int ITEM_RECEIVE = 2;

    public MessagesAdpter(Context context, ArrayList<msgModelclass> messagesAdapterArrayList) {
        this.context = context;
        this.messagesAdapterArrayList = messagesAdapterArrayList;
    }
    private String getFileType(String fileName) {
        if (fileName.endsWith(".pdf")) {
            return "pdf";
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
            return "image";
        } else {
            return null; // Unknown file type
        }
    }

    private void displayFileAttachment2( msgModelclass message ,String fileName, ReceiverViewHolder viewHolder) {

        String fileType = getFileType(fileName);
        if (fileType != null) {
            if (fileType.equals("image")) {
                viewHolder.imageView.setVisibility(View.VISIBLE);

                if (message.getFile().exists())
                    Toast.makeText(context, "yes in adapter", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "noooooo in adapter", Toast.LENGTH_SHORT).show();
                Picasso.get().load(message.getFile()).into(viewHolder.imageView);
            } else if (fileType.equals("pdf")) {
                viewHolder.layoutFileAttachment.setVisibility(View.VISIBLE);
                viewHolder.imgFileIcon.setImageResource(getFileIconResource(fileName));
                viewHolder.FileName.setText(fileName);

            } else {
            }
        }
    }

    private void displayFileAttachment( msgModelclass message ,String fileName, SenderViewHolder viewHolder) {

        String fileType = getFileType(fileName);
         if (fileType != null) {
            if (fileType.equals("image")) {
                viewHolder.imageView.setVisibility(View.VISIBLE);

                if(message.getFile().exists())
                    Toast.makeText(context, "yes in adapter", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "noooooo in adapter", Toast.LENGTH_SHORT).show();
                 Picasso.get().load(message.getFile()).into(viewHolder.imageView);
             } else if (fileType.equals("pdf")) {
                viewHolder.layoutFileAttachment.setVisibility(View.VISIBLE);
                viewHolder.imgFileIcon.setImageResource(getFileIconResource(fileName));
                viewHolder.FileName.setText(fileName);

            } else {
             }
        }


    }




    private int getFileIconResource(String fileName) {
         return R.drawable.ic_pdf; // Replace with your implementation
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         if (viewType == ITEM_SEND)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.sender_layout, parent, false);
            return new SenderViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.reciver_layout, parent, false);
            return new ReceiverViewHolder(view);
        }
      //  return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        msgModelclass message = messagesAdapterArrayList.get(position);

//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                new AlertDialog.Builder(context)
//                        .setTitle("Delete")
//                        .setMessage("Are you sure you want to delete this message?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                // Perform deletion here
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.dismiss();
//                            }
//                        })
//                        .show();
//                return false;
//            }
//        });

        if (holder instanceof SenderViewHolder) {
            SenderViewHolder viewHolder = (SenderViewHolder) holder;
            viewHolder.layoutFileAttachment.setVisibility(View.GONE); // Hide file attachment layout

            Picasso.get().load(R.drawable.profil_img).into(viewHolder.circleImageView2);

            if (!message.getUrl().isEmpty()) {
                viewHolder.imageView.setVisibility(View.VISIBLE);
                //viewHolder.progressBar.setVisibility(View.VISIBLE);
                Picasso.get().load(message.getUrl()).into(viewHolder.imageView);
            } else if (!message.getFileName().isEmpty()) {
                viewHolder.FileName.setVisibility(View.VISIBLE);
                //viewHolder.progressBar.setVisibility(View.VISIBLE);
                viewHolder.FileName.setText(message.getFileName());

                displayFileAttachment(message, String.valueOf(viewHolder.FileName.getText()), viewHolder);
                viewHolder.layoutFileAttachment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PDFReader.class);
                        intent.putExtra("message", message);
                        context.startActivity(intent);
                    }
                });
            } else {
                viewHolder.progressBar.setVisibility(View.GONE); // Hide the ProgressBar
                viewHolder.imageView.setVisibility(View.GONE); // Hide the ImageView
            }

            viewHolder.msgtxt.setText(message.getMessage());
        }




        if (holder instanceof ReceiverViewHolder) {
            ReceiverViewHolder viewHolder = (ReceiverViewHolder) holder;
            viewHolder.layoutFileAttachment.setVisibility(View.GONE); // Hide file attachment layout

            Picasso.get().load(R.drawable.profil_img).into(viewHolder.circleImageView2);

            if (!message.getFileName().isEmpty()) {
                viewHolder.FileName.setVisibility(View.VISIBLE);
              //  viewHolder.progressBar.setVisibility(View.VISIBLE);
                viewHolder.FileName.setText(message.getFileName());

                displayFileAttachment2(message, String.valueOf(viewHolder.FileName.getText()), viewHolder);
                viewHolder.layoutFileAttachment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PDFReader.class);
                        intent.putExtra("message", message);
                        context.startActivity(intent);
                    }
                });
            }
            if(!message.getUrlFile().isEmpty())


                 {viewHolder.layoutFileAttachment.setVisibility(View.VISIBLE);

                     FileDownloader.downloadFile(context,message.getUrlFile(), new FileDownloader.DownloadListener()
                    {
                        @Override
                        public void onDownloadComplete(File file) {
                            Toast.makeText(context, "yessss", Toast.LENGTH_SHORT).show();
                            System.out.println("yessss");
                            Uri u=Uri.fromFile(file);
                            new displayFile(context,viewHolder.FileName,viewHolder.imgFileIcon).displayFileAttachment(file, u);

                            //openPdfFile(file);
                        }
                        @Override
                        public void onDownloadError(VolleyError error) {
                            // Error occurred while downloading the file
                            Toast.makeText(context, "Error downloading file: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
              else if(message.getUrlFile().isEmpty()&&message.getFileName().isEmpty())
            {               // viewHolder.progressBar.setVisibility(View.GONE); // Hide the ProgressBar
                viewHolder.imageView.setVisibility(View.GONE); // Hide the ImageView
            }
            viewHolder.msgtxt.setText(message.getMessage());
        }





    }
    @Override
    public int getItemCount() {
        return messagesAdapterArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        msgModelclass message = messagesAdapterArrayList.get(position);
        if (message.getSenderid().equals(SessionManager.getInstance(context).getToken().getToken())) {
            return ITEM_SEND;
        } else {
            return ITEM_RECEIVE;
        }
    }
    class SenderViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView2 ,circleImageView;
        TextView msgtxt;
        ImageView imageView;
        ProgressBar progressBar;
        LinearLayout layoutFileAttachment;
        ImageView imgFileIcon;
        TextView FileName;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView2 =itemView.findViewById(R.id.profiler);
            // circleImageView = itemView.findViewById(R.id.profilerggg);
            msgtxt = itemView.findViewById(R.id.msgsendertyp);
            imageView = itemView.findViewById(R.id.i);
            progressBar = itemView.findViewById(R.id.progressBar);
            FileName = itemView.findViewById(R.id.txtFileName);
            layoutFileAttachment = itemView.findViewById(R.id.layoutFileAttachment);
            imgFileIcon = itemView.findViewById(R.id.imgFileIcon);

        }
    }

    class ReceiverViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView2 ,circleImageView;
        TextView msgtxt;
        ImageView imageView;
        ProgressBar progressBar;
           LinearLayout layoutFileAttachment;
          ImageView imgFileIcon;
          TextView FileName;

        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView2 =itemView.findViewById(R.id.profiler);
            // circleImageView = itemView.findViewById(R.id.profilerggg);
            msgtxt = itemView.findViewById(R.id.msgsendertyp);
            imageView = itemView.findViewById(R.id.i);
            progressBar = itemView.findViewById(R.id.progressBar);
            FileName = itemView.findViewById(R.id.txtFileName);
            layoutFileAttachment = itemView.findViewById(R.id.layoutFileAttachment);
            imgFileIcon = itemView.findViewById(R.id.imgFileIcon);

        }
    }

 }