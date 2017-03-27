package slot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Pravesh
 */
public class GUI_Raw extends JFrame{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Reel[] Rel=new Reel[3];
    Slot_GUI a;
    int betInput=0;
    
    
       
    private JPanel slotPanel=new JPanel (new GridLayout(1,3)); //holding 3 slots
    private JLabel[] slot=new JLabel[3]; //create three slots
	
    //money panel labels
    private JLabel amount;
    private JLabel betLabel;
    
	
    //game control panel buttons
    private JButton add50=new JButton("+50");
    private JButton spin=new JButton("Spin");
    private JButton maxbet=new JButton("Max");
    private JButton subtract50=new JButton("-50");
    private JButton setCredit=new JButton("Enter Credit");
    private JButton help=new JButton("Reset");
    
    public GUI_Raw(Slot_GUI a) { //constructor
        
        this.a=a;
        for (int i=0;i<Rel.length;i++) 
        {
            Rel[i]=new Reel();
        }
     
        //initial setup
        init_setup();
    }
    
    private void init_setup()
    {
        
        
        
        JPanel moneyPanel =new JPanel(new GridLayout(2,1));
	betLabel=new JLabel("Bet: $"+a.mod.get_bet());
        amount=new JLabel("Credit: $"+a.mod.get_Credit());
        moneyPanel.setBorder(new TitledBorder("Money"));
	moneyPanel.add(amount);
	moneyPanel.add(betLabel);
		
	JPanel buttonPanel=new JPanel(new GridLayout(2,2));
	JPanel buttonTopPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
	buttonPanel.setBorder(new TitledBorder("Buttons"));

        //add buttons to the panel
        buttonTopPanel.add(subtract50);
	buttonTopPanel.add(add50);
	buttonTopPanel.add(spin);
	buttonTopPanel.add(maxbet);
        
        
	JPanel buttonBottomPanel=new JPanel();
        JPanel buttonBottonPanel=new JPanel();
	buttonBottomPanel.add(setCredit);
        buttonBottonPanel.add(help);
	buttonPanel.add(buttonTopPanel,BorderLayout.NORTH);
	buttonPanel.add(buttonBottomPanel,BorderLayout.SOUTH);
		
	//set slots their first look
	slot[0]=new JLabel();
	slot[1]=new JLabel();
	slot[2]=new JLabel();
        
        
        slotPanel.setBorder(BorderFactory.createEtchedBorder());        
        slotPanel.setBackground(Color.yellow);
        moneyPanel.setBackground(Color.MAGENTA);
        buttonTopPanel.setBackground(Color.BLUE);
        
        slot[0].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        slot[0].setBackground(new Color(215, 115, 2));
        
        slot[1].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        slot[1].setBackground(new Color(215, 115, 1));

        slot[2].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        slot[2].setBackground(new Color(215, 115, 1));


        slot[0].setIcon(Rel[0].get(0));
        slot[1].setIcon(Rel[1].get(0));
        slot[2].setIcon(Rel[2].get(0));
	for (int i=0;i<3;i++) slotPanel.add(slot[i]);	
        
        JPanel bottomPanel=new JPanel(new BorderLayout());
	bottomPanel.add(moneyPanel,BorderLayout.NORTH);
	bottomPanel.add(buttonPanel,BorderLayout.SOUTH);
	
	JPanel all=new JPanel(new GridLayout(2,1));
	all.add(slotPanel);
	all.add(bottomPanel);
	add(all);

        //add listeners to buttons
        subtract50.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
            a.statechange(1);
            }
        });

        add50.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                a.statechange(2);
            }
        });
        
        spin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            a.statechange(3);
            }
        } );
		
	maxbet.addActionListener (new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                a.statechange(4);
            }
        } );		
	
	setCredit.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                String input;
                betInput=0;
                input=JOptionPane.showInputDialog(null,
                        "Enter the amount of money you want deposit","Enter Amount",
                        JOptionPane.QUESTION_MESSAGE);
                betInput=Integer.parseInt(input);
                a.statechange(5);
            }
        });	
    }
    
    public void update()
    {
        betLabel.setText("Bet: $"+a.mod.get_bet());
        amount.setText("Credit: $"+a.mod.get_Credit());
        set_Reel();
    }
    
    public void showwin()
    {
        JOptionPane.showMessageDialog(null,"Your bet: $"+a.mod.get_bet()+"\nYou win: $"+a.mod.get_win(),
                            "Three Matches",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showmessage(String message)
    {
        JOptionPane.showMessageDialog(null,message,"Alert",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void set_Reel()
    {
        slot[0].setIcon(Rel[0].get(a.mod.get_slot(0)));
        slot[1].setIcon(Rel[1].get(a.mod.get_slot(1)));
        slot[2].setIcon(Rel[2].get(a.mod.get_slot(2)));
    }

    public void init_Reel()    
    {
        for (int i=0;i<=2;i++)
        {
            Rel[i]=new Reel();
        }
    }
    public void buttontoggle(boolean i)
    {
        add50.setEnabled(i);
        spin.setEnabled(i);
        maxbet.setEnabled(i);
        subtract50.setEnabled(i);
        setCredit.setEnabled(i);
    }

}

