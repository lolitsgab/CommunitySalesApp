package com.example.gabriel.letgo;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Gabriel on 1/8/2018.
 */

public class MasonAdapter extends RecyclerView.Adapter<MasonAdapter.MasonView> {
   Context context;
    //Test Images
   int[] imgList = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
           R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
           R.drawable.i, R.drawable.j};

    public MasonAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public MasonView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mason_tile, parent, false);
        MasonView masonView = new MasonView(layoutView);
        return masonView;
    }

    @Override
    public void onBindViewHolder(MasonView holder, int position) {
        holder.imageView.setImageResource(imgList[position]);
    }

    @Override
    public int getItemCount() {
        return imgList.length;
    }

    public class MasonView extends RecyclerView.ViewHolder {
    ImageView imageView;
        public MasonView(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}
