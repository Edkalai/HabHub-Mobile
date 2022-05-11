/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;

import com.HabHub.entities.Business;
import com.HabHub.entities.Individu;
import com.HabHub.entities.Revue;
import com.HabHub.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

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
    
     public ArrayList<Business>displayBusinesses(){
       ArrayList<Business> result = new ArrayList<>();
       String url = Statics.BASE_URL+"/business/mobile/index";
       req.setUrl(url);
       
       
       req.addResponseListener(new ActionListener<NetworkEvent>(){
       @Override
       public void actionPerformed(NetworkEvent evt){
       JSONParser jsonp;
       jsonp = new JSONParser();
       try{
           Map<String,Object>mapBusiness = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
           
           List<Map<String,Object>>listOfMaps = (List<Map<String,Object>>) mapBusiness.get("root");
           
   
           for(Map<String,Object> obj : listOfMaps){
               Business bs = new Business();
               float idbusiness = Float.parseFloat(obj.get("idbusiness").toString());
               String titre = obj.get("titre").toString();
               String description = obj.get("description").toString();
               String horaire = obj.get("horaire").toString();
               String ville = obj.get("ville").toString();
               String type = obj.get("type").toString();
               String image = obj.get("image").toString();
               float lat = Float.parseFloat(obj.get("lat").toString());
               float lng = Float.parseFloat(obj.get("lng").toString());

    
               bs.setIdbusiness((int)idbusiness);
               bs.setTitre(titre);
               bs.setDescription(description);
               bs.setHoraire(horaire);
               bs.setVille(ville);
               bs.setType(type);
               bs.setImage(image);
               bs.setLat(lat);
               bs.setLng(lng);
                              
               result.add(bs);

           }
       }   catch (Exception ex) {
           ex.printStackTrace();
       }
       }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);
     
               return result;
   } 
    
    
}
