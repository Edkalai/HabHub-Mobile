/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

import java.util.Date;
import  com.HabHub.entities.AnnonceProprietaireChien;

/**
 *
 * @author Ed
 */
public class AnnonceProprietaireChien {
    private int idAnnonceProprietaireChien;
    private Date datePublication;
    private String description;
    private String type;
    private Date datePerte;
    private String localisation;
    private Chien idChien;

    public AnnonceProprietaireChien(int idAnnonceProprietaireChien, Date datePublication, String description, String type, Date datePerte, String localisation, Chien idChien) {
        this.idAnnonceProprietaireChien = idAnnonceProprietaireChien;
        this.datePublication = datePublication;
        this.description = description;
        this.type = type;
        this.datePerte = datePerte;
        this.localisation = localisation;
        this.idChien = idChien;
    }

    public AnnonceProprietaireChien(Date datePublication, String description, String type, Date datePerte, String localisation, Chien idChien) {
        this.datePublication = datePublication;
        this.description = description;
        this.type = type;
        this.datePerte = datePerte;
        this.localisation = localisation;
        this.idChien = idChien;
    }

    public int getIdAnnonceProprietaireChien() {
        return idAnnonceProprietaireChien;
    }

    public void setIdAnnonceProprietaireChien(int idAnnonceProprietaireChien) {
        this.idAnnonceProprietaireChien = idAnnonceProprietaireChien;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatePerte() {
        return datePerte;
    }

    public void setDatePerte(Date datePerte) {
        this.datePerte = datePerte;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Chien getIdChien() {
        return idChien;
    }

    public void setIdChien(Chien idChien) {
        this.idChien = idChien;
    }

    @Override
    public String toString() {
        return "AnnonceProprietaireChien{" + "idAnnonceProprietaireChien=" + idAnnonceProprietaireChien + ", datePublication=" + datePublication + ", description=" + description + ", type=" + type + ", datePerte=" + datePerte + ", localisation=" + localisation + ", idChien=" + idChien + '}';
    }
    
    
}
