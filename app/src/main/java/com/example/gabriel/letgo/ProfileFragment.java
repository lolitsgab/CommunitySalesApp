package com.example.gabriel.letgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Gabriel on 1/5/2018.
 */

public class ProfileFragment extends Fragment{

    //Button signOutBTN;
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //signOutBTN = getView().findViewById(R.id.signoutBTN);
        //signOutBTN.setOnClickListener(this);
        //Button captureImage = rootView.findViewById(R.id.uploadGoodsButton);

        final View rootView = inflater.inflate(R.layout.profile_view, container, false);
        mAuth = FirebaseAuth.getInstance();

        Button signOutBTN = rootView.findViewById(R.id.signoutBTN);

        signOutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Signing out ...", Toast.LENGTH_SHORT).show();
                signOut();
                Intent test = new Intent(getContext(), Login.class);
                startActivity(test);
            }
        });

        return rootView;
    }
    private void signOut(){
        mAuth.signOut();

    }
}
