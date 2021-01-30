import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"Foo", "Bar", "Baz"};
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 6.6};

        // Test Cases
        System.out.println(Arrays.toString(pushEnd(stringArray, "Hello World")));
        System.out.println(Arrays.toString(popEnd(intArray)));
        System.out.println(Arrays.toString(insert(doubleArray, 5.5, 4)));
    }

    private static <T> T[] pushEnd(T[] array, T item) {
        Object[] newArray = new Object[array.length + 1];

        for(int i = 0; i < array.length; i++) { // Can also be done with < System.arraycopy(array, 0, newArray, 0, array.length); >
            newArray[i] = array[i];
        }
        newArray[array.length] = item;

        return (T[]) newArray;
    }

    private static <T> T[] popEnd(T[] array) {
        return null;
    }

    private static <T> T[] insert(T[] array, T item, int index) {
        return null;
    }
}
