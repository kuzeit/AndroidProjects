package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.our_graduationproject.Controller.ColorsOrdersAdapter;
import com.example.our_graduationproject.Controller.FontSelection;
import com.example.our_graduationproject.Controller.displayFile;
import com.example.our_graduationproject.Download;
import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.Scope1;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.Details.Form;
import com.example.our_graduationproject.UI.GET_POST.FileDownloader;
import com.example.our_graduationproject.UI.GET_POST.OnScopeReceivedListner;
import com.example.our_graduationproject.UI.GET_POST.OnValueReceivedListner;
import com.example.our_graduationproject.UI.GET_POST.Rating;
import com.example.our_graduationproject.UI.GET_POST.SendOrder;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FullOrder2 extends AppCompatActivity
{

    String[] colorss,  fontss;
    ;
    LinearLayout layoutFileAttachmentdesigner;
    LinearLayout artboard;
    LinearLayout fileCustomer;

    ImageView imgFileIcon ,imgFileIconCustomer,imgFileIconArtboard;
    TextView FileName ,FileNameC,FileNameA;
    Order_ Order1 ;
    RatingBar rt;

     TextView industry ,idea,type,description,price , designer,title,fonts ,colors,statues;
    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_order);
        FileName =  findViewById(R.id.txtFileName2);
        FileNameA =  findViewById(R.id.txtFileName1);
        FileNameC=  findViewById(R.id.txtFileName);
        rt = (RatingBar) findViewById(R.id.ratingBar);
         layoutFileAttachmentdesigner =  findViewById(R.id.fil_designer);
        artboard =  findViewById(R.id.artboard);
        fileCustomer =  findViewById(R.id.layoutFileAttachment);

        imgFileIcon =  findViewById(R.id.imgFileIcon2);
        imgFileIconArtboard =  findViewById(R.id.imgFileIcon1);
        imgFileIconCustomer =  findViewById(R.id.imgFileIcon);

        if(getIntent().getExtras() != null) {
              Order1 = (Order_) getIntent().getSerializableExtra("file");        }


















        statues=findViewById(R.id.statues);

        industry=findViewById(R.id.industry);
        idea=findViewById(R.id.idea);
        type=findViewById(R.id.type);
        description=findViewById(R.id.description);
        price=findViewById(R.id.price);
        designer=findViewById(R.id.designer);
        title=findViewById(R.id.title);
        fonts=findViewById(R.id.fonts);
        colors=findViewById(R.id.colors);
        if(Order1.getSelectedColors()!=null)
        colorss =new String[Order1.getSelectedColors().size()];

//        if(Order1.getFontSelections()!=null)
//        fontss =new String[Order1.getFontSelections().size()];;

//        if(Order1.getFontSelections().size()>0)
//        {String fontsString = "fonts : ";
//            int i=0;
//            for(FontSelection fontSelection :Order1.getFontSelections())
//            {
//                fontss[i]=fontSelection.getFont();
//                fontsString=fontsString.concat(fontSelection.getFont());
//                if(i!=Order1.getFontSelections().size()-1)
//                    fontsString=fontsString.concat(", ");
//                else          fontsString=fontsString.concat(" ");
//
//                i++; }
        LayerDrawable stars=(LayerDrawable)rt.getProgressDrawable();

        //Use for changing the color of RatingBar
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
       rt.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(FullOrder2.this, "rating"+rating, Toast.LENGTH_SHORT).show();
                Rating.getData(FullOrder2.this,rating,Order1.getId());
            }
        });
//////////////////////////////////////////////////////////////////////////////////////
//        if(Order1.getFontss()!=null &&Order1.getFontss().length>0)
//        {String fontsString = "fonts : ";
//             for(int i=0 ;i<Order1.getFontss().length;i++)
//            {
//                 fontsString=fontsString.concat(Order1.getFontss()[i]);
//                if(i!=Order1.getFontss().length-1)
//                    fontsString=fontsString.concat(", ");
//                else          fontsString=fontsString.concat(" ");
//
//                i++; }
/////////////////////////////////////////////////////////////////////




//
//            fonts.setText(fontsString);
//            Order1.setFontss(fontss);
//        }else fonts.setVisibility(View.GONE);
        fonts.setText("fonts : poppins_black1,poppins_black1");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<ColorSelection> data = Order1.getSelectedColors();
        ColorsOrdersAdapter adapter = new ColorsOrdersAdapter(FullOrder2.this,data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        if(Order1.getColorss().length>0)
        {//for(int i=0;i<1;i++)
             {

            ColorSelection colorSelection = new ColorSelection(1,  R.color.red);

            data.add(colorSelection)  ;
                 }
            Order1.setColorss(colorss);
        adapter.notifyDataSetChanged();}else {
            colors.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
        }
        if(!Order1.getDescreption().isEmpty()&&!Order1.getDescreption().equals("null"))
            description.setText("description :"+Order1.getDescreption());
        else description.setVisibility(View.GONE);
        if(!Order1.getStaues().isEmpty()&&!Order1.getStaues().equals("null")) {
            statues.setVisibility(View.VISIBLE);

            statues.setText("statue :" + Order1.getStaues());
        }
        if(!Order1.getIndustry().isEmpty()&&!Order1.getIndustry().equals("null"))
            industry.setText("industry : "+Order1.getIndustry());
        else industry.setVisibility(View.GONE);

        if(Order1.getPrice()!=0)
            price.setText("price : "+Order1.getPrice());
        else price.setVisibility(View.GONE);
        if(!Order1.getSelectedDesigner().getName().isEmpty())
            designer.setText("designer : "+Order1.getSelectedDesigner().getName());
        else designer.setVisibility(View.GONE);
        if(!Order1.getIdea().isEmpty())
            idea.setText("idea : "+Order1.getIdea());
        else idea.setVisibility(View.GONE);
String t="";
        if(!Order1.getType().isEmpty()&&!Order1.getType().equals(null)) {
            t = "type " + Order1.getType();
            if (!Order1.getPreferebce().isEmpty()   &&!Order1.getPreferebce().equals("null")) {
                t = t + " - " + Order1.getPreferebce();
            }                type.setText(t);
        }        else type.setVisibility(View.GONE);

        if (Order1.getTitle().equals(null) && !Order1.getTitle().isEmpty()) {
            title.setText("title: " + Order1.getTitle());
        } else {
            title.setVisibility(View.GONE);
        }

         System.out.println(" fileeee1 :"+ Order1.getStringFile());
if(!Order1.getStringFile().equals("null"))
{
    FileDownloader.downloadFile(FullOrder2.this, Order1.getStringFile(), new FileDownloader.DownloadListener()
    {
        @Override
        public void onDownloadComplete(File file) {
            Toast.makeText(FullOrder2.this, "yessss", Toast.LENGTH_SHORT).show();
            System.out.println("yessss");
            Uri u=Uri.fromFile(file);
            new displayFile(FullOrder2.this,FileName,imgFileIcon).displayFileAttachment(file, u);

            //openPdfFile(file);
        }
        @Override
        public void onDownloadError(VolleyError error) {
            // Error occurred while downloading the file
            Toast.makeText(FullOrder2.this, "Error downloading file: " + error.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });






}else
        layoutFileAttachmentdesigner.setVisibility(View.GONE);
   if(!Order1.getImageArtboard().equals("null"))
        {
            FileDownloader.downloadFile(FullOrder2.this, Order1.getImageArtboard(), new FileDownloader.DownloadListener()
            {
                @Override
                public void onDownloadComplete(File file) {
                    Toast.makeText(FullOrder2.this, "yessss", Toast.LENGTH_SHORT).show();
                    System.out.println("yessss");
                    Uri u=Uri.fromFile(file);
                    new displayFile(FullOrder2.this,FileNameA,imgFileIconArtboard).displayFileAttachment(file, u);

                    //openPdfFile(file);
                }
                @Override
                public void onDownloadError(VolleyError error) {
                    // Error occurred while downloading the file
                    Toast.makeText(FullOrder2.this, "Error downloading file: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }else
            artboard.setVisibility(View.GONE);
        System.out.println("customerrrr : "+Order1.getFileCustomer());
        if(!Order1.getFileCustomer().equals("null"))
        {
            FileDownloader.downloadFile(FullOrder2.this, Order1.getFileCustomer(), new FileDownloader.DownloadListener()
            {
                @Override
                public void onDownloadComplete(File file) {
                    Toast.makeText(FullOrder2.this, "yessss", Toast.LENGTH_SHORT).show();
                    System.out.println("yessss");
                    Uri u=Uri.fromFile(file);
                    new displayFile(FullOrder2.this,FileNameC,imgFileIconCustomer).displayFileAttachment(file, u);

                    //openPdfFile(file);
                }
                @Override
                public void onDownloadError(VolleyError error) {
                    // Error occurred while downloading the file
                    Toast.makeText(FullOrder2.this, "Error downloading file: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });






        }else
            fileCustomer.setVisibility(View.GONE);


















        findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveOrder();
            }
        }); }

    private void saveOrder() {
        Order_ order_ = new Order_(Order.getOrder());
        Order.orderS.add(order_);
        SendOrder.sendTypeDesign(order_,this);
    }

    public   Uri convertFileToUri(Context context, File file) {
        return FileProvider.getUriForFile(
                context,
                context.getApplicationContext().getPackageName() + ".provider",
                file
        );
    }






}