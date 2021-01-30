import java.lang.reflect.Array; // Import if using arraycopy()
import java.util.Arrays;

public class Main {

    /**
     * Main Method used for testing arrays
     * All other methods are generic (they can support any type of array)
     *
     * @param args Ignore
     */
    public static void main(String[] args) {
        String[] stringArray = {"Foo", "Bar", "Baz"};
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 6.6};

        // Test Cases
        System.out.println(Arrays.toString(pushEnd(stringArray, "Hello World")));
        System.out.println(Arrays.toString(popEnd(intArray)));
        System.out.println(Arrays.toString(insert(doubleArray, 5.5, 4)));
    }

    /**
     * Pushes a item to the end of the array
     *
     * @param array The array you want to push to
     * @param item The item you want to push
     * @param <T> The type of the array
     * @return Returns the array with the item pushed to the end
     */
    private static <T> T[] pushEnd(T[] array, T item) {
        // Creates a new array with Object type and +1 length
        Object[] newArray = new Object[array.length + 1];

        // Iterates through array and assigns all values of the previous array to the new one
        for(int i = 0; i < array.length; i++) {   // Can also be done with < System.arraycopy(array, 0, newArray, 0, array.length); >
            newArray[i] = array[i];
        }

        // Adds the item to the end of the array
        newArray[array.length] = item;

        return (T[]) newArray;
    }

    /**
     * Pops the item off the end of an array
     *
     * @param array The array to pop
     * @param <T> The type of the array
     * @return Returns the array with the last item popped
     */
    private static <T> T[] popEnd(T[] array) {

        // Checks it the array is empty
        if(array.length == 0) return null;

        // Creates a new array with Object type and -1 length
        Object[] newArray = new Object[array.length - 1];

        // Iterates through the array but ends before reaching the last item in the previous array
        for(int i = 0; i < newArray.length; i++) {   // Can also be done with < if (newArray.length >= 0) System.arraycopy(array, 0, newArray, 0, newArray.length); >
            newArray[i] = array[i];
        }

        return (T[]) newArray;
    }

    /**
     * Inserts an item to an array with an index
     *
     * @param array The array to insert to
     * @param item The item to insert
     * @param index The index to insert it at
     * @param <T> The type of the array
     * @return Returns the array with the item inserted
     */
    private static <T> T[] insert(T[] array, T item, int index) {

        // Creates a new array with Object type and +1 length
        Object[] newArray = new Object[array.length + 1];

        // Iterates through the array and checks if the index is equal to the insert index
        // If so, it inserts the item to that index
        for(int i = 0; i < array.length; i++) {   // Can also be done with < System.arraycopy(array, 0, newArray, 0, array.length); >
            if(i == index) newArray[i] = item;

            // Checks if the new array at position i is already filled.
            // If so, it inserts the previous array items to index i + 1
            newArray[(newArray[i] == null) ? i : i + 1] = array[i];
        }

        return (T[]) newArray;
    }
}
