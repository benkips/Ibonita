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

import com.ibonita.starpint.R;
import com.ibonita.starpint.databinding.FragmentLoginfragmentBinding;

public class Loginfragment extends Fragment {
    FragmentLoginfragmentBinding binding;


    public Loginfragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=  FragmentLoginfragmentBinding .inflate(getLayoutInflater());
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        //loginbtn when clicked
        binding.btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting Data from input fields
                String phone=binding.uphone.getEditText().getText().toString().trim();
                String pass=binding.upass.getEditText().getText().toString().trim();
                //do logic
            }
        });


        //moving from login to regstration section
        binding.btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_loginfragment_to_namefragment);
            }
        });


        //forgot password
        binding.forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create your own fragment
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
      ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
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