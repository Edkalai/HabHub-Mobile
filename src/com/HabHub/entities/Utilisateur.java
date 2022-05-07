/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.entities;

/**
 *
 * @author User
 */
public class Utilisateur {
    int idutilisateur ;
    String email ; 
    String password;
    int numtel;
    String type ; 

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

}
