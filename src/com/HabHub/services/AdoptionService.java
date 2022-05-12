/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.HabHub.services;

import com.HabHub.entities.AnnonceAdoption;
import com.HabHub.entities.Chien;
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
 * @author Tun21
 */
public class AdoptionService {
    
    
    //singleton 
    public static AdoptionService instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static AdoptionService getInstance() {
        if(instance == null )
            instance = new AdoptionService();
        return instance ;
    }
    
    
    
    public AdoptionService() {
        req = new ConnectionRequest();
        
    }
    
    
    /*ajout 
    public void ajoutReclamation(AnnonceAdoption annonce) {
        
        String url =Statics.BASE_URL+"/addReclamation?objet="+annonce.getObjet()+"&description="+annonce.getDescription()+"&user="+annonce.getIduser(); // aa sorry n3adi getId lyheya mech ta3 user ta3 reclamation
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
*/
    
    
    //affichage
    
    public ArrayList<AnnonceAdoption>affichageReclamations() {
        ArrayList<AnnonceAdoption> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/annonce/adoption/displayMobileAdoption";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapAdoption = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapAdoption.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        AnnonceAdoption a = new AnnonceAdoption();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("idAnnonceAdoption").toString());
                        
                        Individu indiv = (Individu) obj.get("idIndividu");
                        Chien ch = (Chien) obj.get("Chien");
                        
                        String description = obj.get("description").toString();
                        String localisation = obj.get("localisation").toString();
       
                        
                        a.setIdAnnonceAdoption((int)id);
                        a.setIdIndividu(indiv);
          
                        a.setDescription(description);
                        a.setDescription(localisation);
                        a.setIdChien(ch);
                        
                        //Date 
                        String DateConverter =  obj.get("datePublication").toString().substring(obj.get("datePublication").toString().indexOf("timestamp") + 10 , obj.get("datePublication").toString().lastIndexOf("}"));
                        
                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                        
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(currentTime);
                        a.setDatePublication(dateString);
                        
                        //insert data into ArrayList result
                        result.add(a);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
    
    
    /*
    //Detail Reclamation bensba l detail n5alihoa lel5r ba3d delete+update
    
    public Reclamation DetailRecalamation( int id , Reclamation reclamation) {
        
        String url = Statics.BASE_URL+"/detailReclamation?"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                reclamation.setObjet(obj.get("obj").toString());
                reclamation.setDescription(obj.get("description").toString());
                reclamation.setEtat(Integer.parseInt(obj.get("etat").toString()));
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return reclamation;
        
        
    }
    
    
    //Delete 
    public boolean deleteReclamation(int id ) {
        String url = Statics.BASE_URL +"/deleteReclamation?id="+id;
        
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
    public boolean modifierReclamation(Reclamation reclamation) {
        String url = Statics.BASE_URL +"/updateReclamation?id="+reclamation.getId()+"&objet="+reclamation.getObjet()+"&description="+reclamation.getDescription()+"&etat="+reclamation.getEtat();
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
    */
    
}
