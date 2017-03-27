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
public class Reel {
   
    private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
      
    Reel ()
    {
        load_reel_image();
    }
      
    private void load_reel_image()
    {
                images.add(LoadIcon("images/Banana.png", "Banana"));
                images.add(LoadIcon("images/Bar.png", "Bar"));
                images.add(LoadIcon("images/Bell.png", "Bell"));
		images.add(LoadIcon("images/Cherry.png", "Cherry"));
		images.add(LoadIcon("images/Clover.png", "Clover"));
                images.add(LoadIcon("images/Coin.png", "Coin"));
                images.add(LoadIcon("images/Diamond.png", "Diamond"));
                images.add(LoadIcon("images/Gold.png", "Gold"));
                images.add(LoadIcon("images/Money.png", "Money"));
                images.add(LoadIcon("images/Plum.png", "Plum"));
                images.add(LoadIcon("images/Seven.png", "Seven"));
                images.add(LoadIcon("images/Watermelon.png", "Watermelon"));
    }
    
    public ImageIcon LoadIcon(String path, String description) 
    {
	java.net.URL imgURL = getClass().getResource(path);
	if (imgURL != null) 
        {
        	return new ImageIcon(imgURL, description);
	} 
        else 
        {
		System.err.println("File not Found " + path);
		return null;
        }
    }

    public ImageIcon get(int i)
    {   
        return images.get(i);
    }


}

