import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.CheckedInputStream;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    /**
     * We cannot create a default customer constructor as every customer requires a name + account number
     *
     * @param name Their name
     * @param accountNumber The account number
     * @param checkDeposit
     * @param savingDeposit
     */
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public double deposit(double amt, Date date, String account) {
        this.deposits.add(new Deposit(amt, date, account));

        if(account.equals(CHECKING))
            checkBalance += amt;
        else
            savingBalance += amt;

        return (account.equals(CHECKING)) ? checkBalance : savingBalance;
    }

    public double withdraw(double amt, Date date, String account) {

        // Check for Overdraft
        if(checkOverdraft(amt, account)) return (account.equals(CHECKING)) ? checkBalance : savingBalance;

        this.withdraws.add(new Withdraw(amt, date, account));

        if(account.equals(CHECKING))
            checkBalance += amt;
        else
            savingBalance += amt;

        return (account.equals(CHECKING)) ? checkBalance : savingBalance;
    }

    private boolean checkOverdraft(double amt, String account){
        return ((account.equals(CHECKING)) ? checkBalance : savingBalance) - amt < OVERDRAFT;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}