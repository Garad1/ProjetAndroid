package com.example.adamgarcia.enu.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.adamgarcia.enu.R;
import com.example.adamgarcia.enu.adapter.ActivityChildAdapter;
import com.example.adamgarcia.enu.adapter.ChildAdapter;
import com.example.adamgarcia.enu.model.Etudiant;
import com.example.adamgarcia.enu.model.NoteForChild;
import com.example.adamgarcia.enu.model.Parent;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AcceuilParentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AcceuilParentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AcceuilParentFragment extends Fragment {

    private static Parent parent;
    ListView listActivity;

    private OnFragmentInteractionListener mListener;

    public AcceuilParentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AcceuilParentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AcceuilParentFragment newInstance(Parent p) {
        AcceuilParentFragment fragment = new AcceuilParentFragment();
        parent = p;
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
        View v = inflater.inflate(R.layout.fragment_acceuil_parent, container, false);

        ArrayList<NoteForChild> notes = new ArrayList<>();
        int cpt = 0;
        String name;
        String prenom;
        String exo;
        int note;

        for (int i = 0; i < parent.getNombreEnfants(); i++){
            Log.d("Enfants", String.valueOf(i));
            for (int j = 0; j < parent.getMesEnfants()[i].getNombreExercices(); j++){
                Log.d("Exo : ",parent.getMesEnfants()[i].getNom());
                name = parent.getMesEnfants()[i].getNom();
                prenom = parent.getMesEnfants()[i].getPrenom();
                exo = parent.getMesEnfants()[i].getExercice(j);
                note = parent.getMesEnfants()[i].getNote(j);
                notes.add(new NoteForChild(name, prenom, exo, note) );
                cpt++;
            }
        }

        listActivity = (ListView) v.findViewById(R.id.LV_actualityChildren);
        listActivity.setAdapter(new ActivityChildAdapter(getContext(),notes));

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
