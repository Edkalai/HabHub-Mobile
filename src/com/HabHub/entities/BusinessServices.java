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
public class BusinessServices {
    private int idbusinessservices;
    private String nomservice;
    private float prix;
    private Business idbusiness;

    public BusinessServices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdbusinessservices() {
        return idbusinessservices;
    }

    public void setIdbusinessservices(int idbusinessservices) {
        this.idbusinessservices = idbusinessservices;
    }

    public String getNomservice() {
        return nomservice;
    }

    public void setNomservice(String nomservice) {
        this.nomservice = nomservice;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Business getIdbusiness() {
        return idbusiness;
    }

    public void setIdbusiness(Business idbusiness) {
        this.idbusiness = idbusiness;
    }

    public BusinessServices(int idbusinessservices, String nomservice, float prix, Business idbusiness) {
        this.idbusinessservices = idbusinessservices;
        this.nomservice = nomservice;
        this.prix = prix;
        this.idbusiness = idbusiness;
    }
    
}
