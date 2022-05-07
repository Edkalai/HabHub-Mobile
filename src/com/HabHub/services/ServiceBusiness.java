/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;

import com.codename1.io.ConnectionRequest;

/**
 *
 * @author Mariem
 */
public class ServiceBusiness {
    
    public static ServiceBusiness instance = null; 
    private ConnectionRequest req;
    public static ServiceBusiness getInstance(){
        if (instance ==null)
            instance= new ServiceBusiness();
            return instance; 
        
    }
    public ServiceBusiness(){
        req = new ConnectionRequest();
        
    }
    
    
    
    
}
