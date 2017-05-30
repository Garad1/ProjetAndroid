package com.example.adamgarcia.enu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.adamgarcia.enu.R;
import com.example.adamgarcia.enu.model.Etudiant;
import com.example.adamgarcia.enu.model.NoteForChild;

import java.util.ArrayList;

/**
 * Created by adamgarcia on 30/05/2017.
 */

public class ActivityChildAdapter extends BaseAdapter {

    ArrayList<NoteForChild> notes;
    Context context;

    public ActivityChildAdapter(Context context, ArrayList<NoteForChild> notes) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public int getCount() {return notes.size(); }

    @Override
    public NoteForChild getItem(int position) {return notes.get(position);}

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       NoteForChild note = (NoteForChild) getItem(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.row_one_activity_for_a_child, parent, false);

            TextView nom = (TextView) convertView.findViewById(R.id.TV_nameChildForActuality);
            TextView prenom = (TextView) convertView.findViewById(R.id.TV_firstnameChildForActuality);
            TextView content = (TextView) convertView.findViewById(R.id.TV_ExerciceAndNoteChildForActuality);

            nom.setText(note.getName());
            prenom.setText(note.getFirstName());



            String cont = "A fait l'exercice " + note.getExerciceName() + " \n Et a obtenu la note de " + note.getNote();
            content.setText(cont);


        }
        return convertView;


    }




}