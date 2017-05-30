package com.example.adamgarcia.enu.model;

import java.util.HashMap;

/**
 * Created by adamgarcia on 29/05/2017.
 */

public class Exercice {
    int id;
    String exerciceTitle;
    Question[] questions;
    int nbQuestion;

    private static Exercice[] exercices;
    private static  int cpt = 0;

    public Exercice(String name){
        id = cpt;
        exerciceTitle = name;
        questions = new Question[10];
    }


    public static Exercice createExercice(String name){
        if (getExerciceByName(name) != null){
            return getExerciceByName(name);
        }else{
            Exercice e = new Exercice(name);
            exercices[cpt] = e;
            cpt++;
            return e;
        }


    }

    public void addQuestion (Question q){
        if(nbQuestion<4){
            questions[nbQuestion] = q;
            nbQuestion++;
        }
    }




    static{
        exercices = new Exercice[100];
        init();
    }


    private static Exercice[] getAllExercice(){
        Exercice[] e = new Exercice[cpt];
        for (int i = 0; i < cpt; i++){
            e[i] = exercices[i];
        }
        return e;
    }

    public static Exercice getExerciceByName(String name){
        for (int i = 0; i < cpt; i++){
            if (name.equals(exercices[i])){
                return exercices[i];
            }
        }
        return null;
    }

    public static void init (){
        createExercice("QCM CORBA très difficile");
        createExercice("Annale de programmation mobile");
        createExercice("Questions sur réseau et système");
    }

}
