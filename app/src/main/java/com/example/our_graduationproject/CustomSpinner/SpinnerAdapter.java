package com.example.our_graduationproject.CustomSpinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.our_graduationproject.R;

import java.util.List;

public class SpinnerAdapter   extends BaseAdapter {
    private Context context;
    private List<String> string;

    public SpinnerAdapter(Context context, List<String> string) {
        this.context = context;
        this.string = string;
    }

    @Override
    public int getCount() {
        return string != null ? string.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_spinner, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.name);

        txtName.setText(string.get(i).toString());

        return rootView;
    }

}
