package com.example.adamgarcia.enu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.adamgarcia.enu.R;
import com.example.adamgarcia.enu.model.Etudiant;

import java.util.ArrayList;

/**
 * Created by adamgarcia on 29/05/2017.
 */

public class ChildAdapter extends BaseAdapter{
    ArrayList<Etudiant> etudiants;
    Context context;
    public ChildAdapter(Context context, ArrayList<Etudiant> etudiants){
        this.etudiants = etudiants;
        this.context = context;
    }

    @Override
    public int getCount() {
        return etudiants.size();
    }

    @Override
    public Etudiant getItem(int position) {
        return etudiants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Etudiant etudiant = (Etudiant) getItem(position);

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.row_child_for_parent,parent,false);

            TextView nom = (TextView) convertView.findViewById(R.id.TV_nameChildForParent);
            TextView prenom = (TextView) convertView.findViewById(R.id.TV_prenomChildForParent);
            TextView classe = (TextView) convertView.findViewById(R.id.TV_classChildForParent);

            nom.setText(etudiant.getNom());
            prenom.setText(etudiant.getPrenom());
            classe.setText(etudiant.getClasse());

        }
        return convertView;
    }
}
