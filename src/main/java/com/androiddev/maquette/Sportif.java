package com.androiddev.maquette;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class    Sportif implements Serializable {
    private String nom;
    private String prenom;
    private String sexe;
    private int age;
    private ArrayList<String> sport;
    private float note;
    private String ville;
    private String niveau;
    private float distance;
    private int image;
    private String description;

    public Sportif(String prenom,int age,ArrayList<String> sport,float note,String sexe,String ville,String nom,String niveau, float distance,int image,String description)   {
        this.nom=nom;
        this.prenom=prenom;
        this.sexe=sexe;
        this.age=age;
        this.sport=sport;
        this.note=note;
        this.ville=ville;
        this.niveau=niveau;
        this.distance=distance;
        this.image=image;
        this.description=description;
    }

    public static ArrayList initialisation()
    {
        String description1="Je fais du sport pour le plaisir et je cherche des gens avec qui partager ce plaisir, je ne cherche pas du tout la compétition, au contraire ! Vous pouvez retrouver les différents sports que je pratique plus bas :)";
        String description2="Alors moi mon truc c'est le sport entre copains, des bons moments autour d'une pétanque avec une bière ou un ricard, y'a pas mieux pour la santé !";
        ArrayList listesSportif = new ArrayList();
        Sportif mael = new Sportif("Maël",18,new ArrayList<String>() {{ add("Skate");add("Basket-Ball");}},4.2f,"Homme","Ifs","Ponchant","Habitué",0.2f,R.drawable.pp_carree,description1);
        Sportif chloe = new Sportif("Chloé",19,new ArrayList<String>() {{ add("Equitation");}},3.1f,"Femme","Colombelles","Lamoureux","Ambassadrice",4.6f,R.drawable.chloe,description2);
        Sportif rayane = new Sportif("Rayane",20,new ArrayList<String>() {{ add("Pétanque");add("Volley");}},4f,"Homme","Troarn","Mehabli","Novice",2.7f,R.drawable.rayane,description1);
        Sportif baptiste = new Sportif("Baptiste",19,new ArrayList<String>() {{ add("Pétanque");add("Ball-Trap");}},1f,"Homme","Bretteville-sur-Odon","Revel","Novice",14.3f,R.drawable.baptiste,description2);
        Sportif amandine = new Sportif("Amandine",14,new ArrayList<String>() {{ add("Equitation");add("Tennis");}},2f,"Femme","Bretteville-sur-Odon","Rousseau","Habituée",14.3f,R.drawable.didine,description1);
        listesSportif.add(mael);
        listesSportif.add(chloe);
        listesSportif.add(rayane);
        listesSportif.add(baptiste);
        listesSportif.add(amandine);

        return listesSportif;
    }

    public int getImage()
    {
        return image;
    }
    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getNiveau() { return niveau;}
    public float getDistance(){return distance;}
    public ArrayList<String> getSport() {
        return sport;
    }

    public float getNote() {
        return note;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription()  {
        return this.description;
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

    public void setSport(ArrayList<String> sport) {
        this.sport = sport;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
