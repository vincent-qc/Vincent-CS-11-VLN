import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegerSetTests {
    IntegerSet testSet;

    @Before
    public void setup(){
        testSet = new IntegerSet();
    }

    @Test
    public void testInsertNotThere(){
        //check number is not already in set
        assertEquals(testSet.size(), 0);
        assertFalse(testSet.contains(3));
        //insert a number
        testSet.insert(3);
        //check the number is in the set
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));
    }

    @Test
    public void testInsertAlreadyThere(){
        // Note: I modified the file before I committed to git; I basically removed the size variable and changed it to intSet.size()

        // Insert a Number
        testSet.insert(3);

        // Check if size is 1 and that it contains the number we inserted
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));

        // Insert the number again
        testSet.insert(3);

        // Check the size did not increase and that it still contains the number we originally inserted
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));
    }
}