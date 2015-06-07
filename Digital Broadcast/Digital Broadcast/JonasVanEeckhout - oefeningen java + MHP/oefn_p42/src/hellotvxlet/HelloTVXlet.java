package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.awt.*;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener
{
    private XletContext actueleXletContext;
    private HScene scene; //scene
    
    private boolean debug=true;
    
    private HStaticText text1;
    private HTextButton knop1,knop2,knop3,knop4,knop5;
    
    public HelloTVXlet()
    {
    }

    public void initXlet(XletContext context)
    {
        if(debug) System.out.println("Xlet initialiseren");
        this.actueleXletContext=context;
        
        HSceneTemplate sceneTemplate=new HSceneTemplate();
        
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
        
        text1 = new HStaticText("Wie wordt multimiljonair?");
            text1.setLocation(100,0);
            text1.setSize(400, 50);
            text1.setBackground(new DVBColor(0, 0, 0, 179));
            text1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
         scene.add(text1);   
            
         knop1 = new HTextButton("Jos");
            knop1.setLocation(100, 100);
            knop1.setSize(100, 50);
            knop1.setBackground(new DVBColor(0, 0, 0, 179));
            knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop1);
        //knop1.setActionCommand("knop1_actioned");
        //knop1.addHActionListener((HActionListener) this);
        //knop1.requestFocus();
        
         knop2 = new HTextButton("Jef");
            knop2.setLocation(100, 150);
            knop2.setSize(100, 50);
            knop2.setBackground(new DVBColor(0, 0, 0, 179));
            knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop2);
        
         knop3 = new HTextButton("Jacky");
            knop3.setLocation(100, 200);
            knop3.setSize(100, 50);
            knop3.setBackground(new DVBColor(0, 0, 0, 179));
            knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop3);
        
         knop4 = new HTextButton("Jan");
            knop4.setLocation(100, 250);
            knop4.setSize(100, 50);
            knop4.setBackground(new DVBColor(0, 0, 0, 179));
            knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop4);
        
            knop5 = new HTextButton("Hulplijn aanvragen");
            knop5.setLocation(100, 350);
            knop5.setSize(300, 50);
            knop5.setBackground(new DVBColor(0, 0, 0, 179));
            knop5.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(knop5);
        
        knop1.setFocusTraversal(null, knop2, null, null);
        knop2.setFocusTraversal(knop1, knop3, null, null);
        knop3.setFocusTraversal(knop2, knop4, null, null);
        knop4.setFocusTraversal(knop3, knop5, null, null);
        knop5.setFocusTraversal(knop4, null, null, null);
        
        knop1.setActionCommand("Dit antwoord is juist");
        knop2.setActionCommand("Dit antwoord is fout");
        knop3.setActionCommand("Dit antwoord is fout");
        knop4.setActionCommand("Dit antwoord is fout");
        knop5.setActionCommand("Antwoord 2 en 3 zijn beide fout");
        knop1.addHActionListener(this);
        knop2.addHActionListener(this);
        knop3.addHActionListener(this);
        knop4.addHActionListener(this);
        knop5.addHActionListener(this);
        
        
        knop1.requestFocus();
    }

    public void startXlet() throws XletStateChangeException
    {
        if(debug) System.out.println("Xlet Starten");
        
        
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet()
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
        if(unconditional){
            System.out.println("De Xlet moet beëindigd worden");
        }
        else{
            System.out.println("De mogelijkheid bestaat "+"door het werpen van een exceptie "+"de Xlet in leven te houden");
            throw new XletStateChangeException("Laat me leven!");
        }
        }

    public void actionPerformed(ActionEvent e)
    {
       System.out.println(e.getActionCommand());
       
       if(e.getActionCommand().equals("Dit antwoord is juist"))
       { 
            System.out.println("Juist antwoord!");
            knop1.setBackground(new DVBColor(0, 200, 100, 100));
            knop2.setBackground(new DVBColor(255, 0, 0, 255));
            knop3.setBackground(new DVBColor(255, 0, 0, 255));
            knop4.setBackground(new DVBColor(255, 0, 0, 255));
            scene.repaint();
       }
       else if(e.getActionCommand().equals("Antwoord 2 en 3 zijn beide fout"))
       {
           System.out.println("2 en 3 zijn fout!");
           knop1.setBackground(new DVBColor(255, 0, 0, 255));
           knop4.setBackground(new DVBColor(255, 0, 0, 255));
           scene.repaint();
       }
       else
       {
           knop1.setBackground(new DVBColor(0, 0, 0, 179));
           if(e.getActionCommand().equals("Dit antwoord is fout"))
           {
               knop2.setBackground(new DVBColor(255, 0, 0, 255));
           }
           if(e.getActionCommand().equals("Dit antwoord is fout"))
           {
               knop3.setBackground(new DVBColor(255, 0, 0, 255));
           }
           if(e.getActionCommand().equals("Dit antwoord is fout"))
           {
               knop4.setBackground(new DVBColor(255, 0, 0, 255));
           }
           scene.repaint();
           
           System.out.println("Fout antwoord!");
       }
    }
}
