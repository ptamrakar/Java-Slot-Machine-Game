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


/**
 *
 * @author Pravesh
 */
public class Slot {
    
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Slot_Model s_Model= new Slot_Model();
        Slot_GUI s_GUI=new Slot_GUI(s_Model);
        


        //Slot_Controller s_Controller= new Slot_Controller();
        //Thread Thread1=new Thread(s_Controller);
        //Thread1.start();
    }
    
}
