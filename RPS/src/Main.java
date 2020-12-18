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

            // Compares bot value to user value and determines the winner
            if (botChoice.equals(userChoice)) {
                System.out.println("Draw");
            } else if (botChoice.equals(winningValues.get(userChoice))) {
                System.out.println("Win");
            } else {
                System.out.println("Lose");
            }
            System.out.println("Bot: " + getFullName(botChoice) + " | User: " + getFullName(userChoice.substring(0, 1)));
        }
    }

    /**
     * Creates and Returns HashMap => Key: String, Value: String of the winning RPS values
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
     *
     * @param letter The input letter
     * @return Returns a String with the full name of the letter
     */
    private static String getFullName(String letter) {

        // Switches between the letters
        switch (letter) {
            case "r":
                return "Rock";
            case "p":
                return "Paper";
            case "s":
                return "Scissors";
        }
        return null;
    }
}
