/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

/**
 *
 * @author asus
 */
public class Produit {
    
     private int idProduit;
    private int idCategorie;
    private int nbetoiles;
    private String nom;
    private String image;

     private String description;
    private String marque;
    private float prix;

    //kol chay
    public Produit(int idProduit, int idCategorie, int nbetoiles, String nom, String image, String description, String marque, float prix) {
        this.idProduit = idProduit;
        this.idCategorie = idCategorie;
        this.nbetoiles = nbetoiles;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
    }

        //sans idprod
    public Produit(int idCategorie, int nbetoiles, String nom, String image, String description, String marque, float prix) {
        this.idCategorie = idCategorie;
        this.nbetoiles = nbetoiles;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
    }

        //sans idprod et nbetoiles
    public Produit(int idCategorie, String nom, String image, String description, String marque, float prix) {
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
    }

    public Produit() {
   
    }

   

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getNbetoiles() {
        return nbetoiles;
    }

    public void setNbetoiles(int nbetoiles) {
        this.nbetoiles = nbetoiles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    
    
    
    
}
