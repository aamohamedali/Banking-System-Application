
/**
 * A common class for bank account which can be 
 * inherited into Cheque and Saving
 */
import java.util.Random;
import java.util.ArrayList;
public class Account
{
    // instance variables - replace the example below with your own
    private int accountNo;
    private String userName;    
    protected float balance;

    /**
     * Constructor for objects of class Account
     */
    public Account()//4
    {        
        // initialize instance variables
        Random rand = new Random();
        accountNo = Math.abs(rand.nextInt());
        userName = "";
        balance = 0;
    }
    
    public Account(String user)//3
    {        
        // initialize instance variables
        this();
        userName = user;
    }
    
    /**
     * Display account number and balance
     */
    public void display()//3
    {
        System.out.println("Account no: "+ accountNo);
        System.out.println("User name: "+ userName);
        System.out.println("Balance: "+ balance);        
    }
    
    /**
     * withdraw amount of money m
     *
     * @param  m - amount of money to withdraw
     */
    public void withdraw(float m)//2
    {
        if (balance> 0)
        {balance-=m;}
    }
    
    /**
     * deposit amount of money m
     *
     * @param  m - amount of money to deposit
     */
    public void deposit(float m)//3
    {
        // deposit
        balance = balance + m;
    }

    /**
     * returns the balance
     * @return  balance
     */
    public float getBalance()//2
    {
        return balance;
    }
    
    /**
     * returns the username
     * @return  username
     */
    public String getUsername() //2
    {
        return userName;
    }
    
    /**
     * returns the account number
     * @return  accountNo
     */    
    public int getAccountNo(){
        return accountNo;
    }
}
