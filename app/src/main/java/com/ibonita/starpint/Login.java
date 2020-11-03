package com.ibonita.starpint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.ibonita.starpint.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_login);*/
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.loginfragment,R.id.namefragment,R.id.birthdayFragment,R.id.genderfragment,R.id.phonenofragment,R.id.passwordfragment)
                .build();

        NavController navController  = Navigation.findNavController(Login.this, R.id.nav_host_fragmentx);
        NavigationUI.setupActionBarWithNavController(Login.this, navController,mAppBarConfiguration);


    }
}