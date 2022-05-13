/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.gui;

import com.HabHub.entities.Produit;
import com.HabHub.services.ServiceProduit;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import static com.codename1.io.Log.p;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ListProduitsForm extends BaseForm {
    public static List<Produit> p = new ArrayList<>();
     Form f = new Form("Panier Liste", new BoxLayout(BoxLayout.Y_AXIS));
      
    Form current;
    public ListProduitsForm(Resources res ) {
        
     
        
      
          super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Search For A Product");
        getContentPane().setScrollVisible(false);
        super.addSideMenu(res);

        int occ = 0;
        tb.addSearchCommand(e ->  {
            
        });
        
        Tabs swipe = new Tabs();
        
        Label s1 = new Label();
        Label s2 = new Label();
        
        addTab(swipe,s1, res.getImage("back-logo.png"),"","",res);
        
        // Welcome current user
        
//        System.out.println("user connecté id ="+ SessionManager.getId());
        
        
        
       // System.out.println("user connecté username ="+ SessionManager.getUserName());
        
       // System.out.println("user connecté password ="+ SessionManager.getPassowrd());
        
        //System.out.println("user connecté email ="+ SessionManager.getEmail());
        
        
        
               
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
        
        
        
        
        

          
         //  ArrayList <Produit> p = new ArrayList<>();
           

        ButtonGroup barGroup = new ButtonGroup();
         RadioButton produits = RadioButton.createToggle("Products", barGroup);
        produits.setUIID("SelectBar");
       
        RadioButton listecom = RadioButton.createToggle("My Cart", barGroup);
        listecom.setUIID("SelectBar");
        
        
            Container panier = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        listecom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                for (int i = 0; i < p.size(); i++) {
                    Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container c4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    ImageViewer image = new ImageViewer();
                    Image placeholder = Image.createImage(100, 100, 0xbfc9d2);
                    EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
                    Image img = URLImage.createToStorage(encImage, p.get(i).getImage(), "http://localhost/HabHub-Website/public/FrontOffice/uploads/" + p.get(i).getImage(), URLImage.RESIZE_SCALE);
                    image.setImage(img);
                    img.getWidth();
                    c4.add(image);
                    Container c5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Label lb = new Label(p.get(i).getNom());
                    Label lb3 = new Label("" + p.get(i).getIdProduit());
                    Label qt = new Label("" + p.get(i).getNom());
                    Label lb2 = new Label("Prix :" + p.get(i).getPrix());
                    TextField nvr = new TextField();
                    // nvr.setUIID("1");
                    c5.add(lb);
                    c5.add(nvr);
                    c5.add(lb2);
                    c3.add(c4);
                    c3.add(c5);
                    panier.add(c3);
                }
                Button Commander = new Button("Commander");
                Button VoirCommande = new Button("Voir Commande");
                VoirCommande.setVisible(false);
                panier.add(Commander);
                panier.add(VoirCommande);
                 Commander.addActionListener(e-> {
                new ListProduitsForm(res).show();        
                    });
                f.show();
            }
         });
        
         f.add(panier);
     
          // c1.add(affiche);
          
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");



        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(2, listecom, produits),
                FlowLayout.encloseBottom(arrow)
        ));

        produits.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(produits, arrow);
        });
       
        bindButtonSelection(listecom, arrow);
        bindButtonSelection(produits, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
        
      
        //Appel affichage methode
        ArrayList<Produit>list = ServiceProduit.getInstance().AfficherProduits();
             
        
        for(Produit rec : list ) {
          
             String urlImage = "http://localhost/HabHub-Website/public/FrontOffice/uploads/"+rec.getImage();//image statique pour le moment ba3d taw fi  videos jayin nwarikom image 
            
             Image placeHolder = Image.createImage(120, 90);
             EncodedImage enc =  EncodedImage.createFromImage(placeHolder,false);
             URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
             
                addButton(urlim,rec,res);
        
                ScaleImageLabel image = new ScaleImageLabel(urlim);
                
                Container containerImg = new Container();
                
                image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        }
        
        
         
    }
    
    

    
    
    
    
    
       private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        
        if(image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
        
        
        
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2 ) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Label overLay = new Label("","ImageOverlay");
        
        
        Container page1 = 
                LayeredLayout.encloseIn(
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
    
    
    
    public void bindButtonSelection(Button btn , Label l ) {
        
        btn.addActionListener(e-> {
        if(btn.isSelected()) {
            updateArrowPosition(btn,l);
        }
    });
    }

    private void updateArrowPosition(Button btn, Label l) {
        
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
        l.getParent().repaint();
    }

        
    private void addButton(Image img,Produit rec , Resources res) {
        
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
        
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        
        
        //kif nzidouh  ly3endo date mathbih fi codenamone y3adih string w y5alih f symfony dateTime w ytab3ni cha3mlt taw yjih
        Label objetTxt = new Label("Name : "+rec.getNom(),"NewsTopLine2");
        Label dateTxt = new Label("Description : "+rec.getDescription(),"NewsTopLine2");
        Label etatTxt = new Label("Price : "+rec.getPrix(),"NewsTopLine2" );
        Label marqueTxt = new Label("marque : "+rec.getMarque(),"NewsTopLine2" );
        
        createLineSeparator();
        
       
       
        
        //supprimer button
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprmierStyle = new Style(lSupprimer.getUnselectedStyle());
        supprmierStyle.setFgColor(0xf21f1f);
        
        FontImage suprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprmierStyle);
        //lSupprimer.setIcon(suprrimerImage);
        lSupprimer.setTextPosition(RIGHT);
        
        
        
        //click delete icon
        lSupprimer.addPointerPressedListener(l -> {
            
            Dialog dig = new Dialog("Suppression");
            
            if(dig.show("Suppression","Vous voulez supprimer ce reclamation ?","Annuler","Oui")) {
                dig.dispose();
            }
            else {
                dig.dispose();
                 }
                //n3ayto l suuprimer men service Reclamation
                if(ServiceProduit.getInstance().deleteProduit(rec.getIdProduit())) {
                    new ListProduitsForm(res).show();
                }
           
        });
                
        //Update icon 
        Label lModifier = new Label(" ");
        lModifier.setUIID("NewsTopLine");
        Style modifierStyle = new Style(lModifier.getUnselectedStyle());
        modifierStyle.setFgColor(0xf7ad02);
        
        FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        //lModifier.setIcon(mFontImage);
        lModifier.setTextPosition(LEFT);
        
        
        Form hi = new Form("Button");
        Button ap = new Button("Buy");
        hi.add(ap);
        ap.addActionListener((e) -> Log.p("Clicked"));
        
        
       /** lModifier.addPointerPressedListener(l -> {
            //System.out.println("hello update");
            new ModifierReclamationForm(res,rec).show();
        });*/
       
      
        ap.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    // ap.setUIID("true");

                    if (p.isEmpty()) {
                        p.add(rec);
                        Dialog d = new Dialog("Produit Ajoute Avec succés");

                        TextArea popupBody = new TextArea("Produit Ajoute Avec succés");
                        popupBody.setUIID("PopupBody");
                        popupBody.setEditable(true);
                        d.setLayout(new BorderLayout());
                        d.add(BorderLayout.CENTER, popupBody);
                        d.show("Panier", "Produit Ajoute Avec succés", "OK", null);

                        System.out.println("ajouta" + rec.getIdProduit());
                    } else {
                        int occ = 0;
                        for (int i = 0; i < p.size(); i++) {
                            if (p.get(i).getIdProduit() == rec.getIdProduit()) {
                                occ++;
                            }
                        }
                        if (occ == 0) {
                            p.add(rec);
                            System.out.println("tawaajouta " + rec.getIdProduit());
                            Dialog d = new Dialog("Produit Ajoute Avec succés");

                            TextArea popupBody = new TextArea("Produit Ajoute Avec succés");
                            popupBody.setUIID("PopupBody");
                            popupBody.setEditable(true);
                            d.setLayout(new BorderLayout());
                            d.add(BorderLayout.CENTER, popupBody);
                            d.show("Panier", "Produit Ajoute Avec succés", "OK", null);
                        }

                    }

                }

            });
        
        
        
        /*
        
         Button affiche = new Button("Afficher Panier");
           Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
          // c1.add(affiche);
           Container panier = new Container(new BoxLayout(BoxLayout.Y_AXIS));
          
        
         affiche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                for (int i = 0; i < p.size(); i++) {
                    Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container c4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    ImageViewer image = new ImageViewer();
                    Image placeholder = Image.createImage(100, 100, 0xbfc9d2);
                    EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
                    Image img = URLImage.createToStorage(encImage, p.get(i).getImage(), "http://localhost/HabHub-Website/public/FrontOffice/uploads/" + p.get(i).getImage(), URLImage.RESIZE_SCALE);
                    image.setImage(img);
                    img.getWidth();
                    c4.add(image);
                    Container c5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Label lb = new Label(p.get(i).getNom());
                    Label lb3 = new Label("" + p.get(i).getIdProduit());
                    Label qt = new Label("" + p.get(i).getNom());
                    Label lb2 = new Label("Prix :" + p.get(i).getPrix());
                    TextField nvr = new TextField();
                    // nvr.setUIID("1");
                    c5.add(lb);
                    c5.add(nvr);
                    c5.add(lb2);
                    c3.add(c4);
                    c3.add(c5);
                    panier.add(c3);
                }
                Button Commander = new Button("Commander");
                Button VoirCommande = new Button("Voir Commande");
                VoirCommande.setVisible(false);
                panier.add(Commander);
                panier.add(VoirCommande);

                
            }
         });*/
        cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
                
                BoxLayout.encloseX(objetTxt),
                BoxLayout.encloseX(dateTxt),
                BoxLayout.encloseX(etatTxt,lModifier,lSupprimer,hi)));
        
        
        
        add(cnt);
              
    }
                     
         }
                 

    

