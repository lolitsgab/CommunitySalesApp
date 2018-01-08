package com.example.gabriel.letgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class GoodsGalleryFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.gallery_view, container, false);
        gridViewAdapter adapter = new gridViewAdapter(getActivity());
        GridView gView = rootView.findViewById(R.id.gridView);
        ImageButton captureImage = rootView.findViewById(R.id.uploadGoodsButton);
       // if(gridView != null)
            gView.setAdapter(adapter);


        //---------------------------  Listener for Grid Items  --------------------------------------------//
        gView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent focusedView = new Intent(getContext(), FocusOnGoodActivity.class);
                startActivity(focusedView);
                Toast.makeText(getContext(), "Pressed On An Image", Toast.LENGTH_SHORT).show();
            }
        });
        //---------------------------  Listener for Grid Items  --------------------------------------------//

        //---------------------------  Listener for Camera Button  --------------------------------------------//
        captureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "On press, launch new camera activity and pass to AI", Toast.LENGTH_SHORT).show();
            }
        });
        //---------------------------  Listener for Camera Button  --------------------------------------------//


        return rootView;
    }
}
