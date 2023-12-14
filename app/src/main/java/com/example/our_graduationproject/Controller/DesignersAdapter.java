package com.example.our_graduationproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;

import java.util.ArrayList;

public class DesignersAdapter extends RecyclerView.Adapter<DesignersAdapter.ViewHolder>
        {
private ItemClickListener mClickListener;

        Context context;
         ArrayList<Designer> arrayList = new ArrayList<>();

public DesignersAdapter(Context context, ArrayList<Designer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        }



            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(context).inflate(R.layout.designer_card, parent, false);
                return new ViewHolder(view);
            }

            @Override
public   void   onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Designer designer=arrayList.get(position);

        holder.name.setText(designer.getName());
        holder.profileImage.setImageResource(Integer.parseInt(designer.getProfile()));

                holder.description.setText(designer.getDescription());
                if (designer.isSelected())
                holder.selected.setVisibility(View.VISIBLE);
               else
                    holder.selected.setVisibility(View.INVISIBLE);

              //  LayerDrawable stars=(LayerDrawable)holder.rt.getProgressDrawable();

                //Use for changing the color of RatingBar
               // stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
//                holder.rt.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
////                    @Override
////                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
////                        // Handle the rating change here
////                        designer.setRating(Double.valueOf(rating));
////                    }
//                });

// holder.selected1.setOnClickListener(new View.OnClickListener() {
//     @Override
//     public void onClick(View v) {
//        if (designer.isSelected()) {
//            designer.setSelected(false);
//            holder.selected.setVisibility(View.INVISIBLE);
//            Order.setSelectedDesigner(null);
//        }         else {
//             designer.setSelected(true);
//             holder.selected.setVisibility(View.VISIBLE);
//              Order.setSelectedDesigner(designer);
//              notifyDataSetChanged();
//
//         }
//
//     }
// });

                //finding the specific RatingBar with its unique ID

        }

@Override
public int getItemCount() {
        return arrayList.size();
        }


            int oldPosition =-1;

public class ViewHolder extends RecyclerView.ViewHolder   implements View.OnClickListener
{
    TextView name;
    TextView description;
    ImageView profileImage;
    ImageView selected;
    LinearLayout selected1;

     public ViewHolder(View itemView) {
        super(itemView);
       // rt = (RatingBar) itemView.findViewById(R.id.ratingBar);
        name = itemView.findViewById(R.id.name);
        description = itemView.findViewById(R.id.description);
        profileImage=itemView.findViewById(R.id.designer_profile);
        selected=itemView.findViewById(R.id.cheak);
        selected1=itemView.findViewById(R.id.cheak1);

         itemView.setOnClickListener(this);
    }
    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//        selected.setVisibility(View.VISIBLE);
 if(!arrayList.get(getAdapterPosition()).isSelected()) {
      Order.setSelectedDesigner(arrayList.get(getAdapterPosition()));
     if (oldPosition > -1 && arrayList.get(oldPosition).isSelected())
         arrayList.get(oldPosition).setSelected(false);
     int o = getAdapterPosition();
     arrayList.get(o).setSelected(true);
     oldPosition = getAdapterPosition();
 }else {
     arrayList.get(getAdapterPosition()).setSelected(false);
     Order.setSelectedDesigner(null);
 }
        notifyDataSetChanged();
     }
}


    public void setClickListener(DesignersAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


public interface ItemClickListener {
    void onItemClick(View view, int position);
}
}


