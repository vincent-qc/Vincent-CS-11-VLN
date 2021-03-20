import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CustomerTests {
    Deposit dTest;
    Withdraw wTest;
    double amt;
    Date date;
    Customer customer;

    @Before
    public void setup(){
        Random r = new Random();

        amt = r.nextInt(99);
        date = new Date();
        customer = new Customer("Joe", 100);
    }


    // Checking

    @Test
    public void testDepositOnceChecking() {
        assertEquals(amt, customer.deposit(amt, date, Customer.CHECKING), 0);
    }

    @Test
    public void testDepositTwiceChecking() {
        customer.deposit(amt, date, Customer.CHECKING);
        assertEquals(amt * 2, customer.deposit(amt, date, Customer.CHECKING), 0);
    }

    @Test
    public void testWithdrawOnceChecking() {
        assertEquals(-amt, customer.withdraw(amt, date, Customer.CHECKING), 0);
    }

    @Test
    public void testWithdrawTwiceChecking() {
        customer.deposit(amt, date, Customer.CHECKING);
        assertEquals(0, customer.withdraw(amt, date, Customer.CHECKING), 0);
        assertEquals(-amt, customer.withdraw(amt, date, Customer.CHECKING), 0);
    }

    @Test
    public void testOverdraftChecking() {
        assertEquals(customer.getCheckBalance(), customer.withdraw(amt * 1000, date, Customer.CHECKING), 0);
    }


    // Saving

    @Test
    public void testDepositOnceSaving() {
        assertEquals(amt, customer.deposit(amt, date, Customer.SAVING), 0);
    }

    @Test
    public void testDepositTwiceSaving() {
        customer.deposit(amt, date, Customer.SAVING);
        assertEquals(amt * 2, customer.deposit(amt, date, Customer.SAVING), 0);
    }

    @Test
    public void testWithdrawOnceSaving() {
        assertEquals(-amt, customer.withdraw(amt, date, Customer.SAVING), 0);
    }

    @Test
    public void testWithdrawTwiceSaving() {
        customer.deposit(amt, date, Customer.SAVING);
        assertEquals(0, customer.withdraw(amt, date, Customer.SAVING), 0);
        assertEquals(-amt, customer.withdraw(amt, date, Customer.SAVING), 0);
    }

    @Test
    public void testOverdraftSaving() {
        assertEquals(customer.getSavingBalance(), customer.withdraw(amt * 1000, date, Customer.SAVING), 0);
    }
}
