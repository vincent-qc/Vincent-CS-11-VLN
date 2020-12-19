import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Initialize the variables
        HashMap<String, String> winningValues = initializeValues();
        List<String> possibleValues = Arrays.asList("rock", "paper", "scissors", "r", "p", "s");
        Scanner scan = new Scanner(System.in);
        String color;
        Random r = new Random();

        // Score
        int playerScore = 0, computerScore = 0;

        // Repeats the game if the user does not Quit
        while (true) {
            System.out.println( "\n\u001b[32m" +
                    "\n" + "┌──────────────── Welcome to Rock Paper Scissors ────────────────┐" +
                    "\n" + "│                        Pick your fighter                       │" +
                    "\n" + "│  Rock (R)  │  Paper (P)  │ Scissors (S) | Score(SC) | Quit (Q) │" +
                    "\n" + "├────────────┴─────────────┴──────────────┴───────────┴──────────┤" +
                    "\n" + "|" + padString("User Score: " + playerScore + "    CPU Score: " + computerScore, 63) + "│" +
                    "\n" + "└────────────────────────────────────────────────────────────────┘"
            );

            // Get User + Bot choices
            String userChoice = scan.nextLine().toLowerCase();
            String botChoice = possibleValues.get(r.nextInt(3) + 3); // Used random.nextInt() instead of Math.random() as it is less biased

            // Checks if User Input is Q or QUIT
            if(userChoice.equals("q") || userChoice.equals("quit")) {  // Checks if the user wants to quit
                break;
            } else if(userChoice.equals("score") || userChoice.equals("sc")) { // Checks if the user wants to see the scoreboard
                System.out.println(generateResultsText(playerScore, computerScore));
                continue;
            } else if (!possibleValues.contains(userChoice)) { // Checks if the users input was valid
                System.out.println("Sorry, " + userChoice + " was not a Valid Input :/");
                continue;
            }

            String outcome;

            // Compares bot value to user value and determines the winner
            if (botChoice.equals(userChoice)) {
                outcome = " Tie. ";
                color = "\u001b[33m";
            } else if (botChoice.equals(winningValues.get(userChoice))) {
                outcome = " You Won! ";
                color = "\u001b[34m";
                playerScore += 1;
            } else {
                outcome = " You Lost :( ";
                color = "\u001b[31m";
                computerScore += 1;
            }

            String results =  "User: " + getFullName(userChoice.substring(0, 1)) + color + " ||\u001b[0m Bot: " + getFullName(botChoice);

            // Prints a formatted message
            System.out.println(generateResultsText(outcome, results, color));
        }

        System.out.println(
                "\n" + "┌─────────────────────────────┐" +
                "\n" + "│   Thanks For Playing RPS!   │" +
                "\n" + "└─────────────────────────────┘"
        );
    }

    /**
     * Takes in two Strings and creates scoreboard
     * [This Method is for Decorative Purposes ONLY]
     * @param playerScore The player's score
     * @param computerScore The CPU's score
     * @return Returns the scoreboard as a String
     */
    private static String generateResultsText(int playerScore, int computerScore) {
        return "\u001b[32m" +
                "\n" + "┌──────────── Score ────────────┐" +
                "\n" + "│ User Score: " + padString(Integer.toString(playerScore), 17) + "│" +
                "\n" + "├───────────────────────────────┤" +
                "\n" + "│ CPU Score:  " + padString(Integer.toString(playerScore), 17) + "│" +
                "\n" + "└───────────────────────────────┘";
    }

    /**
     * Takes in two Strings and creates decorated text
     * [This Method is for Decorative Purposes ONLY]
     *
     * @param outcome The Outcome String
     * @param results The Results String
     * @param color The color of the decorated text
     * @return Returns decorated text as String
     */
    private static String generateResultsText(String outcome, String results, String color) {

        // Initialize the Variables
        String borderLine = "─".repeat((results.length() / 2) - (outcome.length() / 2) - 3);
        int totalLineLength = borderLine.length() * 2 + outcome.length();

        // Returns the Padded String with certain color
        return color + "\n" + "┌" + borderLine + outcome + borderLine + "┐" +
                "\n" + "│ \u001b[0m" + padString(results, totalLineLength + 6) + color + " │" +
                "\n" + "└" + "─".repeat(totalLineLength) + "┘";
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
            if(strBuilder.length() < length) strBuilder.insert(0, " ");
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
