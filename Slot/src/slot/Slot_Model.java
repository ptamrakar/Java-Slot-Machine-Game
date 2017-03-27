package slot;

/**
 *
 * @author Pravesh
 */
public class Slot_Model {
    
    private int Credit;
    private int bet;
    private int increment;
    private int[] slot=new int[3];
    private int win;
    
    Slot_Model()
    {
        Credit=1000;
        bet=0;
        increment=50;
        for (int i=0;i<3;i++)
        {
            slot[i]=0;
        }
       
    }
    
 
    public void set_Credit(int a)
    {
        Credit+=a;
    }
    
    public void dec_bet()
    {
        if(bet>0 && (bet-increment)>=0)
        {
            bet-=increment;
            Credit+=increment;
        }
    }
    
    public void inc_bet()
    {
        if(Credit>0)
        {
            bet+=increment;
            Credit-=increment;
        }
    }

    public int get_Credit()
    {
        return Credit;
    }

    public int get_bet()
    {
        return bet;
    }
    
    public void max_bet()
    {
        bet=Credit+bet;
        Credit=0;
    }
    
    public void loosebet()
    {
        bet=0;
    }
    
    public void set_slot(int a,int b, int c)
    {
        slot[0]=a;
        slot[1]=b;
        slot[2]=c;
    }
    public int get_slot(int i)
    {
        return slot[i];
    }
    
    public int get_win()
    {
        return win;
    }
    
    public void set_win(int i)
    {
        win=i;
        Credit+=win;
    }
    
}




