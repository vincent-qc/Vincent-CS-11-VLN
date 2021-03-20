import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.CheckedInputStream;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    /**
     * We cannot create a default customer constructor as every customer requires a name + account number
     * We do not need a savingBalance or checkingBalance parameter because we are creating a new customer with $0
     *
     * @param name Their name
     * @param accountNumber The account number
     */
    Customer(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    /**
     * Requires: amt (Double), date (Date), account (String)
     * Modifies: Adds the deposit to this.deposits
     *           Adds amt to Balance
     * Effects: Returns Balance
     *
     * @param amt The amount to deposit
     * @param date The date
     * @param account The type of account
     * @return Balance (Double)
     */
    public double deposit(double amt, Date date, String account) {
        this.deposits.add(new Deposit(amt, date, account));

        if(account.equals(CHECKING))
            checkBalance += amt;
        else
            savingBalance += amt;

        return (account.equals(CHECKING)) ? checkBalance : savingBalance;
    }

    /**
     * Requires: amt (Double), date (Date), account (String)
     * Modifies: Adds the withdrawal to this.withdraws
     *           Subtracts the amt from Balance if checkOverdraft() returns false
     * Effects: Returns Balance
     *
     * @param amt The amount to withdraw
     * @param date The date
     * @param account The type of account
     * @return Balance (Double)
     */
    public double withdraw(double amt, Date date, String account) {

        // Check for Overdraft
        if(checkOverdraft(amt, account)) return (account.equals(CHECKING)) ? checkBalance : savingBalance;

        this.withdraws.add(new Withdraw(amt, date, account));

        if(account.equals(CHECKING))
            checkBalance -= amt;
        else
            savingBalance -= amt;

        return (account.equals(CHECKING)) ? checkBalance : savingBalance;
    }

    /**
     * Requires: amt (Double), account (String)
     * Modifies: none
     * Effects: returns true if Balance - Amount is smaller than OVERDRAFT
     *
     * @param amt The amount to withdraw
     * @param account The type of account
     * @return Balance - amt < OVERDRAFT (Boolean)
     */
    private boolean checkOverdraft(double amt, String account){
        return ((account.equals(CHECKING)) ? checkBalance : savingBalance) - amt < OVERDRAFT;
    }

    /**
     * Do Not Modify
     *
     * Prints all the deposits
     */
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    /**
     * Do Not Modify
     *
     * Prints all the withdrawals
     */
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    /**
     * Need this Getter for Overdraft Test (Checking)
     *
     * @return The Checking Balance
     */
    public double getCheckBalance() {
        return checkBalance;
    }

    /**
     * Need this Getter for Overdraft Test (Saving)
     *
     * @return The Saving Balance
     */
    public double getSavingBalance() {
        return savingBalance;
    }
}