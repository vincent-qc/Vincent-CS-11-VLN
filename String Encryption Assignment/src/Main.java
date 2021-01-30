public class Main {
    public static void main(String[] args) {

        // Test Cases
        System.out.println(encryptString("Hello"));
        System.out.println(decryptString("oHellay"));
        System.out.println(decryptString(encryptString("Hello World")));
    }

    /**
     * Moves the last letter to the front via concatenation and appends "ay"
     *
     * @param text The Text to encrypt
     * @return Returns the encrypted text
     */
    private static String encryptString(String text) {
        return text.charAt(text.length() - 1) + text.substring(0, text.length() - 1) + "ay";
    }

    /**
     * Disregards the "ay" and switches the positions of the first letter and the rest of the String
     *
     * @param text The text to decrypt
     * @return Returns the decrypted text
     */
    private static String decryptString(String text) {
        return text.substring(1, text.length() - 2) + text.charAt(0);
    }
}
