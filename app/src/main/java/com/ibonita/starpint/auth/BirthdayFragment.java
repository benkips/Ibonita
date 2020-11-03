package com.ibonita.starpint.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibonita.starpint.R;
import com.ibonita.starpint.databinding.FragmentBirthdayBinding;
import com.ibonita.starpint.databinding.FragmentNamefragmentBinding;


public class BirthdayFragment extends Fragment {
    FragmentBirthdayBinding binding;
    private String fname;
    private String sname;


    public BirthdayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=    FragmentBirthdayBinding.inflate(getLayoutInflater());
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getting names
        if (getArguments() != null) {
            fname = getArguments().getString("fname");
            sname = getArguments().getString("sname");
        }

        // initiate a date picker
        int day =  binding.datePicker1.getDayOfMonth(); // get the selected day
        int month =  binding.datePicker1.getMonth(); // get the selected month
        int year =  binding.datePicker1.getYear(); // get the selected year
        //combing date
        String date=String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);


        binding.btnnxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("date", date);
                bundle.putString("fname", fname);
                bundle.putString("sname", sname);
                Navigation.findNavController(view).navigate(R.id.action_birthdayFragment_to_genderfragment,bundle);
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
        androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.show();
    }
}