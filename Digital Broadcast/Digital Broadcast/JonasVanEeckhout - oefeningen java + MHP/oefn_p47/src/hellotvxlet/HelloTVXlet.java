package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener {
  
    
    MijnComponent mc;
    int X;
    int Y;
            
    public HelloTVXlet() {
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
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
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        
        mc = new MijnComponent("spaceship.png",0,0);
        
        scene.add(mc);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        System.out.println("XLET gestart");
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository ("Voorbeeld");
        
        repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
    }
    
    public void userEventReceived(org.dvb.event.UserEvent e)
    {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed button");
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    Y -= 10;
                    mc.Verplaats(X,Y);
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    Y += 10;
                    mc.Verplaats(X,Y);
                    break;
                case HRcEvent.VK_LEFT:
                    X -= 10;
                    mc.Verplaats(X,Y);
                    break;
                case HRcEvent.VK_RIGHT:
                    X += 10;
                    mc.Verplaats(X,Y);
                    break;
            }
        }
    }

    public void actionPerformed(ActionEvent arg0) {
       
    }
}