package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener {
  
    
    MijnComponent mc;
    int X;
    int Y;
    private int sterreny;
    private MijnComponent sterren;
    private MijnComponent sterren2;
    private MijnComponent scene;
            
    public HelloTVXlet() {
        
    }
    
    public class MijnComponent extends HComponent {
    
    private Image bmap;
    private MediaTracker mtrack;
    
    
    
    public MijnComponent(String bitmapnaam, int x, int y)
    {
        bmap = this.getToolkit().getImage(bitmapnaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(bmap, 1);
        
        try
        {
            mtrack.waitForAll();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        this.setBounds(x, y, bmap.getWidth(null), bmap.getWidth(null));
    } 
    
    public void Verplaats(int x, int y)
    {
        this.setBounds(x, y, bmap.getWidth(this), bmap.getHeight(this));
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(bmap, 0,0,null);
    }

}

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene1 = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent("spaceship.png",300,300);
        sterren = new MijnComponent("sterren.png", 0, 0);
        sterren2 = new MijnComponent("sterren.png", 0, -569);
        
        scene1.add(mc);
        scene1.add(sterren);
        scene1.add(sterren2);
        scene1.popToFront(mc);
        
        scene1.validate();
        scene1.setVisible(true);
    }

    public void pauseXlet() {
        
    }
    
    public class MijnTimerTask extends TimerTask{
    HelloTVXlet xlet;
    
    public MijnTimerTask(HelloTVXlet xlet)
    {
        this.xlet = xlet;
    }
    
    public void run()
    {
        System.out.println("Tick");
        xlet.callback();
    }
}
    
    public void callback()
    {
        sterreny++;
        sterren.Verplaats(0, sterreny);
        sterren2.Verplaats(0, sterreny-569);
        if(sterreny > 569) sterreny -= 569;
    }

    public void startXlet() throws XletStateChangeException {
        MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(objMijnTimerTask, 0, 50);
        
        scene.validate();
        scene.setVisible(true);
    }
    
    public void userEventReceived(org.dvb.event.UserEvent e)
    {
        
    }

    public void actionPerformed(ActionEvent arg0) {
       
    }
}