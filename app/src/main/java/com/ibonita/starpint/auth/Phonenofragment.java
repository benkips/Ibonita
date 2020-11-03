package com.ibonita.starpint.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibonita.starpint.R;
import com.ibonita.starpint.databinding.FragmentGenderfragmentBinding;
import com.ibonita.starpint.databinding.FragmentPhonenofragmentBinding;

public class Phonenofragment extends Fragment {
    FragmentPhonenofragmentBinding binding;
    private String fname;
    private String sname;
    private String date;
    private String gender;
    public Phonenofragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=  FragmentPhonenofragmentBinding.inflate(getLayoutInflater());
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            fname = getArguments().getString("fname");
            sname = getArguments().getString("sname");
            date = getArguments().getString("date");
            gender = getArguments().getString("gender");
        }


        binding.btnnextbinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting mobile number
                //Getting Data from input fields
                String phone=binding.uphone.getEditText().getText().toString().trim();

                if(isValidphone(phone)){
                    Bundle bundle = new Bundle();
                    bundle.putString("date", date);
                    bundle.putString("fname", fname);
                    bundle.putString("sname", sname);
                    bundle.putString("gender", gender);
                    bundle.putString("phone", phone);
                    Navigation.findNavController(view).navigate(R.id.action_phonenofragment_to_passwordfragment,bundle);
                }else{
                    binding.uphone.getEditText().setError("invalid phone  number");
                }


            }
        });
    }

    private boolean isValidphone(String target) {
        return Patterns.PHONE.matcher(target).matches();
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