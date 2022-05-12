/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.services;
import com.HabHub.entities.Chien;
import com.HabHub.entities.AnnonceProprietaireChien;
import com.HabHub.entities.Individu;
import com.HabHub.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import org.json.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Ed
 */
public class ServiceAnnonceProprietaireChien {
    public static ServiceAnnonceProprietaireChien instance=null;
    
    public static boolean resultOk = true;

        
    private ConnectionRequest req;
    
    public static ServiceAnnonceProprietaireChien getInstance() {
        if (instance==null)
              instance = new ServiceAnnonceProprietaireChien();
            return instance;
    }
    
    public ServiceAnnonceProprietaireChien() {
        req = new ConnectionRequest();
    }
    
    public void addLost (int id) {
        String url=Statics.BASE_URL+"/annonce-proprietaire-chien/addlostdog/mobile?id="+id;
        req.setUrl(url);
        req.addResponseListener((e)-> {
            String str = new String(req.getResponseData());
            System.out.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public void removeLost (int id) {
        String url=Statics.BASE_URL+"/annonce-proprietaire-chien/removelostdog/mobile?id="+id;
        req.setUrl(url);
        req.addResponseListener((e)-> {
            String str = new String(req.getResponseData());
            System.out.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public void addMating (int id) {
        String url=Statics.BASE_URL+"/annonce-proprietaire-chien/addmatingdog/mobile?id="+id;
        req.setUrl(url);
        req.addResponseListener((e)-> {
            String str = new String(req.getResponseData());
            System.out.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public void removeMating (int id) {
        String url=Statics.BASE_URL+"/annonce-proprietaire-chien/removematingdog/mobile?id="+id;
        req.setUrl(url);
        req.addResponseListener((e)-> {
            String str = new String(req.getResponseData());
            System.out.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public ArrayList<AnnonceProprietaireChien>displayLost() {
        ArrayList<AnnonceProprietaireChien> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/annonce-proprietaire-chien/displayLost/mobile";
        req.setUrl(url);
        System.out.println(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    String jsonString = new String(req.getResponseData());
                    System.out.println(jsonString);
                    JSONArray  obj = new JSONArray (jsonString);
                    for (int i = 0; i < obj.length(); i++)
                        {
                            Chien c = new Chien();
                            Individu ind = new Individu();
                        AnnonceProprietaireChien a = new AnnonceProprietaireChien();
                                String prenom = obj.getJSONObject(i).getJSONObject("idchien").getJSONObject("idindividu").getString("prenom");
                                String nom = obj.getJSONObject(i).getJSONObject("idchien").getString("nom");
                                String age = obj.getJSONObject(i).getJSONObject("idchien").getString("age");
                                String image=obj.getJSONObject(i).getJSONObject("idchien").getString("image");
                              float idchien = Float.parseFloat(obj.getJSONObject(i).getJSONObject("idchien").get("idchien").toString());
                                String sexe = obj.getJSONObject(i).getJSONObject("idchien").getString("sexe");
                                c.setNom(nom);
                                
                                ind.setPrenom(prenom);
                                c.setIdIndividu(ind);
                                 c.setAge(age);
                                  c.setIdchien((int)idchien);
                                    c.setSexe(sexe);
                                    c.setImage(image);
                                    a.setIdChien(c);
                                    
                    
                        result.add(a);
                            
                        }
                                               
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
        
        
    }
    
     public ArrayList<AnnonceProprietaireChien>displayMating() {
        ArrayList<AnnonceProprietaireChien> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/annonce-proprietaire-chien/displayMating/mobile";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
               try {
                    String jsonString = new String(req.getResponseData());
                    System.out.println(jsonString);
                    JSONArray  obj = new JSONArray (jsonString);
                    for (int i = 0; i < obj.length(); i++)
                        {
                            Chien c = new Chien();
                            Individu ind = new Individu();
                        AnnonceProprietaireChien a = new AnnonceProprietaireChien();
                           String prenom = obj.getJSONObject(i).getJSONObject("idchien").getJSONObject("idindividu").getString("prenom");
                                String nom = obj.getJSONObject(i).getJSONObject("idchien").getString("nom");
                                String age = obj.getJSONObject(i).getJSONObject("idchien").getString("age");
                                String image=obj.getJSONObject(i).getJSONObject("idchien").getString("image");
                              float idchien = Float.parseFloat(obj.getJSONObject(i).getJSONObject("idchien").get("idchien").toString());
                                String sexe = obj.getJSONObject(i).getJSONObject("idchien").getString("sexe");
                                c.setNom(nom);
                                
                                ind.setPrenom(prenom);
                                c.setIdIndividu(ind);
                                 c.setAge(age);
                                  c.setIdchien((int)idchien);
                                    c.setSexe(sexe);
                                    c.setImage(image);
                                    a.setIdChien(c);
                    
                        result.add(a);
                            
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
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return chien;
        
        
    }
    
    
    //Delete 
    public boolean deleteDog(int id ) {
        String url = Statics.BASE_URL +"/deleteDog?id="+id;
        
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
