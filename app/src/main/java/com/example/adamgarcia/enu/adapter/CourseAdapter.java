package com.example.adamgarcia.enu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.adamgarcia.enu.R;
import com.example.adamgarcia.enu.model.Cour;
import com.example.adamgarcia.enu.model.Etudiant;
import com.example.adamgarcia.enu.model.NoteForChild;

import java.util.ArrayList;

/**
 * Created by adamgarcia on 30/05/2017.
 */

public class CourseAdapter extends BaseAdapter {
    ArrayList<Cour> cours;
    Context context;
    public CourseAdapter(Context context, ArrayList<Cour> cour){
        this.cours = cour;
        this.context = context;
    }

    @Override
    public int getCount() {return cours.size(); }

    @Override
    public Object getItem(int position) {
        return cours.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cour cour = (Cour) getItem(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.row_for_course_description, parent, false);

            TextView nameMatiere = (TextView) convertView.findViewById(R.id.TV_ListCourseNameMatiere);
            TextView levelMatiere = (TextView) convertView.findViewById(R.id.TV_ListCourseLevel);
            TextView nomCour = (TextView) convertView.findViewById(R.id.TV_ListCourseNameCourse);

            nameMatiere.setText(cour.getMatiere());
            levelMatiere.setText(cour.getClasse());
            nomCour.setText(cour.getName());


        }
        return convertView;
    }
}
