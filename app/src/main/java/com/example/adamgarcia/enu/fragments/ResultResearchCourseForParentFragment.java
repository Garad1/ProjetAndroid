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
import com.example.adamgarcia.enu.adapter.CourseAdapter;
import com.example.adamgarcia.enu.model.Cour;
import com.example.adamgarcia.enu.model.NoteForChild;
import com.example.adamgarcia.enu.model.Parent;

import java.util.ArrayList;

import static com.example.adamgarcia.enu.R.id.container;
import static com.example.adamgarcia.enu.R.id.masked;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultResearchCourseForParentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultResearchCourseForParentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultResearchCourseForParentFragment extends Fragment {


    static Context context;
    ListView listCourse;

    static String matiere;
    static String classe;


    private OnFragmentInteractionListener mListener;

    public ResultResearchCourseForParentFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ResultResearchCourseForParentFragment newInstance(Context co) {
        //matiere = m;
        //classe = c;
        ResultResearchCourseForParentFragment fragment = new ResultResearchCourseForParentFragment();
        context = co;
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
        View v = inflater.inflate(R.layout.fragment_result_research_course_for_parent, container, false);

        ArrayList<Cour> cours = new ArrayList<>();
        int cpt = 0;


        for (int i = 0; i < Cour.getCpt(); i++){
            cours.add(Cour.getCour(i));
        }




        listCourse = (ListView) v.findViewById(R.id.LV_allCourseForResearch);
        listCourse.setAdapter(new CourseAdapter(v.getContext(),cours));

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
