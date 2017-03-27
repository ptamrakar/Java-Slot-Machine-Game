package slot;

/**
 *
 * @author Pravesh
 */
public class Slot_Controller implements Runnable{

    private Slot_GUI s_GUI;
    private Slot_Model s_Model;
    
    Slot_Controller()
    {
        
    }
            
    Slot_Controller(Slot_GUI s_GUI,Slot_Model s_Model)
    {
        this.s_GUI=s_GUI;
        this.s_Model=s_Model;
    }
    

          
    
  
    public void run() 
    {
        
        while(true)
        {
            //System.out.println("Hello from a thread!");
        }
    }
    

    
    
}
