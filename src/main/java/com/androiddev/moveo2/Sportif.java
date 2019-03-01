package com.androiddev.moveo2;

public class Sportif {
    private String nom;
    private String prenom;
    private String sexe;
    private int age;
    private String sport;
    private String note;
    private String ville;

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return sport;
    }

    public String getNote() {
        return note;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
