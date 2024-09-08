
/**
 * Saving account class.
 *
 */
public class Saving extends Account
{
    // instance variables 
    private static final float eachTimeCharge = 3.9f;
    /**
     * Constructor for objects of class Saving
     */
    public Saving()
    {
        // initialize instance variables
        
    }
    public Saving(String user)
    {
        super(user);
        
    }
    /**
     * Withdraw amount of money
     *
     * @param  m - the amount to withdraw
     */
    public void withdraw(float m)
    {
        // 
        if (balance < m)
           { System.out.println("The balance is insufficient!");return;}
        balance = balance -m - eachTimeCharge;
    }
}
