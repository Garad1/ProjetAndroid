package com.example.adamgarcia.enu.model;

import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by adamgarcia on 28/05/2017.
 */

public class Parent {

    private int id;
    private Etudiant[] mesEnfants;
    int nombreEnfants;
    private String nom;
    private String prenom;
    private int credit;
    private String mailAdress;
    private String password;
    private String birthday;

    private static  int cpt = 1;

    private static HashMap<String, Parent> parents;

    static{
        parents = new HashMap<>();
        init();
    }

    public Parent(){
        id = cpt;
        cpt++;
        nom ="fati";
        prenom = "papa";
        nombreEnfants = 1;
        mesEnfants = new Etudiant[5];
        credit = 14;
        mailAdress = "adresseMail@parent.fr";
        password = "ABC";
        birthday = "12/12/1980";
    }

    public static void deleteAccout (String mail){
        parents.remove(getParent(mail));
    }

    public Parent(String n, String p, int c, String m, String psw, String b){
        id = cpt;
        cpt++;

        nom = n;
        prenom = p;
        nombreEnfants = 0;
        mesEnfants = new Etudiant[5];
        credit = c;
        mailAdress = m;
        password = psw;
        birthday = b;
    }

    public static void addParent(Parent parent){
        parents.put(parent.getMailAdress(), parent);
    }

    public static Parent createParent(String adr, String name, String firstname, String date, int cred, String psw){
        if(parents.containsKey(adr)){
            return parents.get(adr);
        }

        Parent nouvea = new Parent(name, firstname, cred, adr, psw, date);
        parents.put(adr, nouvea);
        return  nouvea;
    }

    public static Parent getParent(String mailAddress){
        if(parents.containsKey(mailAddress)){
            return parents.get(mailAddress);
        }
        return null;
    }

    public static void init(){
        createParent("fati@chen.fr", "Chen", "Fati", "16/10/1994",404,"passw");
        createParent("adam@garcia.fr", "Garcia", "Adam", "11/05/1995",308,"test");
        createParent("antho@carmona.fr", "Carmona", "Anthony", "16/10/1994",302,"passw");
        createParent("a", "Carmona", "Anthony", "16/10/1994",302,"a");
        Etudiant e = getParent("fati@chen.fr").addChild("garcia", "adam", 3, "adam.garcia@etu.fr", "abc", "12/01/2013", "Master");
        Exercice exo = Exercice.createExercice("QCM CORBA très difficile");
        Exercice exo4 = Exercice.createExercice("Question SOAP importante");
        Exercice exo2 = Exercice.createExercice("Annale de programmation mobile");
        Exercice exo3 = Exercice.createExercice("Questions sur réseau et système");
        Cour.createCour("CORBA", "Programmation n", "Master").addExo(exo);
        Cour.createCour("SOAP", "Programmation n", "Master").addExo(exo4);
        Cour.createCour("General android", "Android", "Master").addExo(exo2);
        Cour.createCour("General reseau", "Systeme", "Master").addExo(exo3);
        e.addResultForExercice("QCM CORBA très difficile", 12);
        e.addResultForExercice("Annale de programmation mobile", 19);
        e.addResultForExercice("Questions sur réseau et système", 14);
        getParent("fati@chen.fr").addChild("georges", "sens", 13, "georges@sens.fr", "abc", "12/01/2011", "CP");
        getParent("fati@chen.fr").addChild("pierre", "paul", 21, "pierre@paul.fr", "popo", "31/01/2010", "CE1");

    }

    public Etudiant addChild (String name, String firstName, int cred, String adr, String psw, String date, String cl){
        Etudiant e;
        if (nombreEnfants<5){
            e = Etudiant.createEtudiant(this, name, firstName,cred,adr,psw,date,cl);
            mesEnfants[nombreEnfants] = e;
        }else{
            e = null;
        }
        nombreEnfants++;
        return e;
    }

    public Etudiant[] getAllEnfants (){
        Etudiant[] es = new Etudiant[nombreEnfants];
        for (int i = 0; i < nombreEnfants; i++){
            es[i] = mesEnfants[i];
        }
        return es;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etudiant[] getMesEnfants() {
        return mesEnfants;
    }

    public void setMesEnfants(Etudiant[] mesEnfants) {
        this.mesEnfants = mesEnfants;
    }

    public int getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(int nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
