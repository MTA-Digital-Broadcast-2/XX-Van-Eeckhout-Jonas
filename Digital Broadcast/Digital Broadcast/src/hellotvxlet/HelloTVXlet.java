package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.awt.*;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet
{
    
    private HScene scene;
    private XletContext actueleXletContext;
    
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1, knop2, knop3, knop4;
    
    
    public HelloTVXlet()
    {
        
    }

    public void initXlet(XletContext context)
    {
      
        if(debug) System.out.println("Xlet Initialiseren");
        this.actueleXletContext = context;
        
        //Het template maken
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        //Grootte en positie ingeven
        sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION,
            new HScreenDimension(1.0f, 1.0f),
            org.havi.ui.HSceneTemplate.REQUIRED); 
    
        sceneTemplate.setPreference(
            org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
            new HScreenPoint(0.0f, 0.0f),
            org.havi.ui.HSceneTemplate.REQUIRED);
        
        //Een instantie van een Scene vragen aan de factory
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        
            knop1 = new HTextButton("KNOP X");
            knop1.setLocation(100, 100);
            knop1.setSize(100, 50);
            knop1.setBackground(new DVBColor(0, 0, 0, 179));
            knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop1);
        knop1.setFocusTraversal(knop4, knop2, null, null);
        knop1.setActionCommand("knop1_actioned");
        knop1.addHActionListener((HActionListener) this);
        knop1.requestFocus();
        
            knop2 = new HTextButton("KNOP 2");
            knop2.setLocation(100, 200);
            knop2.setSize(100, 50);
            knop2.setBackground(new DVBColor(0, 0, 0, 179));
            knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop2);
        knop2.setFocusTraversal(knop1, knop3, null, null);
        knop2.setActionCommand("knop2_actioned");
        knop2.addHActionListener((HActionListener) this);
        knop2.requestFocus();
        
            knop3 = new HTextButton("KNOP 3");
            knop3.setLocation(100, 300);
            knop3.setSize(100, 50);
            knop3.setBackground(new DVBColor(0, 0, 0, 179));
            knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop3);
        knop3.setFocusTraversal(knop2, knop4, null, null);
        knop3.setActionCommand("knop3_actioned");
        knop3.addHActionListener((HActionListener) this);
        
            knop4 = new HTextButton("KNOP 4");
            knop4.setLocation(100, 400);
            knop4.setSize(100, 50);
            knop4.setBackground(new DVBColor(0, 0, 0, 179));
            knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop4);
        knop4.setFocusTraversal(knop3, knop1, null, null);
        knop4.setActionCommand("knop4_actioned");
        knop4.addHActionListener((HActionListener) this);
        
        
        tekstLabel = new HStaticText("TEKST");
        
        tekstLabel.setLocation(100, 100);
        tekstLabel.setSize(400, 250);
        tekstLabel.setBackground(new DVBColor(255, 255, 255, 179));
        tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(tekstLabel);
       
    }

    public void startXlet() throws XletStateChangeException
    {
        if(debug) System.out.println("Xlet Starten");
        
        //Scene zichtbaar maken
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet()
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
     
    }
}
