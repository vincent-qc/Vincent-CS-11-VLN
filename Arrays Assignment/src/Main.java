public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"Foo", "Bar", "Baz"};
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 6.6};

        // Test Cases
        pushEnd(stringArray, "Hello World");
        popEnd(intArray);
        insert(doubleArray, 5.5, 4);
    }

    private static <T> void pushEnd(T[] array, T item) {

    }

    private static <T> void popEnd(T[] array) {

    }

    private static <T> void insert(T[] array, T item, int index) {

    }
}
