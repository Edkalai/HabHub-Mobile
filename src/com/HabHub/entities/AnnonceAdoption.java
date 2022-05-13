/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tun21
 */
public class AnnonceAdoption {
    private int idAnnonceAdoption;
    private Individu idIndividu ;
    private Chien Chien;
    private String datePublication;
    private String description;
    private String localisation;

    public AnnonceAdoption() {
    }

    public AnnonceAdoption(int idAnnonceAdoption, Individu idIndividu, Chien Chien, String description, String localisation) {
        this.idAnnonceAdoption = idAnnonceAdoption;
        this.idIndividu = idIndividu;
        this.Chien = Chien;
        this.description = description;
        this.localisation = localisation;
    }

    
    public AnnonceAdoption(int idAnnonceAdoption, Individu idIndividu, Chien Chien, String datePublication, String description, String localisation) {
        this.idAnnonceAdoption = idAnnonceAdoption;
        this.idIndividu = idIndividu;
        this.Chien = Chien;
        this.datePublication = datePublication;
        this.description = description;
        this.localisation = localisation;
    }
    
    

    public AnnonceAdoption(Individu idIndividu, Chien Chien, String description, String localisation) {
        this.idIndividu = idIndividu;
        this.Chien = Chien;
        this.description = description;
        this.localisation = localisation;
    }
    

    public AnnonceAdoption(Individu idIndividu , Chien Chien, String datePublication, String description, String localisation) {
        this.idIndividu  = idIndividu ;
        this.Chien = Chien;
        this.datePublication = datePublication;
        this.description = description;
        this.localisation = localisation;
    }

    public int getIdAnnonceAdoption() {
        return idAnnonceAdoption;
    }

    public void setIdAnnonceAdoption(int idAnnonceAdoption) {
        this.idAnnonceAdoption = idAnnonceAdoption;
    }

    
    
    public Individu getIdIndividu() {
        return idIndividu;
    }

    public void setIdIndividu(Individu idIndividu) {
        this.idIndividu = idIndividu;
    }

    

    public Chien getIdChien() {
        return Chien;
    }

    public void setIdChien(Chien idChien) {
        this.Chien = idChien;
    }


    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "AnnonceAdoption{" + "idAnnonceAdoption=" + idAnnonceAdoption + ", idIndividu=" + idIndividu + ", Chien=" + Chien + ", datePublication=" + datePublication + ", description=" + description + ", localisation=" + localisation + '}';
    }
    
    

    

    
   
    
   

    

    

   
    
    
    
    
    
    
}
