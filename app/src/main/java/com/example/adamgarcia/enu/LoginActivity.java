package com.example.adamgarcia.enu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.adamgarcia.enu.fragments.ParentFragment;
import com.example.adamgarcia.enu.model.Parent;

import static android.support.v7.app.AlertDialog.*;

public class LoginActivity extends AppCompatActivity {

    Button createAccount;
    Button connect;
    EditText login;
    EditText password;
    RadioButton student;
    RadioButton teacher;
    RadioButton parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createAccount = (Button) findViewById(R.id.BU_createAccount);
        login = (EditText) findViewById(R.id.ET_login);
        password = (EditText) findViewById(R.id.ET_password);
        connect = (Button) findViewById(R.id.BU_connect);
        student = (RadioButton) findViewById(R.id.radioStudent);
        teacher = (RadioButton) findViewById(R.id.radioTeacher);
        parent = (RadioButton) findViewById(R.id.radioParent);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Parent
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Parent

                //TODO VERIFICATION LOGIN PASSWORD
                Intent intent = new Intent();
                if (student.isChecked()){

                }
                if (teacher.isChecked()){

                }

                //Parent.init();
                // ce que tu veux

                if (parent.isChecked()){
                    EditText et = (EditText) findViewById(R.id.ET_login);
                    EditText et2 = (EditText) findViewById(R.id.ET_password);
                    String mail = et.getText().toString();
                    String psw = et2.getText().toString();
                    if(Parent.getParent(mail) != null){
                        if (Parent.getParent(mail).getPassword().equals(psw)){
                            intent = new Intent(getApplicationContext(), AcceuilParentActivity.class);
                            intent.putExtra("mail",mail);
                            startActivity(intent);
                        }else{
                            Builder builder;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                builder = new Builder(LoginActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                            } else {
                                builder = new Builder(LoginActivity.this);
                            }
                            builder.setTitle("Mauvaise saisie")
                                    .setMessage("Mauvais mot de passe")
                                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            // continue with delete
                                        }
                                    })
                                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            // do nothing
                                        }
                                    })
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .show();
                        }
                    }else{
                        Builder builder;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            builder = new Builder(LoginActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                        } else {
                            builder = new Builder(LoginActivity.this);
                        }
                        builder.setTitle("Mauvaise saisie")
                                .setMessage("Adresse email incorrecte")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // continue with delete
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // do nothing
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }

                }
                //intent = new Intent(getApplicationContext(), AcceuilParentActivity.class);



            }
        });

    }
}
