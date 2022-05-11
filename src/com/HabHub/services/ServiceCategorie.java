/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;

import com.HabHub.entities.Produit;
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
       public static ServiceProduit instance = null;
    
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
    
    public void ajouterProduit(Produit produit){
        String url = Statics.BASE_URL+"/produit/new?nom="+produit.getNom()+
                "&description="+produit.getDescription()+
                "&prix="+produit.getPrix()+
                "&marque="+produit.getMarque()+
                "&categorie"+produit.getIdCategorie();
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        }
    
    
    
    //afficher les produit
    public ArrayList<Produit> AfficherProduits(){
        ArrayList<Produit> result = new ArrayList<>();
  
        
          String url = Statics.BASE_URL+"/produit";
          req.setUrl(url);
          req.addResponseListener(new ActionListener<NetworkEvent>()  {
              public void actionPerformed(NetworkEvent evt){
                  JSONParser jsonp;
                  jsonp = new JSONParser();
                  
                  try{
                      
                       Map<String,Object>mapProduits = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                         List<Map<String,Object>> listOfProds =  (List<Map<String,Object>>) mapProduits.get("root");
                      
                         for(Map<String, Object> obj : listOfProds) {
                        Produit p = new Produit();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("idProduit").toString());
                        
                        String nom = obj.get("nom").toString();
                        
                        String description = obj.get("description").toString();
                        float prix = Float.parseFloat(obj.get("prix").toString());
                        String marque = obj.get("marque").toString();
                        
                        float idCategorie = Float.parseFloat(obj.get("idCategorie").toString());
                     
                        
                        p.setIdProduit((int)id);
                        p.setNom(nom);
                        p.setDescription(description);
                        p.setPrix(prix);
                        p.setMarque(marque);
                        p.setIdCategorie((int)idCategorie);
                        
                        
                        //insert data into ArrayList result
                        result.add(p);
                 
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
    public boolean deleteProduit(int idProduit ) {
        String url = Statics.BASE_URL +"/produit/{idproduit}"+idProduit;
        
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
    public boolean modifierProduit(Produit produit) {
        String url = Statics.BASE_URL +"/produit/{idproduit}/edit"+produit.getIdProduit()+"&nom="+produit.getNom()+"&description="+produit.getDescription()+"&prix="+produit.getPrix()+"&marque="+produit.getMarque()+"&idCategorie="+produit.getIdCategorie();
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
