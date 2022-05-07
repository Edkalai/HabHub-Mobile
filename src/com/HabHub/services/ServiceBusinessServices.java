/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;

import com.HabHub.entities.Business;
import com.HabHub.entities.BusinessServices;
import com.HabHub.entities.Individu;
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

/**
 *
 * @author Mariem
 */
public class ServiceBusinessServices {
    
    public static ServiceBusinessServices instance = null; 
    private ConnectionRequest req;
    public static ServiceBusinessServices getInstance(){
        if (instance ==null)
            instance= new ServiceBusinessServices();
            return instance; 
        
    }
    public ServiceBusinessServices(){
        req = new ConnectionRequest();
        
    }
    
      
   public void ajoutBusinessServices(BusinessServices bs){
      String url=Statics.BASE_URL+"/business/services/mobile/new?idbusiness="
              +bs.getIdbusiness()+"nomservice="
              +bs.getNomservice()+"&prix="
              +bs.getPrix();
          
      req.setUrl(url);
      req.addResponseListener((e)->{
          String str = new String(req.getResponseData());
          System.out.println("data=="+str);
      });
      NetworkManager.getInstance().addToQueueAndWait(req);
    
   }
    
      public ArrayList<BusinessServices>displayBusinessServices(BusinessServices bs){
       ArrayList<BusinessServices> result = new ArrayList<>();
       String url = Statics.BASE_URL+"revue/index?idbusiness="+bs.getIdbusiness();
       req.setUrl(url);
       
       
       req.addResponseListener(new ActionListener<NetworkEvent>(){
       @Override
       public void actionPerformed(NetworkEvent evt){
       JSONParser jsonp;
       jsonp = new JSONParser();
       try{
           Map<String,Object>mapRevues = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
           
           List<Map<String,Object>>listOfMaps = (List<Map<String,Object>>) mapRevues.get("root");
           
           
           for(Map<String,Object> obj : listOfMaps){
               BusinessServices bs = new BusinessServices();
               Object idbusiness = obj.get("idbusiness");
               Business idb = (Business) idbusiness;
  
              
               
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
