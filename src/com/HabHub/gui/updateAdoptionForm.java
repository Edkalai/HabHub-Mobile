/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.gui;

import com.HabHub.entities.AnnonceAdoption;
import com.HabHub.gui.BaseForm;
import com.HabHub.services.AdoptionService;
import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;


/**
 *
 * @author Lenovo
 */
public class updateAdoptionForm extends BaseForm {
    
    Form current;
    public updateAdoptionForm(Resources res , AnnonceAdoption r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
        TextField localisation = new TextField(r.getLocalisation() , "localisation" , 20 , TextField.ANY);
        TextField description = new TextField(r.getDescription() , "description" , 20 , TextField.ANY);
          
 
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboB
        
            
        localisation.setUIID("NewsTopLine");
        description.setUIID("NewsTopLine");
        
        
        localisation.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
        
        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           r.setLocalisation(localisation.getText());
           r.setDescription(description.getText());
           
           
      
       
       //appel fonction modfier reclamation men service
       
       if(AdoptionService.getInstance().modifierAnnonce(r)) { // if true
           new ListAdoption(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListAdoption(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(localisation),
                createLineSeparator(),
                new FloatingHint(description),
                createLineSeparator(),
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}