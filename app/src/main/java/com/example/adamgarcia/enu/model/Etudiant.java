package com.example.adamgarcia.enu.model;

import java.util.HashMap;

/**
 * Created by adamgarcia on 28/05/2017.
 */

public class Etudiant {
    private int id;
    private Parent myParent;
    private String prenom;
    private String nom;
    private int credit;
    private String mailAdress;
    private String password;
    private String birthday;
    private String classe;
    //private HashMap<Exercice, Integer> notes;

    private Cour[] cours;
    private int nbCours;
    private String[] lessons;

    private String [] exercices;
    private int[] notes;
    private int nombreExercices;


    private static  int cpt = 1;

    private static HashMap<String, Etudiant> etudiants;

    static{
        etudiants = new HashMap<>();
    }

    public static Etudiant createEtudiant(Parent p, String name, String firstName, int cred, String adr, String psw, String date, String cl){
        if(etudiants.containsKey(adr)){
            return etudiants.get(adr);
        }

        Etudiant nouvea = new Etudiant(p, name, firstName, cred, adr, psw,date, cl);
        etudiants.put(adr, nouvea);
        return  nouvea;
    }



    public void addResultForExercice(String name, int note){
        exercices[nombreExercices] = name;
        notes[nombreExercices] = note;
        nombreExercices++;
    }

    public Etudiant(Parent p,String name, String firstName, int cred, String adr, String psw, String date, String cl){
        id = cpt;
        cpt++;
        myParent = p;
        prenom = firstName;
        nom = name;
        credit = cred;
        mailAdress = adr;
        password = psw;
        birthday = date;
        classe = cl;
        nombreExercices = 0;
        exercices = new String[100];
        notes = new int [100];
        cours = new Cour[50];
        nbCours = 0;

    }

    public void addCour(Cour c){
        cours[nbCours] = c;
        nbCours++;
    }

    public Parent getMyParent() {
        return myParent;
    }

    public void setMyParent(Parent myParent) {
        this.myParent = myParent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String[] getLessons() {
        return lessons;
    }

    public void setLessons(String[] lessons) {
        this.lessons = lessons;
    }

    public String[] getExercices() {
        return exercices;
    }

    public String getExercice(int i) {
        return exercices[i];
    }

    public int getNote(int i) {
        return notes[i];
    }

    public void setExercices(String[] exercices) {
        this.exercices = exercices;
    }

    public int[] getNotes() {
        return notes;
    }

    public void setNotes(int[] notes) {
        this.notes = notes;
    }

    public int getNombreExercices() {
        return nombreExercices;
    }

    public void setNombreExercices(int nombreExercices) {
        this.nombreExercices = nombreExercices;
    }

    public static HashMap<String, Etudiant> getEtudiants() {
        return etudiants;
    }

    public static void setEtudiants(HashMap<String, Etudiant> etudiants) {
        Etudiant.etudiants = etudiants;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public static int getCpt() {
        return cpt;
    }

    public static void setCpt(int cpt) {
        Etudiant.cpt = cpt;
    }

    public Etudiant(){
        id = cpt;
        cpt++;
        myParent = null;
        prenom = "jef";
        nom = "ramos";
        credit = 0;

        mailAdress = "jef@ramos.fr";
        password = "jeffou";
        birthday = "14/01/1996";
        classe = "Master";

    }
}
