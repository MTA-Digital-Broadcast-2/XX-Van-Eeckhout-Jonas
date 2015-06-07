package hellotvxlet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg1 = new HBackgroundImage("pizza1.jpg");
    private HBackgroundImage agrondimg2 = new HBackgroundImage("pizza2.jpg");
    private HBackgroundImage agrondimg3 = new HBackgroundImage("pizza3.jpg");
    private HBackgroundImage agrondimg4 = new HBackgroundImage("pizza4.jpg");
    
    HScene scene = HSceneFactory.getInstance().getDefaultHScene();
    public int counter = 1;
    public void notifyRelease(ResourceProxy proxy){};
    public void release(ResourceProxy proxy){};
    public boolean requestRelease(ResourceProxy proxy, Object requestData){return false;}
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        System.out.println("destroyXlet");
        agrondimg1.flush();
        agrondimg2.flush();
        agrondimg3.flush();
        agrondimg4.flush();
    }

    public class MijnComponent extends HComponent {
    
    public String text = "Uw keuze: ";
    
    public MijnComponent(int X, int Y, int H, int W, String text)
    {
        System.out.println("Mijncomponent");
        this.setBounds(X,Y,H,W);
        this.text = text;
    } 
    

    public void paint(Graphics g)
    {
        System.out.println("paint");
        g.setColor(new DVBColor(255,255,255,255));
        g.drawString( text, 10, 20);
    }

}
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        screen = HScreen.getDefaultHScreen();
        MijnComponent mc = new MijnComponent(400,30,200,200, "Uw keuze:");
        
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
        
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        if(bgDevice.reserveDevice(this))
        {
            System.out.println("BackgroundImage device has been reserverd");
        }
        else
        {
            System.out.println("Background image device cannot be reserved");
        }
        
        bgTemplate = new HBackgroundConfigTemplate();
        
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        
        try{
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(java.lang.Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void pauseXlet() {
        System.out.println("PauseXlet");
    }

    public void startXlet() throws XletStateChangeException {
       System.out.println("Start XLET");
       agrondimg1.load(this);
       agrondimg2.load(this);
       agrondimg3.load(this);
       agrondimg4.load(this);
       
       EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository ("Voorbeeld");
        
        repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_ENTER);
        
        
        manager.addUserEventListener(this, repository);
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try{
            bgConfiguration.displayImage(agrondimg1);
        }
        catch(Exception s)
        {
            System.out.println(s.toString());
        }
    }
    
    public void changeImage(int counter)
    {
        String image = "agrondimg" + counter;
  
        if(image.equals("agrondimg1"))
        {
            try{
            bgConfiguration.displayImage(agrondimg1);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("agrondimg2"))
        {
            try{
            bgConfiguration.displayImage(agrondimg2);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("agrondimg3"))
        {
            try{
            bgConfiguration.displayImage(agrondimg3);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("agrondimg4"))
        {
            try{
            bgConfiguration.displayImage(agrondimg4);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
    }
    
    public void choosePizza(int number)
    {
        scene.repaint();
        if(number == 1)
        {
            MijnComponent keuze = new MijnComponent(400,60,200,200, "Meat Lover's");
            scene.add(keuze);
        }
        if(number == 2)
        {
            MijnComponent keuze = new MijnComponent(400,80,200,200, "Pepperoni Lover's");
            scene.add(keuze);
        }
        if(number == 3)
        {
            MijnComponent keuze = new MijnComponent(400,100,200,200, "Cheese Lover's");
            scene.add(keuze);
        }
        if(number == 4)
        {
            MijnComponent keuze = new MijnComponent(400,120,200,200, "Veggi Lover's");
            scene.add(keuze);
        }
        
        
            scene.validate();
            scene.setVisible(true);
            scene.repaint();
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden");
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed button");
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    counter++;
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    counter--;
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("VK_LEFT PRESSED");
                    counter--;
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT PRESSED");
                    counter++;
                    break;
                case HRcEvent.VK_ENTER:
                    System.out.println("VK_ENTER PRESSED");
                    choosePizza(counter);
                break;
            }
            
            if(counter > 4)
            {
                counter = 1;
            }
            if(counter < 1)
            {
                counter = 4;
            }
            
            
            changeImage(counter);
            System.out.println(counter);
        }
    }
  
    
    
}