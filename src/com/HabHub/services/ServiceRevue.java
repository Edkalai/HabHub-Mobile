/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;

import com.HabHub.entities.Business;
import com.HabHub.entities.Individu;
import com.HabHub.entities.Reservation;
import com.HabHub.entities.Revue;
import com.HabHub.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Mariem
 */
public class ServiceRevue {
    
    public static ServiceRevue instance = null; 
    private ConnectionRequest req;
    public static ServiceRevue getInstance(){
        if (instance ==null)
            instance= new ServiceRevue();
            return instance; 
        
    }
    public ServiceRevue(){
        req = new ConnectionRequest();
        
    }
    
   public void ajoutRevue(Revue revue){
      String url=Statics.BASE_URL+"/revue/new/mobile-revue?&nbetoiles="
              +revue.getNbetoiles()+"&commentaire="
              +revue.getCommentaire()+"&datepublication="
              +revue.getDatepublication()+"&idindividu="
              +revue.getIdindividu()+"&idbusiness="
              +revue.getIdbusiness();

              
      req.setUrl(url);
      req.addResponseListener((e)->{
          String str = new String(req.getResponseData());
          System.out.println("data=="+str);
      });
      NetworkManager.getInstance().addToQueueAndWait(req);
    
   }
   public ArrayList<Revue>displayRevues(Revue revue){
       ArrayList<Revue> result = new ArrayList<>();
       String url = Statics.BASE_URL+"/revue/index?idbusiness="+revue.getIdbusiness();
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
               Revue re = new Revue();
               JSONObject business = new JSONObject(url);
               //String pageName = obj.getJSONObject("idbusiness").getString("titre");
               Object idbusiness = obj.get("idbusiness");
               Business idb = (Business) idbusiness;
               Object idindividu = obj.get("idindividu");
               Individu idi = (Individu) idindividu;
               //float idindividu = Float.parseFloat(obj.get("idindividu").toString());
               float nbetoiles = Float.parseFloat(obj.get("nbetoiles").toString());             
               String commentaire = obj.get("commentaire").toString();
               String datepublication = obj.get("datepublication").toString();
               
               re.setIdbusiness(idb);
               re.setIdindividu(idi);
               re.setNbetoiles((int)nbetoiles);
               re.setCommentaire(commentaire);
               
               
               String DateConverter=obj.get("datepublication").toString().substring(obj.get("datepublication").toString().indexOf("timestamp")+10,obj.get("obj").toString().lastIndexOf("}"));
               
               Date currentTime = new Date(Double.valueOf(DateConverter).longValue()*1000);
               SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
               String datepub = formatter.format(currentTime);
               re.setDatepublication(datepub);
               
               result.add(re);

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
