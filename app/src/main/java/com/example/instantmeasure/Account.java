package com.example.instantmeasure;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {

    String disp_email;

    public void get_cred(String em)
    {
        disp_email=em;
    }

    public Account() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       disp_email= ActivityLogin.firebaseAuth.getCurrentUser().getEmail();

        ViewGroup grp =(ViewGroup) inflater.inflate(R.layout.fragment_account,null);

        TextView email = grp.findViewById(R.id.tv_email);

        email.setText("Email : "+disp_email);

        return grp;


        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_account, container, false);
    }

}
