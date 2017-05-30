package com.example.adamgarcia.enu.model;

import java.util.HashMap;

/**
 * Created by adamgarcia on 28/05/2017.
 */

public class Professeur {

    private int id;
    private String prenom;
    private String nom;
    private int credit;
    private String mailAdress;
    private String password;
    private String birthday;
    private String matiere;
    private String maxLevel;
    private String note;
    private String validationDoc;
    private boolean validation;

    private static  int cpt = 1;

    private static HashMap<String, Professeur> professeurs;

    static{
        professeurs = new HashMap<>();
    }


    public Professeur(String name, String firstName, int cred, String adr, String psw, String date, Matiere m){
        id = cpt;
        cpt++;
        prenom = firstName;
        nom = name;
        credit = cred;
        mailAdress = adr;
        password = psw;
        birthday = date;


    }








}
