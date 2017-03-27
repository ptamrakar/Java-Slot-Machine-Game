package slot;


import java.awt.*;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pravesh
 */
public class Slot_GUI {

    Slot_Model mod=new Slot_Model();    
    GUI_Raw gui=new GUI_Raw(this);
    
    
    Slot_GUI(Slot_Model mod_p)
    {
        mod=mod_p;
        init_gui();
    }
    
    public void init_gui()
    {
	gui.setTitle("Slots");
	gui.setLocationRelativeTo(null);
	gui.setSize(400,400);
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setResizable(false);
	gui.setVisible(true);
    }
        
    
    public void statechange(int a)
            
    {
        if (a==1)
            {mod.dec_bet();}
        
        if (a==2)
            {mod.inc_bet();}
        
        if (a==3)
            {spin();}
        
        if (a==4)
            {mod.max_bet();}
        
        if (a==5)
            {mod.set_Credit(gui.betInput);}

        gui.update();
    }
    
    private void spin()
    {

        if(mod.get_bet()>0)
        {   

            mod.set_slot(randInt(0,11), randInt(0,11), randInt(0,11));
            
            if (mod.get_slot(0)==mod.get_slot(1) && mod.get_slot(1)==mod.get_slot(2))
            {
                    mod.set_win(10*mod.get_bet()*mod.get_slot(0));
                    gui.set_Reel(); 
                    gui.showwin();
            }
            else if(mod.get_slot(0)==mod.get_slot(1) || mod.get_slot(1)==mod.get_slot(2) )
            {
                    mod.set_win(mod.get_bet()*mod.get_slot(0));
                    gui.set_Reel();
                    gui.showwin();
            }
            else
            {
                gui.set_Reel();
                mod.loosebet();
            }
            mod.loosebet();
        }
        else if(mod.get_Credit()==0)
        {
            gui.showmessage("You are out of Credit. Please Purchase more Credit");    
        }
        else 
        {
            gui.showmessage("You need to enter bet greater than Zero");
        }
        gui.update();
        
    }
    
    public static int randInt(int min, int max) 
    {
        Random rand = new Random();    
        return rand.nextInt(max - min + 1) + min;
    }
    

}
