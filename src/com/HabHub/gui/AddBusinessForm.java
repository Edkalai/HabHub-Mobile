/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HabHub.gui;

import com.HabHub.entities.Business;
import com.HabHub.services.ServiceBusiness;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;



/**
 *
 * @author ASUS
 */
public class AddBusinessForm extends BaseForm{

    Form current;
    public AddBusinessForm(Resources res ) {
        super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Salle");
        getContentPane().setScrollVisible(false);
        
        
        tb.addSearchCommand(e ->  {
            
        });
        
        Tabs swipe = new Tabs();
        
        Label s1 = new Label();
        Label s2 = new Label();
        
        addTab(swipe,s1,"","",res);
        
        //
        
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
        RadioButton mesListes = RadioButton.createToggle("All Businesses", barGroup);
        mesListes.setUIID("SelectBar");
        
        RadioButton liste = RadioButton.createToggle("Add", barGroup);
        liste.setUIID("SelectBar");
        
        
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
          BackBusinessForm a = new BackBusinessForm(res);
           a.show();
            refreshTheme();
        });
        
        liste.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
          AddBusinessForm a = new AddBusinessForm(res);
            a.show();
            refreshTheme();
        });
        
       
        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(2, mesListes, liste),
                FlowLayout.encloseBottom(arrow)
        ));

        liste.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

        
        //
        
        TextField titre = new TextField("", "Please add a title");
        titre.setUIID("TextFieldBlack");
        addStringValue("titre",titre);
        
        TextField description = new TextField("", "Please add a description");
        description.setUIID("TextFieldBlack");
        addStringValue("desciption",description);
        
        TextField horaire = new TextField("", "Please add opening hours");
        horaire.setUIID("TextFieldBlack");
        addStringValue("Horaires",horaire);
        
        TextField ville = new TextField("", "Please add a city");
        ville.setUIID("TextFieldBlack");
        addStringValue("City",ville);
        
        TextField type = new TextField("", "Please add business type");
        type.setUIID("TextFieldBlack");
        addStringValue("type",type);
        
       
        
        Button btnAjouter = new Button("Add");
        addStringValue("", btnAjouter);
        
        
        //onclick button event 

        btnAjouter.addActionListener((e) -> {
            
            
            try {
                
                if(
                         ville.getText().equals("")|| titre.getText().equals("")
                        ) {
                    Dialog.show("Please verify data","","Cancel", "OK");
                }
                
                else {
                    
                    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    
                    //njibo iduser men session (current user)
                    Business b = new Business(String.valueOf(titre.getText()),String.valueOf(description.getText())
                    ,String.valueOf(horaire.getText()).toString(),String.valueOf(ville.getText()).toString()
                            ,String.valueOf(type.getText()).toString()
                    );
                    
                    System.out.println("data  salle == "+b);
                    
                    
                    //appelle methode ajouterReclamation mt3 service Reclamation bch nzido données ta3na fi base 
                    ServiceBusiness.getInstance().AddBusiness(b);
                    
                    //iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                      new BackBusinessForm(res).show();                 
                    
                    refreshTheme();//Actualisation
                            
                }
                
            }catch(Exception ex ) {
                ex.printStackTrace();
            }
            
            
            
            
            
        });
        
        
    }

    private void addStringValue(String s, Component v) {
        
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        //add(createLineSeparator(0xeeeeee));
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
    
}

