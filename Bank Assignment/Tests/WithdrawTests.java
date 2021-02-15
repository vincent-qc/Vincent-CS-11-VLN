import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Random;

public class WithdrawTests {
    Withdraw wTest;
    double amt;
    Date date;
    String account;
    Random r;

    @Before
    public void setup() {
        r = new Random();
        amt = r.nextDouble() * 100;
        account = Customer.SAVING;
        date = new Date();

        wTest = new Withdraw(amt, date, account);
    }

    @Test
    public void testToString() {
        assertEquals(wTest.toString(), "Withdrawal of: $" + amt + " Date: " + date + " into Account: " + account);
    }
}
