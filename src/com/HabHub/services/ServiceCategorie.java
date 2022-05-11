/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;


import com.HabHub.entities.Categorie;
import com.HabHub.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asus
 */
public class ServiceCategorie {
       public static ServiceCategorie instance = null;
    
    private ConnectionRequest req;
    
     public static boolean resultOk = true;
    
    public static ServiceCategorie getInstance(){
        if(instance == null)
            instance = new ServiceCategorie();
            return instance;
    }

    public ServiceCategorie() {
        req = new ConnectionRequest();
    }
    
    public void ajouterCategorie(Categorie cat){
        String url = Statics.BASE_URL+"/categorie/new?nom="+cat.getNom()+
                "&description="+cat.getDescription()
                
           ;
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        }
    
    
    
    //afficher les produit
    public ArrayList<Categorie> AfficherCategories(){
        ArrayList<Categorie> result = new ArrayList<>();
  
        
          String url = Statics.BASE_URL+"/Categorie/back-office";
          req.setUrl(url);
          req.addResponseListener(new ActionListener<NetworkEvent>()  {
              @Override
              public void actionPerformed(NetworkEvent evt){
                  JSONParser jsonp;
                  jsonp = new JSONParser();
                  
                  try{
                      
                       Map<String,Object>mapProduits = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                         List<Map<String,Object>> listOfProds =  (List<Map<String,Object>>) mapProduits.get("root");
                      
                         for(Map<String, Object> obj : listOfProds) {
                        Categorie c = new Categorie();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("idCategorie").toString());
                        
                        String nom = obj.get("nom").toString();
                        
                        String description = obj.get("description").toString();
                                        
                   
                        c.setIdCategorie((int)id);
                        c.setNom(nom);
                        c.setDescription(description);
                       
                        
                        
                        //insert data into ArrayList result
                        result.add(c);
                 
                  }
                  }
                  catch(Exception ex){
                      ex.printStackTrace();
                   }
            
            }
        });
                
         NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
    }
    
    
    
      
    //Delete 
    public boolean deleteCategorie(int idCategorie ) {
        String url = Statics.BASE_URL +"/Categorie/{idcategorie}"+idCategorie;
        
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
    
    
     
    //Update 
    public boolean modifierProduit(Categorie categorie) {
        String url = Statics.BASE_URL +"/Categorie/{idcategorie}/edit"+categorie.getIdCategorie()+"&nom="+categorie.getNom()+"&description="+categorie.getDescription();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    
    
    
    
}
