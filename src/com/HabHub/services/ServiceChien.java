/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;
import com.HabHub.entities.Chien;
import com.HabHub.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Ed
 */
public class ServiceChien {
    public static ServiceChien instance=null;
    
    public static boolean resultOk = true;

        
    private ConnectionRequest req;
    
    public static ServiceChien getInstance() {
        if (instance==null)
              instance = new ServiceChien();
            return instance;
    }
    
    public ServiceChien() {
        req = new ConnectionRequest();
    }
    
    public void addDog (Chien chien) {
        String url=Statics.BASE_URL+"/chien/addDog?nom="+chien.getNom()+"&age="+chien.getAge()+
                "&sexe="+chien.getSexe()+"&vaccination="+chien.isVaccination()+"&description="+
                chien.getDescription()+"&color="+chien.getColor()+"&race="+chien.getRace()+
                "&groupe="+chien.getGroupe()+"&idindividu="+chien.getIdIndividu();
        req.setUrl(url);
        req.addResponseListener((e)-> {
            String str = new String(req.getResponseData());
            System.out.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
      public void addLike (int idindividu,int idchien) {
        String url=Statics.BASE_URL+"/likes/mobile/addlikemobile/mobile?idchien="+idchien+"&idindividu="+idindividu;
         req.setUrl(url);
        req.addResponseListener((e)-> {
            String str = new String(req.getResponseData());
           
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
     public void removeLike (int idindividu,int idchien)  {
         String url=Statics.BASE_URL+"/likes/mobile/removelikemobile?idchien="+idchien+"&idindividu="+idindividu;
        req.setUrl(url);
        req.addResponseListener((e)-> {
            String str = new String(req.getResponseData());
       
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public ArrayList<Chien>displayMyDogs() {
        ArrayList<Chien> result = new ArrayList<>();
        
        String urlmydogs = Statics.BASE_URL+"/chien/displayMyDogs?id=2";
        req.setUrl(urlmydogs);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evnt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapMyDogs = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapMyDogs.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Chien c = new Chien();
                        
                       
                        float idchien = Float.parseFloat(obj.get("idchien").toString());
                        String nom = obj.get("nom").toString();
                        String image = obj.get("image").toString();
                        String sexe = obj.get("sexe").toString();
                        String age = obj.get("age").toString();
                        int nbLikes = Integer.parseInt(obj.get("nb").toString());
                        int missing = Integer.parseInt(obj.get("missing").toString());
                        int mating = Integer.parseInt(obj.get("mating").toString());
                        
                       
                        
                        c.setIdchien((int)idchien);
                        c.setNom(nom);
                        c.setSexe(sexe);
                        c.setAge(age);
                        c.setImage(image);
                        c.setNbLikes(nbLikes);
                        c.setMissing(missing);
                        c.setMating(mating);
                        
                    
                        //insert data into ArrayList result
                        result.add(c);
                      
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
      NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
        
        
    }
    
     public ArrayList<Chien>displayDogsNextDoor() {
        ArrayList<Chien> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/chien/displayDogsNextDoor?id=2";
  
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapMyDogs = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapMyDogs.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Chien c = new Chien();
                        
                        //dima id fi codename one float 5outhouha
                        float idchien = Float.parseFloat(obj.get("idchien").toString());
                        String nom = obj.get("nom").toString();
                        String image = obj.get("image").toString();
                        String sexe = obj.get("sexe").toString();
                        String age = obj.get("age").toString();
                        
                         int liked = Integer.parseInt(obj.get("liked").toString());
                        String playWithMe = obj.get("playwithme").toString();
                        
                       
                        
                        c.setIdchien((int)idchien);
                        c.setNom(nom);
                        c.setSexe(sexe);
                        c.setAge(age);
                        c.setImage(image);
                        c.setLiked(liked);
                        
                    
                        //insert data into ArrayList result
                        result.add(c);
                      
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
      NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
        
        
    }
    
  
    
    
    public Chien DetailRecalamation( int id , Chien chien) {
        
        String url = Statics.BASE_URL+"/detailReclamation?"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                
                        String nom = obj.get("nom").toString();
                        String sexe = obj.get("sexe").toString();
                        String age = obj.get("age").toString();
                        int nblikes = Integer.parseInt(obj.get("nb").toString());
                        int missing = Integer.parseInt(obj.get("missing").toString());
                        int mating = Integer.parseInt(obj.get("mating").toString());
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);

              return chien;
        
        
    }
    
    
    //Delete 
    public boolean deleteDog(int id ) {
        String url = Statics.BASE_URL +"/chien/deleteDog?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    

}
