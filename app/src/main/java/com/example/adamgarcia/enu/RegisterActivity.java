package com.example.adamgarcia.enu;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.adamgarcia.enu.fragments.EtudiantFragment;
import com.example.adamgarcia.enu.fragments.ParentFragment;
import com.example.adamgarcia.enu.fragments.ProfesseurFragment;
import com.example.adamgarcia.enu.model.Parent;

public class RegisterActivity extends AppCompatActivity
        implements EtudiantFragment.OnFragmentInteractionListener,ProfesseurFragment.OnFragmentInteractionListener,ParentFragment.createParent, ParentFragment.OnFragmentInteractionListener{

    FragmentManager fragmentManager;
    RadioButton radioStudent;
    RadioButton radioTeacher;
    RadioButton radioParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_register,ParentFragment.newInstance(this));
        fragmentTransaction.commit();

        radioParent = (RadioButton) findViewById(R.id.radioParent);
        radioStudent= (RadioButton) findViewById(R.id.radioStudent);
        radioTeacher= (RadioButton) findViewById(R.id.radioTeacher);

        radioParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Parent
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_register, ParentFragment.newInstance(RegisterActivity.this));
                fragmentTransaction.commit();
            }
        });


        radioStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_register,EtudiantFragment.newInstance());
                fragmentTransaction.commit();
            }
        });


        radioTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_register, ProfesseurFragment.newInstance());
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void createParentInBase(String name, String firstname, String date, String mail, String password) {
        Parent.createParent(mail,name,firstname,date,0,password);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
