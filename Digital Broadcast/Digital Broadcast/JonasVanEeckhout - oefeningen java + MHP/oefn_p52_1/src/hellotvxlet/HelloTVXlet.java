package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage bgImg1 = new HBackgroundImage("pizza1.jpg");
    private HBackgroundImage bgImg2 = new HBackgroundImage("pizza2.jpg");
    private HBackgroundImage bgImg3 = new HBackgroundImage("pizza3.jpg");
    private HBackgroundImage bgImg4 = new HBackgroundImage("pizza4.jpg");
    
    
    public int timer = 1;
    public void notifyRelease(ResourceProxy proxy){};
    public void release(ResourceProxy proxy){};
    public boolean requestRelease(ResourceProxy proxy, Object requestData){return false;}
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        System.out.println("destroyXlet");
        bgImg1.flush();
        bgImg2.flush();
        bgImg3.flush();
        bgImg4.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        screen = HScreen.getDefaultHScreen();
        
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
       bgImg1.load(this);
       bgImg2.load(this);
       bgImg3.load(this);
       bgImg4.load(this);
       
       EventManager manager = EventManager.getInstance();
        
        UserEventRepository repository = new UserEventRepository ("Voorbeeld");
        
        repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try{
            bgConfiguration.displayImage(bgImg1);
        }
        catch(Exception s)
        {
            System.out.println(s.toString());
        }
    }
    
    public void changeImage(int timer)
    {
        String image = "bgImg" + timer;
  
        if(image.equals("bgImg1"))
        {
            try{
            bgConfiguration.displayImage(bgImg1);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bgImg2"))
        {
            try{
            bgConfiguration.displayImage(bgImg2);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bgImg3"))
        {
            try{
            bgConfiguration.displayImage(bgImg3);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
        if(image.equals("bgImg4"))
        {
            try{
            bgConfiguration.displayImage(bgImg4);
            }
            catch(Exception s)
            {
                System.out.println(s.toString());
            }
        }
        
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
                    timer++;
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN PRESSED");
                    timer--;
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("VK_LEFT PRESSED");
                    timer--;
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT PRESSED");
                    timer++;
                    break;
            }
            
            if(timer > 4)
            {
                timer = 1;
            }
            if(timer < 1)
            {
                timer = 4;
            }
            
            
            changeImage(timer);
            System.out.println(timer);
        }
    }
  
    
    
}