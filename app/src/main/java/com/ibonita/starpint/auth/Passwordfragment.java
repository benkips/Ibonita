package com.ibonita.starpint.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ibonita.starpint.R;
import com.ibonita.starpint.databinding.FragmentPasswordfragmentBinding;
import com.ibonita.starpint.databinding.FragmentPhonenofragmentBinding;

public class Passwordfragment extends Fragment {

FragmentPasswordfragmentBinding binding;
    private String fname;
    private String sname;
    private String date;
    private String gender;
    private String phone;
    public Passwordfragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=  FragmentPasswordfragmentBinding .inflate(getLayoutInflater());
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //tobe sent to server
        if (getArguments() != null) {
            fname = getArguments().getString("fname");
            sname = getArguments().getString("sname");
            date = getArguments().getString("date");
            gender = getArguments().getString("gender");
            phone = getArguments().getString("phone");
        }

        Toast.makeText(getContext(), date, Toast.LENGTH_SHORT).show();

        //send all above data toserver
        binding.btnnextbinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do logic
                //send toserver

                //call this after logic to move to login screen
                Navigation.findNavController(view).navigate(R.id.action_passwordfragment_to_loginfragment);

            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
    @Override
    public void onResume() {
        super.onResume();
        androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.show();
    }
}