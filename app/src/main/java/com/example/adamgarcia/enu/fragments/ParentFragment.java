package com.example.adamgarcia.enu.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.adamgarcia.enu.LoginActivity;
import com.example.adamgarcia.enu.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ParentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParentFragment extends Fragment {

    EditText birthday;
    Button returnConnect;
    Button validation;
    EditText nom;
    EditText prenom;
    EditText date;
    EditText mail;
    EditText password;
    EditText validationPassword;

    public interface createParent{
        void createParentInBase(String name, String firstname, String date, String mail, String password);
    }

    static createParent createParent;


    private OnFragmentInteractionListener mListener;

    public ParentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ParentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParentFragment newInstance(createParent c) {
        ParentFragment fragment = new ParentFragment();
        createParent = c;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_parent, container, false);

        returnConnect = (Button) view.findViewById(R.id.BU_parent_goConnect);
        validation = (Button) view.findViewById(R.id.BU_parent_validation);
        nom = (EditText) view.findViewById(R.id.ET_parent_name);
        prenom = (EditText) view.findViewById(R.id.ET_parent_firstname);
        date = (EditText) view.findViewById(R.id.ET_parent_birthday);
        mail = (EditText) view.findViewById(R.id.ET_parent_login);
        password = (EditText) view.findViewById(R.id.ET_parent_password);
        validationPassword = (EditText) view.findViewById(R.id.ET_parent_Confirmpassword);


        returnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Parent
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Parent
                if (!nom.getText().toString().isEmpty() && !prenom.getText().toString().isEmpty() && !date.getText().toString().isEmpty() &&
                        !mail.getText().toString().isEmpty() && !password.getText().toString().isEmpty() &&
                        password.getText().toString().equals(validationPassword.getText().toString())){

                    createParent.createParentInBase(nom.getText().toString(), prenom.getText().toString(), date.getText().toString(), mail.getText().toString(), password.getText().toString());
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else{
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(getActivity());
                    }
                            builder.setTitle("Saisie incorrecte")
                            .setMessage("Vérifier la saisie")
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
        });


        birthday = (EditText) view.findViewById(R.id.ET_parent_birthday);
        birthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                final Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
                        birthday.setText(selectedmonth+"/"+selectedday+"/"+selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();}
        });
        // Inflate the layout for this fragment
        return view;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
