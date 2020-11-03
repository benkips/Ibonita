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
import com.ibonita.starpint.databinding.FragmentNamefragmentBinding;


public class Namefragment extends Fragment {
   FragmentNamefragmentBinding binding;
    public Namefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=   FragmentNamefragmentBinding  .inflate(getLayoutInflater());
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        binding.btnnxtname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting firstname
                String fname=binding.fname.getEditText().getText().toString().trim();
                String sname=binding.sname.getEditText().getText().toString().trim();

                Bundle bundle = new Bundle();
                bundle.putString("fname", fname);
                bundle.putString("sname",sname);
                Navigation.findNavController(view).navigate(R.id.action_namefragment_to_birthdayFragment,bundle);
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
        ActionBar supportActionBar= ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.show();
    }
}