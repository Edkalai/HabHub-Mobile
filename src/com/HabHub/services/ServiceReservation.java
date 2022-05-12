/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;

import com.HabHub.entities.Reservation;
import com.HabHub.utils.Statics;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

/**
 *
 * @author Mariem
 */
public class ServiceReservation {
    
    public static ServiceReservation instance = null; 
    private ConnectionRequest req;
    public static ServiceReservation getInstance(){
        if (instance ==null)
            instance= new ServiceReservation();
            return instance; 
        
    }
    public ServiceReservation(){
        req = new ConnectionRequest();
        
    }
    
   public void ajoutReservation(Reservation reservation){
      String url=Statics.BASE_URL+"/reservation/new-reservation/mobile?idbusinessservices="
              +reservation.getIdbusinessservices()+"&datereservation="
              +reservation.getDatereservation()+"&heurereservation="
              +reservation.getHeurereservation()+"idindividu="
              +reservation.getIdindividu()
              ;
      req.setUrl(url);
      req.addResponseListener((e)->{
          String str = new String(req.getResponseData());
          System.out.println("data=="+str);
      });
      NetworkManager.getInstance().addToQueueAndWait(req);
    
   }
   
    
    
}
