package com.example.adamgarcia.enu.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.adamgarcia.enu.LoginActivity;
import com.example.adamgarcia.enu.R;
import com.example.adamgarcia.enu.RegisterActivity;
import com.example.adamgarcia.enu.model.Parent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParentMyAccountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ParentMyAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParentMyAccountFragment extends Fragment {


    static Parent parent;
    TextView name;
    TextView firstname;
    TextView mail;
    TextView date;
    TextView numberChild;

    static View view;

    Button deleteAccount;


    public interface deleteAccountParent{
        void deleteAccout(String mail);
    }

    static deleteAccountParent deleteAccountParent;

    private OnFragmentInteractionListener mListener;

    public ParentMyAccountFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static ParentMyAccountFragment newInstance(deleteAccountParent del, Parent p) {
        ParentMyAccountFragment fragment = new ParentMyAccountFragment();
        parent = p;
        deleteAccountParent = del;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_parent_my_account, container, false);
        name = (TextView) view.findViewById(R.id.TV_firstnameMyAccountParent);
        firstname = (TextView) view.findViewById(R.id.TV_nomMyAccountParent);
        mail = (TextView) view.findViewById(R.id.TV_mailAdressMyAccountParent);
        date = (TextView) view.findViewById(R.id.TV_birthdayMyAccountParent);
        numberChild = (TextView) view.findViewById(R.id.TV_numberChildMyAccountParent);
        deleteAccount = (Button) view.findViewById(R.id.BU_desinscriptionMyAccountParent);

        name.setText(parent.getNom());
        firstname.setText(parent.getPrenom());
        mail.setText(parent.getMailAdress());
        date.setText(parent.getBirthday());
        numberChild.setText(String.valueOf(parent.getNombreEnfants()));

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Parent
                deleteAccountParent.deleteAccout(parent.getMailAdress());
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


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
