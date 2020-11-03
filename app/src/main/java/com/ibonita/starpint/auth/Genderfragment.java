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
import android.widget.RadioButton;

import com.ibonita.starpint.R;
import com.ibonita.starpint.databinding.FragmentBirthdayBinding;
import com.ibonita.starpint.databinding.FragmentGenderfragmentBinding;

public class Genderfragment extends Fragment {
FragmentGenderfragmentBinding binding;
    private String fname;
    private String sname;
    private String date;
    private RadioButton radioSexButton;
    public Genderfragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=   FragmentGenderfragmentBinding.inflate(getLayoutInflater());
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            fname = getArguments().getString("fname");
            sname = getArguments().getString("sname");
            date = getArguments().getString("date");
        }



        binding.btnnextbinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender="";
                    if(binding.radioFemale.isChecked()){
                        gender="female";
                    }else if(binding.radioMale.isChecked()){
                        gender="male";
                    }
                Bundle bundle = new Bundle();
                bundle.putString("date", date);
                bundle.putString("fname", fname);
                bundle.putString("sname", sname);
                bundle.putString("gender", gender);

                Navigation.findNavController(view).navigate(R.id.action_genderfragment_to_phonenofragment,bundle);
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