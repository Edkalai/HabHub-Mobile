/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

import java.util.Date;

/**
 *
 * @author User
 */
public class Individu {
    private int idindividu;
    private Utilisateur utilisateur;
    private String nom;
    private String prenom;
    private String sexe;
    private Date datenaissance;
    private String adresse;
    private String facebook;
    private String instagram;
    private String whatsapp;
    private Boolean proprietairechien;

    public Individu(String nom, String prenom,  String adresse,String sexe, String facebook, String instagram, String whatsapp) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(int idindividu, Utilisateur utilisateur, String nom, String prenom,Date datenaissance, String sexe,  String adresse, String facebook, String instagram, String whatsapp) {
        this.idindividu = idindividu;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datenaissance = datenaissance;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(int idindividu, String nom, String prenom) {
        this.idindividu = idindividu;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Individu(int idIndividu, Utilisateur utilisateur, String nom, String prenom, String sexe, Date datenaissance, String adresse, String facebook, String instagram, String whatsapp, Boolean proprietairechien) {
        this.idindividu = idindividu;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datenaissance = datenaissance;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
        this.proprietairechien = proprietairechien;
    }

    public Individu(int idindividu, Utilisateur utilisateur, String nom, String prenom, Date datenaissance, String adresse, String facebook, String instagram, String whatsapp) {
        this.idindividu = idindividu;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(int idindividu, Utilisateur utilisateur, String nom, String prenom,String sexe,String adresse, String facebook, String instagram, String whatsapp) {
        this.idindividu = idindividu;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe=sexe;
        this.adresse=adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(Utilisateur utilisateur, String nom, String prenom, Date datenaissance, String adresse, String facebook, String instagram, String whatsapp) {
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(int idIndividu) {
        this.idindividu = idindividu;
    }
     public Individu() {
       
    }

    public int getIdIndividu() {
        return idindividu;
    }

    public void setIdIndividu(int idIndividu) {
        this.idindividu = idIndividu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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

    public Date getDateNaissance() {
        return datenaissance;
    }

    public void setDateNaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Boolean getProprietaireChien() {
        return proprietairechien;
    }

    public void setProprietaireChien(Boolean proprietairechien) {
        this.proprietairechien = proprietairechien;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    @Override
    public String toString() {
        return "Individu{" + "idIndividu=" + idindividu + ", utilisateur=" + utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", dateNaissance=" + datenaissance + ", adresse=" + adresse + ", facebook=" + facebook + ", instagram=" + instagram + ", whatsapp=" + whatsapp + ", proprietaireChien=" + proprietairechien + '}';
    }

}
