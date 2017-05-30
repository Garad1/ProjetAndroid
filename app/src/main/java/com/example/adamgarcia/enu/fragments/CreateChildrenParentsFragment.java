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
 * {@link CreateChildrenParentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreateChildrenParentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateChildrenParentsFragment extends Fragment {
    Button returnBU;
    Button validationBU;

    public interface communicationWithListChild{
        void addChildForParent(String name, String firstname, String login, String password, String confirm,String date,String classe);
        void returnPreviousFragment();
    }

    public static communicationWithListChild communicationWithListChild;

    private OnFragmentInteractionListener mListener;

    public CreateChildrenParentsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CreateChildrenParentsFragment newInstance(communicationWithListChild com) {
        CreateChildrenParentsFragment fragment = new CreateChildrenParentsFragment();
        communicationWithListChild = com;
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
        final View v = inflater.inflate(R.layout.fragment_create_children_parents, container, false);
        returnBU = (Button) v.findViewById(R.id.BU_fragCreateChild_return);
        validationBU = (Button) v.findViewById(R.id.BU_fragCreateChild_validation);

        returnBU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicationWithListChild.returnPreviousFragment();
            }
        });

        validationBU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                // FAIRE REQUETE DE CREATION

                EditText et_name = (EditText) v.findViewById(R.id.ET_fragCreateChild_name);
                EditText et_firstName = (EditText) v.findViewById(R.id.ET_fragCreateChild_firstname);
                EditText et_login = (EditText) v.findViewById(R.id.ET_fragCreateChild_login);
                EditText et_password = (EditText) v.findViewById(R.id.ET_fragCreateChild_password);
                EditText et_confirm = (EditText) v.findViewById(R.id.ET_fragCreateChild_Confirmpassword);
                EditText et_date = (EditText) v.findViewById(R.id.ET_fragCreateChild_birthday);
                EditText et_class = (EditText) v.findViewById(R.id.ET_fragCreateChild_class);




                String name = et_name.getText().toString();
                String firstname = et_firstName.getText().toString();
                String login = et_login.getText().toString();
                String password = et_password.getText().toString();
                String confirm = et_confirm.getText().toString();
                String date = et_date.getText().toString();
                String classe = et_class.getText().toString();

                communicationWithListChild.addChildForParent(name, firstname, login, password, confirm, date, classe);
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
