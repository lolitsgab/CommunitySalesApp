package com.example.gabriel.letgo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gabriel on 1/8/2018.
 */

public class MasonView extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public MasonView(View itemView)
    {
        super(itemView);
        imageView = itemView.findViewById(R.id.img);
    }
}
