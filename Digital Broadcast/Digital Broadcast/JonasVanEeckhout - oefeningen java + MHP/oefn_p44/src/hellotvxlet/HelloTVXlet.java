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
    
    public HelloTVXlet()
    {
    }
    
    public class MijnComponent extends HComponent
    {
        public MijnComponent(int x,int y,int width,int height)
        {
            this.setBounds(0, 0, 100, 100);
            this.setLocation(x, y);
            this.setSize(width, height);
        }
        
        public void paint(Graphics g)
        {
            //g.setColor(new DVBColor(200,100,100,179));
            //g.fillRect(0,0,100,100);
            g.setColor(new DVBColor(0,0,255,255));
            g.fillRoundRect(0, 0, 250, 80, 10, 10);
            g.setColor(new DVBColor(0,0,92,100));
            g.fillRoundRect(10, 10, 250, 80, 10, 10);
            g.setColor(Color.yellow);
            g.drawString("Oefening", 15, 20);
        }
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
        
        MijnComponent mc = new MijnComponent(50,50,100,100);
        scene.add(mc);
        
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
    }
}
