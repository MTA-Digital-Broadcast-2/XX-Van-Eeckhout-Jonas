package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

/**
 * Just a simple xlet that draws a String in the center of the screen.
 */
public class HelloTVXlet implements Xlet {

    private XletContext actueleXletContext;
    /** Creates a new instance of HelloTVXlet */
    public HelloTVXlet() {
    }

    public void initXlet(XletContext context) {
        this.actueleXletContext=context;
    }

    public void startXlet() throws XletStateChangeException 
    {

    }

    public void pauseXlet() {

    }

    public void destroyXlet(boolean unconditional) 
            throws XletStateChangeException
    {
        if(unconditional){
            System.out.println("De Xlet moet beëindigd worden");
        }
        else{
            System.out.println("De mogelijkheid bestaat "+"door het werpen van een exceptie "+"de Xlet in leven te houden. ");
            throw new XletStateChangeException("Laat me leven");
        }
    }
}
