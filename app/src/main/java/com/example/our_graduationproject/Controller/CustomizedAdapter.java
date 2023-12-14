package com.example.our_graduationproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomizedAdapter extends ArrayAdapter<DesignType> {
    int num=0;

    ImageView imageView ;
    TextView textView;
    List<DesignType> imageItems;
    private Context context;
    public CustomizedAdapter(@NonNull Context context, List<DesignType> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        imageItems=courseModelArrayList;
        this.context = context;

    }







    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.design_type, parent, false);
        }

        DesignType item = getItem(position);


        imageView = listitemView.findViewById(R.id.image1);

  textView=listitemView.findViewById(R.id.type);

 imageView.setImageResource(item.getImg());
     //   Picasso.get().load(item.getImage()).into(imageView);
textView.setText(item.getType());

















        return listitemView;

        // like click

    }

}
