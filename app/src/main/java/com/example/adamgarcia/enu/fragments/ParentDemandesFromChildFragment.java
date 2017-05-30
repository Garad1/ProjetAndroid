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

import com.example.adamgarcia.enu.AcceuilParentActivity;
import com.example.adamgarcia.enu.LoginActivity;
import com.example.adamgarcia.enu.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParentDemandesFromChildFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ParentDemandesFromChildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParentDemandesFromChildFragment extends Fragment {


    Button acceuil;

    static View view;
    private OnFragmentInteractionListener mListener;

    public interface returnAcceuilFromDemandes{
         void returnAcceuilFromDemandes();
    }


    static returnAcceuilFromDemandes returnAcceuilFromDemandes;
    public ParentDemandesFromChildFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ParentDemandesFromChildFragment newInstance(returnAcceuilFromDemandes ret) {
        ParentDemandesFromChildFragment fragment = new ParentDemandesFromChildFragment();
        returnAcceuilFromDemandes = ret;
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
        view = inflater.inflate(R.layout.fragment_parent_demandes_from_child, container, false);
        acceuil = (Button) view.findViewById(R.id.BU_acceuilFromDemandes);

        acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnAcceuilFromDemandes.returnAcceuilFromDemandes();;
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
