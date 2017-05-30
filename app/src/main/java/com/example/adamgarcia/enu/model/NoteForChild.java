package com.example.adamgarcia.enu.model;

/**
 * Created by adamgarcia on 30/05/2017.
 */

public class NoteForChild {
    String name;
    String firstName;
    String exerciceName;
    String note;

    public NoteForChild(String n, String p, String e, int no){
        name = n;
        firstName = p;
        exerciceName = e;
        note = String.valueOf(no);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExerciceName() {
        return exerciceName;
    }

    public void setExerciceName(String exerciceName) {
        this.exerciceName = exerciceName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
