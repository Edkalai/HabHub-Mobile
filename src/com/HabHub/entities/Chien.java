/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

/**
 *
 * @author Ed
 */
public class Chien {
    private int idchien;
    private String nom;
    private String age;
    private String sexe;
    private boolean vaccination;
    private String description;
    private String image;
    private String color;
    private String race;
    private String groupe;
    private Individu idIndividu;
    private int liked;
    private int missing;
    private int mating;
    private int nbLikes;

    public Chien() {
    }

    public Chien(int idchien, String nom, String age,String sexe, boolean vaccination, String description, String image, String color, String race, String groupe,Individu idIndividu) {
        this.idchien = idchien;
        this.nom = nom;
        this.age = age;
        this.sexe=sexe;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
        this.color = color;
        this.race = race;
        this.groupe = groupe;
        this.idIndividu=idIndividu;
    }
     public Chien(int idchien, String nom, String age,String sexe, boolean vaccination, String description,String color, String race, String groupe,Individu idIndividu) {
        this.idchien = idchien;
        this.nom = nom;
        this.age = age;
        this.sexe=sexe;
        this.vaccination = vaccination;
        this.description = description;
        this.color = color;
        this.race = race;
        this.groupe = groupe;
        this.idIndividu=idIndividu;
    }

    public Chien(String nom, String age,String sexe, boolean vaccination, String description, String image, String color, String race, String groupe,Individu idIndividu) {
        this.nom = nom;
        this.age = age;
        this.sexe=sexe;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
        this.color = color;
        this.race = race;
        this.groupe = groupe;
        this.idIndividu=idIndividu;
    }
     public Chien(String nom, String age,String sexe, boolean vaccination, String description,String color, String race, String groupe,Individu idIndividu) {
        this.nom = nom;
        this.age = age;
        this.sexe=sexe;
        this.vaccination = vaccination;
        this.description = description;
        this.color = color;
        this.race = race;
        this.groupe = groupe;
        this.idIndividu=idIndividu;
    }

    public int getIdchien() {
        return idchien;
    }

    public void setIdchien(int idchien) {
        this.idchien = idchien;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isVaccination() {
        return vaccination;
    }

    public void setVaccination(boolean vaccination) {
        this.vaccination = vaccination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Individu getIdIndividu() {
        return idIndividu;
    }

    public void setIdIndividu(Individu idIndividu) {
        this.idIndividu = idIndividu;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getMissing() {
        return missing;
    }

    public void setMissing(int missing) {
        this.missing = missing;
    }

    public int getMating() {
        return mating;
    }

    public void setMating(int mating) {
        this.mating = mating;
    }

    public int getNbLikes() {
        return nbLikes;
    }

    public void setNbLikes(int nbLikes) {
        this.nbLikes = nbLikes;
    }

    @Override
    public String toString() {
        return "Chien{" + "idchien=" + idchien + ", nom=" + nom + ", age=" + age + ", sexe=" + sexe + ", vaccination=" + vaccination + ", description=" + description + ", image=" + image + ", color=" + color + ", race=" + race + ", groupe=" + groupe + ", idIndividu=" + idIndividu + ", liked=" + liked + ", missing=" + missing + ", mating=" + mating + ", nbLikes=" + nbLikes + '}';
    }
    
    
     
    
    
}
