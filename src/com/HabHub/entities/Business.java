/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

/**
 *
 * @author Mariem
 */
public class Business {
    private int idbusiness;
    private String titre; 
    private String description;
    private String horaire;
    private String ville;
    private String type;
    private String image;
    //private Utilisateur idutilisateur;
    private float lat;
    private float lng;

    
    
    public Business(int idbusiness, String titre, String description, String horaire, String ville, String type, String image,float lat, float lng) {
        this.idbusiness = idbusiness;
        this.titre = titre;
        this.description = description;
        this.horaire = horaire;
        this.ville = ville;
       
        this.type = type;
        this.image = image;
        this.lat = lat;
        this.lng = lng;
    }/*
    public Business(int idbusiness, String titre, String description, String horaire, String ville, String localisation, String type, Utilisateur idutilisateur, float lng) {
        this.idbusiness = idbusiness;
        this.titre = titre;
        this.description = description;
        this.horaire = horaire;
        this.ville = ville;
        this.localisation = localisation;
        this.type = type;
        this.idutilisateur = idutilisateur;
        this.lng = lng;
    }

    public Business(int idbusiness, String titre, String description, String horaire, String ville, String localisation, String type, String image, Utilisateur idutilisateur, float lat, float lng) {
        this.idbusiness = idbusiness;
        this.titre = titre;
        this.description = description;
        this.horaire = horaire;
        this.ville = ville;
        this.localisation = localisation;
        this.type = type;
        this.image = image;
        this.idutilisateur = idutilisateur;
        this.lat = lat;
        this.lng = lng;
    }
*/

    public Business() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdbusiness() {
        return idbusiness;
    }

    public void setIdbusiness(int idbusiness) {
        this.idbusiness = idbusiness;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
/*
    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
*/
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

}
