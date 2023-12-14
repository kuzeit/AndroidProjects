package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
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
import com.example.our_graduationproject.UI.GET_POST.FileDownloader;
import com.example.our_graduationproject.UI.GET_POST.OnScopeReceivedListner;
import com.example.our_graduationproject.UI.GET_POST.OnValueReceivedListner;
import com.example.our_graduationproject.UI.GET_POST.SendOrder;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FullOrder extends AppCompatActivity
{
    String[] colorss,  fontss;

    LinearLayout layoutFileAttachmentdesigner;
    LinearLayout artboard;
    LinearLayout fileCustomer;

    ImageView imgFileIcon ,imgFileIconCustomer,imgFileIconArtboard;
    TextView FileName ,FileNameC,FileNameA;





    TextView industry ,idea,type,description,price , designer,title,fonts ,colors,statues;
    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_order);
        FileName =  findViewById(R.id.txtFileName2);
        FileNameA =  findViewById(R.id.txtFileName1);
        FileNameC=  findViewById(R.id.txtFileName);

        layoutFileAttachmentdesigner =  findViewById(R.id.fil_designer);
        artboard =  findViewById(R.id.artboard);
        fileCustomer =  findViewById(R.id.layoutFileAttachment);

        imgFileIcon =  findViewById(R.id.imgFileIcon2);
        imgFileIconArtboard =  findViewById(R.id.imgFileIcon1);
        imgFileIconCustomer =  findViewById(R.id.imgFileIcon);
//        if(getIntent().getExtras() != null) {
//            Order1 = (Order_) getIntent().getSerializableExtra("file");        }



















        industry=findViewById(R.id.industry);
        idea=findViewById(R.id.idea);
        type=findViewById(R.id.type);
        description=findViewById(R.id.description);
        price=findViewById(R.id.price);
        designer=findViewById(R.id.designer);
        title=findViewById(R.id.title);
        fonts=findViewById(R.id.fonts);
        colors=findViewById(R.id.colors);
        statues=findViewById(R.id.statues);

        if(Order.getSelectedColors()!=null)
            colorss =new String[Order.getSelectedColors().size()];
        if(Order.getFontSelections()!=null)
            fontss =new String[Order.getFontSelections().size()];;
        RatingBar rt = (RatingBar) findViewById(R.id.ratingBar);
        rt.setVisibility(View.GONE);

        if(Order.getFontSelections().size()>0)
        {String fontsString = "fonts : ";
            int i=0;
            for(FontSelection fontSelection :Order.getFontSelections())
            {
                fontss[i]=fontSelection.getFont();
                fontsString=fontsString.concat(fontSelection.getFont());
                if(i!=Order.getFontSelections().size()-1)
                    fontsString=fontsString.concat(", ");
                else          fontsString=fontsString.concat(" ");

                i++; }
            fonts.setText(fontsString);
            Order.setFontss(fontss);
        }else fonts.setVisibility(View.GONE);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<ColorSelection> data = Order.getSelectedColors();
        ColorsOrdersAdapter adapter = new ColorsOrdersAdapter(FullOrder.this,data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        if(Order.getSelectedColors().size()>0)
        {
            int i=0;
            for(ColorSelection colorSelection :Order.getSelectedColors())
            {
                colorss[i]= String.valueOf(colorSelection.getColor());

                i++; }

            Order.setColorss(colorss); }else {
            colors.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
        }
        if(!Order.getDescreption().isEmpty()&&!Order.getDescreption().equals("null"))
            description.setText("description :"+Order.getDescreption());
        else description.setVisibility(View.GONE);

        if(!Order.getIndustry().isEmpty()&&!Order.getIndustry().equals("null"))
            industry.setText("industry : "+Order.getIndustry());
        else industry.setVisibility(View.GONE);

        if(Order.getPrice()!=0)
            price.setText("price : "+Order.getPrice());
        else price.setVisibility(View.GONE);
        if(!Order.getSelectedDesigner().getName().isEmpty()&&!Order.getName().equals(null))
            designer.setText("designer : "+Order.getSelectedDesigner().getName());
        else designer.setVisibility(View.GONE);
        if(!Order.getIdea().isEmpty()&&!Order.getIdea().equals("null"))
            idea.setText("idea : "+Order.getIdea());
        else idea.setVisibility(View.GONE);
        String t="";
        if(!Order.getType().isEmpty()&&!Order.getType().equals("null")) {
            t = "type " + Order.getName();
            if (!Order.getPreferebce().isEmpty() && !Order.getPreferebce().equals(null)) {
                t = t + "  :  " + Order.getPreferebce();
            }                type.setText(t);
        }        else type.setVisibility(View.GONE);

        if (Order.getTitle().equals(null) && !Order.getTitle().isEmpty()) {
            title.setText("title: " + Order.getTitle());
        } else {
            title.setVisibility(View.GONE);
        }

        //System.out.println(" fileeee1 :"+ Order.get());


            layoutFileAttachmentdesigner.setVisibility(View.GONE);
        if(Order.getArtBoard()!=null)
        {
                     new displayFile(FullOrder.this,FileNameA,imgFileIconArtboard).displayFileAttachment(Order.getArtBoard(), Uri.fromFile(Order.getArtBoard()));

                    //openPdfFile(file);

        }else
            artboard.setVisibility(View.GONE);
        if(Order.getFile()!=null)
        {
            Toast.makeText(this, "yessss---", Toast.LENGTH_SHORT).show();
            new displayFile(FullOrder.this,FileNameC,imgFileIconCustomer).displayFileAttachment(Order.getFile(),  Order.order.getUrl());

            //openPdfFile(file);

        }else {
            Toast.makeText(this, "nooooo ---", Toast.LENGTH_SHORT).show();

            fileCustomer.setVisibility(View.GONE);
        }






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
        startActivity(new Intent(FullOrder.this,Order1.class));
    }

    public   Uri convertFileToUri(Context context, File file) {
        return FileProvider.getUriForFile(
                context,
                context.getApplicationContext().getPackageName() + ".provider",
                file
        );
    }






}