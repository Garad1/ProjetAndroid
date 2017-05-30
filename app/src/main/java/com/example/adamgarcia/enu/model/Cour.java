package com.example.adamgarcia.enu.model;

import java.util.HashMap;

/**
 * Created by adamgarcia on 29/05/2017.
 */

public class Cour {
    int id;
    String name;
    String classe;
    Exercice[] exercices;
    int nombreExo;
    String matiere;

    private static int cpt = 0;

    private static Cour[] cours;

    static{
        cours = new Cour[100];
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Exercice[] getExercices() {
        return exercices;
    }

    public void setExercices(Exercice[] exercices) {
        this.exercices = exercices;
    }

    public int getNombreExo() {
        return nombreExo;
    }

    public void setNombreExo(int nombreExo) {
        this.nombreExo = nombreExo;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public static int getCpt() {
        return cpt;
    }

    public static void setCpt(int cpt) {
        Cour.cpt = cpt;
    }






    public Cour (String n, String m, String c){
        id = cpt;
        name = n;
        classe = c;
        exercices = new Exercice[10];
        matiere = m;
        nombreExo = 0;
    }

    public static Cour createCour(String n, String m, String c ){
        if(getCourByName(n) != null){
            return getCourByName(n);
        }else{
            Cour nouvea = new Cour(n, m, c);
            cours[cpt] = nouvea;
            cpt++;
            return  nouvea;
        }
    }

    public void addExo(Exercice e){
        exercices[nombreExo] = e;
        nombreExo++;
    }

    public static Cour getCour(int i){
        if (cours[i] != null){
            return cours[i];
        }else{
            return null;
        }

    }

    public static Cour getCourByName(String n){
        for (int i = 0; i < cpt; i++){
            if (cours[i].getName().equals(n)){
                return cours[i];
            }
        }
        return null;
    }

}
