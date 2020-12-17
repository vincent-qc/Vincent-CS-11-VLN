import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> winningValues = initializeValues();
        List<String> possibleValues = Arrays.asList("rock", "paper", "scissors", "r", "p", "s");
        Scanner scan = new Scanner(System.in);
        boolean playing = true;

        while (true) {
            String userChoice = scan.nextLine().toLowerCase();
            String botChoice = possibleValues.get((int) (Math.random() * 3 + 3));

            System.out.println(botChoice);
            if (!possibleValues.contains(userChoice)) {
                System.out.println("Sorry, " + userChoice + " was not a Valid Input :/");
                continue;
            }

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

    private static HashMap<String, String> initializeValues() {
        HashMap<String, String> values = new HashMap<>();
        values.put("r", "s");
        values.put("s", "p");
        values.put("p", "r");

        return values;
    }

    private static String getFullName(String word) {
        switch (word) {
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
