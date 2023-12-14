package com.example.our_graduationproject.Controller;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.R;

import java.util.List;

public class FontAdapter   extends ArrayAdapter<FontSelection>  {
    int num=0;
     ImageView selected ;
    List<FontSelection> imageItems;
    private Context context;
    public FontAdapter(@NonNull Context context, List<FontSelection> courseModelArrayList) {
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
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.cf_item, parent, false);
        }

        FontSelection item = getItem(position);


        selected = listitemView.findViewById(R.id.selected);
        selected.setVisibility(View.INVISIBLE);
        ImageView imageView =listitemView.findViewById(R.id.cell);
        imageView.setImageResource(Integer.parseInt(item.image));


        //  click();


















        return listitemView;

        // like click

    }

}
