/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.HabHub.entities.Chien;
import com.HabHub.services.ServiceChien;
import com.HabHub.services.ServiceAnnonceProprietaireChien;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.FontImage;
import java.util.ArrayList;

/**
 *
 * @author tarek
 */
public class MyDogsForm extends BaseForm{
     Form current;
    
    public MyDogsForm(Resources res){
                super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current=this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Search");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        tb.addSearchCommand(e -> {

        });
        //design
        
                Tabs swipe = new Tabs();

        Label s1 = new Label();
        Label s2 = new Label();

        addTab(swipe,s1,res.getImage("back-logo.png"),"","",res);

        // Design

  swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0x000000);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton myDogs = RadioButton.createToggle("My Dogs", barGroup);
        myDogs.setUIID("SelectBar");
        RadioButton dogsNextDoor = RadioButton.createToggle("Dogs Next Door", barGroup);
        dogsNextDoor.setUIID("SelectBar");
        RadioButton lostDogs = RadioButton.createToggle("Lost", barGroup);
        lostDogs.setUIID("SelectBar");
        RadioButton matingDogs = RadioButton.createToggle("Mating", barGroup);
        matingDogs.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


       
        myDogs.addActionListener((e) -> {
              
        MyDogsForm a = new MyDogsForm(res);
         a.show();
            refreshTheme();
        });

         dogsNextDoor.addActionListener((e) -> {
              
        DogsNextDoorForm a = new DogsNextDoorForm(res);
         a.show();
            refreshTheme();
        });
         lostDogs.addActionListener((e) -> {
              
        LostDogsForm a = new LostDogsForm(res);
         a.show();
            refreshTheme();
        });
         
         matingDogs.addActionListener((e) -> {
              
        MatingDogsForm a = new MatingDogsForm(res);
         a.show();
            refreshTheme();
        });
        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(4, myDogs, dogsNextDoor, lostDogs,matingDogs),
                FlowLayout.encloseBottom(arrow)
        ));

        myDogs.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(myDogs, arrow);
        });
        bindButtonSelection(myDogs, arrow);
        bindButtonSelection(dogsNextDoor, arrow);
        bindButtonSelection(lostDogs, arrow);
        bindButtonSelection(matingDogs, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
        
                
        //Appel affichage methode
        ArrayList<Chien>list = ServiceChien.getInstance().displayMyDogs(); 
             int i = 0;
        for(Chien c : list)
        {
            i++;
             String urlImage = "http://localhost/HabHub-Website/public/FrontOffice/uploads/"+c.getImage();
            System.out.println(c.getImage());
            Image placeHolder = Image.createImage(120, 90);
            EncodedImage enc = EncodedImage.createFromImage(placeHolder, false);
            URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
            addDog(urlim,c,res,i);
            ScaleImageLabel image = new ScaleImageLabel(urlim);
            Container containerImg = new Container();
            image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        }

       


        
        
        //enddesign
        
        
        
        
    }
    
    
    
        private void addTab(Tabs swipe, Label spacer, Image image, String string, String text, Resources res) {

        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        
        if(image.getHeight() < size)
        {
            image = image.scaledHeight(size);
        }

        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2)
        {
             image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }

        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label overLay = new Label("","ImageOverlay");

        Container page1 = LayeredLayout.encloseIn(
            imageScale,
            overLay,
            BorderLayout.south(
                BoxLayout.encloseY(
                    new SpanLabel(text, "LargeWhiteText"),
                    spacer
                )
            )
        );

        swipe.addTab("",res.getImage("back-logo.png"), page1);
    }


    private void updateArrowPosition(Button btn, Label l) {

        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);
        l.getParent().repaint();
    }

    public void bindButtonSelection(Button btn , Label l)
    {
        btn.addActionListener(e -> {

            if(btn.isSelected())
            {
                updateArrowPosition(btn,l);
            }

        });

    }

    private void addDog(Image img,Chien c, Resources res, int i) {
        
        
        int height = Display.getInstance().convertToPixels(16f);
        int width = Display.getInstance().convertToPixels(12f);

        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        

          
        
        Label NameCategTxt = new Label(c.getNom(),"NewsTopLine2");
        Label DescriptionCategTxt = new Label(c.getAge(),"NewsTopLine2");
        Label margin = new Label("","NewsTopLine2");

         createLineSeparator();
        
       
       
        
        //supprimer button
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style buttonStyle = new Style(lSupprimer.getUnselectedStyle());
        buttonStyle.setFgColor(0xe06c24);
        FontImage suprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, buttonStyle);
        lSupprimer.setIcon(suprrimerImage);
        lSupprimer.setTextPosition(RIGHT);
        
        //click delete icon
        lSupprimer.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Suppression");
            
            if(dig.show("Suppression","Vous voulez supprimer ce chien ?","Annuler","Oui")) {
                dig.dispose();
               
            }
            else {
                dig.dispose();
                 if(ServiceChien.getInstance().deleteDog(c.getIdchien())) {
                    new MyDogsForm(res).show();
                }
                 }
                
           
        });
        
         //add lost button
        Label lost = new Label(" ");
        lost.setUIID("NewsTopLine");
        Style lostStyle = new Style(lost.getUnselectedStyle());
        FontImage lostImage = FontImage.createMaterial(FontImage.MATERIAL_SEARCH,buttonStyle);
        lost.setIcon(lostImage);
        lost.setTextPosition(RIGHT);
        
      
        lost.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Lost");
            
            if(dig.show("Lost","Do you want to declare your dog as lost","Cancel","Yes")) {
                dig.dispose();
               
            }
            else {
                dig.dispose();
                ServiceAnnonceProprietaireChien.getInstance().addLost(c.getIdchien());
                    new MyDogsForm(res).show();
                
                 }
                
           
        });
        
         //remove lost button
        Label notLost = new Label(" ");
        notLost.setUIID("NewsTopLine");
        FontImage notLostImage = FontImage.createMaterial(FontImage.MATERIAL_SEARCH_OFF,buttonStyle);
        notLost.setIcon(notLostImage);
        notLost.setTextPosition(RIGHT);
        
      
        notLost.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Lost");
            
            if(dig.show("Lost","Do you want to declare your dog as found","Cancel","Yes")) {
                dig.dispose();
               
            }
            else {
                dig.dispose();
                ServiceAnnonceProprietaireChien.getInstance().removeLost(c.getIdchien());
                    new MyDogsForm(res).show();
                
                 }
                
           
        });
        
        //add mating button
        Label mating = new Label(" ");
        mating.setUIID("NewsTopLine");
        FontImage matingImage = FontImage.createMaterial(FontImage.MATERIAL_CHECK_CIRCLE_OUTLINE,buttonStyle);
        mating.setIcon(matingImage);
        mating.setTextPosition(RIGHT);
        
      
        mating.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Mating");
            
            if(dig.show("Lost","Do you want to declare your dog as looking for a partner","Cancel","Yes")) {
                dig.dispose();
               
            }
            else {
                dig.dispose();
                ServiceAnnonceProprietaireChien.getInstance().addMating(c.getIdchien());
                    new MyDogsForm(res).show();
                
                 }
                
           
        });
         //remove mating button
        Label notMating = new Label(" ");
        notMating.setUIID("NewsTopLine");
        FontImage notMatingImage = FontImage.createMaterial(FontImage.MATERIAL_CHECK_CIRCLE,buttonStyle);
        notMating.setIcon(notMatingImage);
        notMating.setTextPosition(RIGHT);
        
       notMating.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Mating");
            
            if(dig.show("Lost","Has your dog found a partner?","Cancel","Yes")) {
                dig.dispose();
               
            }
            else {
                dig.dispose();
                ServiceAnnonceProprietaireChien.getInstance().removeMating(c.getIdchien());
                    new MyDogsForm(res).show();
                
                 }
                
           
        });
        Label lostButton=lost;
       Label matingButton=mating;
       if (c.getMissing()==1)
       {
       lostButton=notLost;
       }
       if (c.getMating()==1)
       {
       matingButton=notMating;
       }
      
        
        
        FontImage heart = FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, buttonStyle);
         Label likes = new Label(Integer.toString(c.getNbLikes()));
        likes.setUIID("NewsTopLine");
        likes.setIcon(heart);
        likes.setTextPosition(RIGHT);
       
                cnt.add(BorderLayout.CENTER, BoxLayout.encloseX(

         
            BoxLayout.encloseX(NameCategTxt),
            BoxLayout.encloseX(DescriptionCategTxt),
            BoxLayout.encloseX(margin),
            BoxLayout.encloseX(likes)
            
            
                     

        ));
                 cnt.add(BorderLayout.EAST, BoxLayout.encloseY(
         BoxLayout.encloseX(lSupprimer),
         BoxLayout.encloseX(matingButton),
            BoxLayout.encloseX(lostButton)
           
            
                     

        ));
           
                 
                 

        add(cnt);
       
    }
}
