/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

import java.util.Date;

/**
 *
 * @author Mariem
 */
public class Revue {
    private int idrevue;
    private int nbetoiles;
    private String commentaire;
    private String datepublication;
    private Individu idindividu;
    private Business idbusiness;

    public int getIdrevue() {
        return idrevue;
    }

    public void setIdrevue(int idrevue) {
        this.idrevue = idrevue;
    }

    public int getNbetoiles() {
        return nbetoiles;
    }

    public void setNbetoiles(int nbetoiles) {
        this.nbetoiles = nbetoiles;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(String datepublication) {
        this.datepublication = datepublication;
    }

    public Individu getIdindividu() {
        return idindividu;
    }

    public void setIdindividu(Individu idindividu) {
        this.idindividu = idindividu;
    }

    public Business getIdbusiness() {
        return idbusiness;
    }

    public void setIdbusiness(Business idbusiness) {
        this.idbusiness = idbusiness;
    }
    
}
