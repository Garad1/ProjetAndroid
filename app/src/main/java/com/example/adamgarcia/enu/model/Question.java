package com.example.adamgarcia.enu.model;

import java.util.HashMap;

/**
 * Created by adamgarcia on 29/05/2017.
 */

public class Question {
    int id;
    String question;
    String[] reponses;
    Boolean[] responseIsTrue;


    private static  int cpt = 1;

    private static HashMap<String, Question> questions;

    static{
        questions = new HashMap<>();
        init();
    }

    public Question (String quest){
        id = cpt;
        cpt++;
        question = quest;
        reponses = new String[4];
        responseIsTrue = new Boolean[4];
    }

    public static void init(){

    }


}
