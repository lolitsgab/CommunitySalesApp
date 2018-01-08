package com.example.gabriel.letgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class GoodsGalleryFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gallery_view, container, false);
        gridViewAdapter adapter = new gridViewAdapter(getActivity());
        GridView gView = rootView.findViewById(R.id.gridView);
       // if(gridView != null)
            gView.setAdapter(adapter);
        return rootView;
    }
}
