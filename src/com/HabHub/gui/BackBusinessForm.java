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
import com.HabHub.entities.Business;
import com.HabHub.services.ServiceBusiness;
import com.HabHub.services.ServiceChien;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.FontImage;
import java.util.ArrayList;

/**
 *
 * @author tarek
 */
public class BackBusinessForm extends BackBaseForm{
     Form current;
    
    public BackBusinessForm(Resources res){
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

        addTab(swipe,s1,"","",res);

        // Design

  swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
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
        RadioButton Ajout = RadioButton.createToggle("Add", barGroup);
        Ajout.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("Update", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("All", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        
        Ajout.addActionListener((e) -> {
            AddBusinessForm add = new AddBusinessForm(res);
            add.show();
            
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(2, partage, Ajout),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(Ajout, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
        
                
        //Appel affichage methode
        ArrayList<Business>list = ServiceBusiness.getInstance().displayBusinesses(); 
             int i = 0;
        for(Business b : list)
        {
            i++;
             String urlImage = "http://localhost/HabHub-Website/public/FrontOffice/uploads/"+b.getImage();
            System.out.println(b.getImage());
            Image placeHolder = Image.createImage(120, 90);
            EncodedImage enc = EncodedImage.createFromImage(placeHolder, false);
            URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
            addBusinessToList(urlim,b,res,i);
            ScaleImageLabel image = new ScaleImageLabel(urlim);
            Container containerImg = new Container();
            image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        } 
       
    }
        private void addTab(Tabs swipe, Label spacer, String string, String text, Resources res) {

        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        
        

        Label overLay = new Label("","ImageOverlay");

        Container page1 = LayeredLayout.encloseIn(
            
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

    private void addBusinessToList(Image img,Business b, Resources res, int i) {
        
        
        int height = Display.getInstance().convertToPixels(16f);
        int width = Display.getInstance().convertToPixels(12f);

        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        

          
        
        Label titreTxt = new Label(b.getTitre(),"NewsTopLine2");
        Label DescriptionTxt = new Label("Description: "+b.getDescription(),"NewsTopLine2");
        Label horaireTxt = new Label("Opening Hours: "+b.getHoraire(),"NewsTopLine1");
        Label villeTxt = new Label("City: "+b.getVille(),"NewsTopLine2");
        Label typeTxt = new Label("Type: "+b.getType(),"NewsTopLine2");
        Label margin = new Label("    ","NewsTopLine2");
        Label line = new Label("__________________________","NewsTopLine2");

        
             

         createLineSeparator();
        
       
       
        
        //supprimer button
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprmierStyle = new Style(lSupprimer.getUnselectedStyle());
        supprmierStyle.setFgColor(0xf21f1f);
        
        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprmierStyle);
        lSupprimer.setIcon(supprimerImage);
        lSupprimer.setTextPosition(RIGHT);
        
        //click delete icon
        lSupprimer.addPointerPressedListener(l -> {
            
            Dialog dig = new Dialog("Suppression");
            
            if(dig.show("Suppression","Vous voulez supprimer ce Business ?","Annuler","Oui")) {
                dig.dispose();
               
            }
            else {
                dig.dispose();
                 if(ServiceBusiness.getInstance().DeleteBusiness(b.getIdbusiness())) {
                      new BackBusinessForm(res).show();                 
                }
                 }
                
           
        });
        
        
                cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(

         
            BoxLayout.encloseX(titreTxt),                        
            BoxLayout.encloseX(DescriptionTxt),
            BoxLayout.encloseX(horaireTxt),
            BoxLayout.encloseX(villeTxt),
            BoxLayout.encloseX(typeTxt),
            BoxLayout.encloseX(lSupprimer),
            BoxLayout.encloseX(margin),
            BoxLayout.encloseX(line)
        ));

        add(cnt);
        System.out.println(cnt);
    }
}
