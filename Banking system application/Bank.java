
/**
 * The Bank class.
 *
 */
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Bank
{
    // instance variables
    private String bankName;
    private ArrayList<Account> accounts; 
    /**
     * Constructor for objects of class Bank
     */
    public Bank()
    {
        accounts = new ArrayList<Account>();
    }
    public Bank(String name)
    {
        this();
        bankName = name;
    }
    /**
     *  account (saving or chequing) to accounts list
     */
    public void add(Account a)
    {
        accounts.add(a);
    }
    
    public ArrayList<Account> getAccounts(){
        return accounts;
    }
    
    public ArrayList<Account> getAccounts(String user){
        return new ArrayList<Account>(accounts.stream().
            filter(acc->user.equals(acc.getUsername())).
            collect(Collectors.toList()));
    }

    public String getBankName(){
        return bankName;
    }

    /**
     * Display the bank information and all accounts
     */
    public void display()
    {
        // Display the bank information and the full list of accounts
        System.out.println("Bank name: "+bankName);
        accounts.forEach(acc->{
            System.out.println(acc.getClass().getName() + acc.getUsername()+", Balance: "+acc.getBalance());
        });
    }
    
    /**
     * Display the bank information and accounts per user name
     */
    public void display(String user)
    {
        // Display the bank information and the list of accounts per user
        System.out.println("Bank name: "+bankName+ " for "+user);
        accounts.stream()
        .filter(acc -> acc.getUsername().equals(user))
        .forEach(acc->{
            System.out.println(acc.getClass().getName() + acc.getUsername()+", Balance: "+acc.getBalance());
        });
    }
}
