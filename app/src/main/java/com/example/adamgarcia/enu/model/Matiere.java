package com.example.adamgarcia.enu.model;

import java.util.HashMap;

/**
 * Created by adamgarcia on 29/05/2017.
 */

public class Matiere {
    int id;
    String name;

    private static int cpt = 0;

    private static Matiere[] matieres;

    static{
        matieres = new Matiere[100];
    }

    public Matiere(String n){
        id = cpt;
        cpt++;
        name = n;
    }


    public static Matiere createMatiere(String name){
        if (getMatiereByName(name) != null){
            return getMatiereByName(name);
        }else{
            Matiere e = new Matiere(name);
            matieres[cpt] = e;
            cpt++;
            return e;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCpt() {
        return cpt;
    }

    public static void setCpt(int cpt) {
        Matiere.cpt = cpt;
    }

    public static Matiere[] getMatieres() {
        return matieres;
    }

    public static void setMatieres(Matiere[] matieres) {
        Matiere.matieres = matieres;
    }

    public static Matiere getMatiereByName (String name){
        for (int i = 0; i < cpt; i++){
            if (matieres[i].getName().equals(name)){
                return matieres[i];
            }
        }
        return null;

    }
}
