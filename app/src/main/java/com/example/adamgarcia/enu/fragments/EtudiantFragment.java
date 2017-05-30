package com.example.adamgarcia.enu.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
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
 * {@link EtudiantFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EtudiantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EtudiantFragment extends Fragment {

    EditText birthday;
    Button returnConnect;



    private OnFragmentInteractionListener mListener;

    public EtudiantFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EtudiantFragment newInstance() {
        EtudiantFragment fragment = new EtudiantFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_etudiant, container, false);

        returnConnect = (Button) view.findViewById(R.id.BU_etu_goConnect);

        returnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Parent
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        birthday = (EditText) view.findViewById(R.id.ET_etu_birthday);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
