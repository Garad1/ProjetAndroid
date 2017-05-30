package com.example.adamgarcia.enu.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.adamgarcia.enu.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddCreditForParentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddCreditForParentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCreditForParentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that mat

    Button addCredit;

    public interface communicationForAddCredit{
        void addCreditParent(int credit);
    }

    static communicationForAddCredit communicationForAddCredit;

    private OnFragmentInteractionListener mListener;

    public AddCreditForParentFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AddCreditForParentFragment newInstance(communicationForAddCredit com) {
        AddCreditForParentFragment fragment = new AddCreditForParentFragment();
        communicationForAddCredit = com;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_add_credit_for_parent, container, false);
        addCredit = (Button) v.findViewById(R.id.BU_addCreditValidation);
        final EditText numberCredit = (EditText) v.findViewById(R.id.ET_numberCreditAdd_parent);



        addCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int creditAdd = Integer.valueOf(numberCredit.getText().toString());
                communicationForAddCredit.addCreditParent(creditAdd);
            }
        });


        return v;
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
