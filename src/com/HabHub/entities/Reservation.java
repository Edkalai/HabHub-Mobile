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
public class Reservation {
private int idreservation; 
private BusinessServices idbusinessservices;
private Date datereservation;
private String heurereservation;
private Individu idindividu;

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public BusinessServices getIdbusinessservices() {
        return idbusinessservices;
    }

    public void setIdbusinessservices(BusinessServices idbusinessservices) {
        this.idbusinessservices = idbusinessservices;
    }

    public Date getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(Date datereservation) {
        this.datereservation = datereservation;
    }

    public String getHeurereservation() {
        return heurereservation;
    }

    public void setHeurereservation(String heurereservation) {
        this.heurereservation = heurereservation;
    }

    public Individu getIdindividu() {
        return idindividu;
    }

    public void setIdindividu(Individu idindividu) {
        this.idindividu = idindividu;
    }

}
