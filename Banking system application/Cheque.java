
/**
 * Chequing account class.
 *
 */
public class Cheque extends Account
{
    // instance variables 
    private static final float minimBalance = 1000;
    private static final float overLimitCharge = 5;
    /**
     * Constructor for objects of class Cheque
     */
    public Cheque()
    {
        // initialise instance variables
        
    }
    public Cheque(String user)
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
        if (balance < minimBalance)
            balance = balance -m -overLimitCharge;
        else
            balance = balance -m;
    }
}
