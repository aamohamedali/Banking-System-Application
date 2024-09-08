/**
 * The ATM class - An ATM interface.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ATM
{
    private Bank bank;
    private String user;
    private JFrame frame;
    /**
     * Constructor for objects of class ATM
     */
    public ATM(String user)
    {
        this.user = user;
        createBankInfor();
        makeFrame();        
    }
    
    private void createBankInfor(){
        //test example
        bank = new Bank("Canada");
        bank.add(new Saving(user));
        bank.add(new Saving(user));
        bank.add(new Cheque(user));
        bank.add(new Cheque(user));
    }
    
    /**
     * Create the frame     
     */
    private void makeFrame()
    { 
        frame = new JFrame("ATM");
        Container contentPane = frame.getContentPane();        
        makeMenuBar(frame);        
        listAccounts();        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;        
        // create the Account menu
        menu = new JMenu("Accounts");
        menubar.add(menu);
        item = new JMenuItem("All Accounts...");
        item.addActionListener(e -> listAccounts());
        menu.add(item);
        
        JMenuItem cheq=new JMenuItem("Checking");
        menu.add(cheq);
        cheq.addActionListener(e->listAccounts("Cheque"));
                
        JMenuItem sav=new JMenuItem("Saving");
        menu.add(sav);
        sav.addActionListener(e->listAccounts("Saving"));
        
        
        
                
        // the Help menu
        menu = new JMenu("Help");
        menubar.add(menu);  
        item = new JMenuItem("About...");
        item.addActionListener(e -> about());
        menu.add(item);        
        item = new JMenuItem("Exit...");
        menu.add(item);  
        item.addActionListener(e -> System.exit(0));

    }
    
    private void listAccounts(String accType)   
    {
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();

        contentPane.setLayout(new GridLayout(0,6)); 
        for(Account acc:bank.getAccounts(user)){
            if (!accType.equals(acc.getClass().getName())){
                continue;
            }
            drawAccount(acc);
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    private void listAccounts()   
    {
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();

        contentPane.setLayout(new GridLayout(0,6));
        for(Account acc:bank.getAccounts(user)){
            drawAccount(acc);
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    /*
     *  each account on the panel
     */
    private void drawAccount(Account acc){
        Container contentPane = frame.getContentPane();        
        JLabel label1 = new JLabel(acc.getClass().getName());        
        contentPane.add(label1);
        
   
        JLabel label0=new JLabel("Account: "+String.valueOf(acc.getAccountNo()));
        contentPane.add(label0);
        
        
        
        JLabel label3 = new JLabel("Balance: ");
        contentPane.add(label3);

        JTextField tf1 = new JTextField(Float.toString(acc.getBalance()));        
        contentPane.add(tf1);
        tf1.setEditable(false);

        
       
        // Deposit button and its listener
        JButton bDeposit = new JButton("Deposit");
        contentPane.add(bDeposit);
        // event listener to the button, to pop up a dialog taking input
        bDeposit.addActionListener(
            ev->{String s = JOptionPane.showInputDialog("Input money: ",0);
                acc.deposit(s==null?0:Float.parseFloat(s));
                tf1.setText(Float.toString(acc.getBalance()));});
        // Withdraw button and its listener
        //your code goes here ...
        JButton bWithdraw = new JButton("Withdraw");
        contentPane.add(bWithdraw);
        // event listener to the button, to pop up a dialog taking input
        bWithdraw.addActionListener(
            ev->{String s = JOptionPane.showInputDialog("Input money: ",0);
                if(s!=null)
                {
                    if (!s.equals("0")  )
                    {
                        acc.withdraw(Float.parseFloat(s));
                        tf1.setText(Float.toString(acc.getBalance()));
                    }
                };
        });
        
        
    }

    private void about(){
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        JLabel label1 = new JLabel(user + "@" +bank.getBankName());
        contentPane.add(label1);
        frame.pack();
        frame.setVisible(true);
    }    
}
