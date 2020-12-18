import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize the variables
        HashMap<String, String> winningValues = initializeValues();
        List<String> possibleValues = Arrays.asList("rock", "paper", "scissors", "r", "p", "s");
        Scanner scan = new Scanner(System.in);

        // Repeats the game if the user does not Quit
        while (true) {

            // Get User + Bot choices
            String userChoice = scan.nextLine().toLowerCase();
            String botChoice = possibleValues.get((int) (Math.random() * 3 + 3));

            // Checks if User Input is Q or QUIT
            if(userChoice.equals("q") || userChoice.equals("quit")) {
                break;
            } else if (!possibleValues.contains(userChoice)) {

                // Checks if User Input is valid
                System.out.println("Sorry, " + userChoice + " was not a Valid Input :/");
                continue;
            }

            String outcome;
            String results = "Bot: " + getFullName(botChoice) + " || User: " + getFullName(userChoice.substring(0, 1));

            // Compares bot value to user value and determines the winner
            if (botChoice.equals(userChoice)) {
                outcome = " Tie. ";
            } else if (botChoice.equals(winningValues.get(userChoice))) {
                outcome = " You Won! ";
            } else {
                outcome = " You Lost :( ";
            }

            // Prints a formatted message
            System.out.println(generateResultsText(outcome, results));
        }
    }

    /**
     * Takes in two Strings and creates decorated text
     * [This Method is for Decorative Purposes ONLY]
     *
     * @param outcome The Outcome String
     * @param results The Results String
     * @return Returns decorated text as String
     */
    private static String generateResultsText(String outcome, String results) {

        // Initialize the Variables
        String borderLine = "─".repeat((results.length() / 2) - (outcome.length() / 2) + 2);
        int totalLineLength = borderLine.length() * 2 + outcome.length();

        // Returns the Padded String with certain color
        return "\u001b[31m \n ┌" + borderLine + outcome + borderLine + "┐" +
                "\n │ \u001b[0m" + padString(results, totalLineLength - 3) + "\u001b[31m │" +
                "\n └" + "─".repeat(totalLineLength) + "┘";
    }

    /**
     * Pads String to fit length
     * [This Method is for Decorative Purposes ONLY]
     *
     * @param text The String to pad
     * @param length The Length to pad it to
     * @return Returns the padded String
     */
    private static String padString(String text, int length) {
        StringBuilder strBuilder = new StringBuilder(text);

        // Checks if the String is less than the length
        while(strBuilder.length() <= length) {
            if(strBuilder.length() < length - 1) strBuilder.insert(0, " ");
            strBuilder.append(" ");
        }

        return strBuilder.toString();
    }

    /**
     * Creates and Returns HashMap => Key: String, Value: String of the winning RPS values
     * [This Method is for Decorative Purposes ONLY]
     *
     * @return Returns a HashMap with the Winning Values for RPS
     */
    private static HashMap<String, String> initializeValues() {

        // Creates the HashMap
        HashMap<String, String> values = new HashMap<>();
        values.put("r", "s");
        values.put("s", "p");
        values.put("p", "r");

        return values;
    }

    /**
     * Takes in a Letter and Returns the full name
     * [This Method is for Decorative Purposes ONLY]
     *
     * @param letter The input letter
     * @return Returns a String with the full name of the letter
     */
    private static String getFullName(String letter) {

        // Switches between the letters
        switch (letter) {
            case "r":
                return "Rock \uD83E\uDEA8";
            case "p":
                return "Paper \uD83D\uDCDC";
            case "s":
                return "Scissors ✂️";
        }
        return null;
    }
}
