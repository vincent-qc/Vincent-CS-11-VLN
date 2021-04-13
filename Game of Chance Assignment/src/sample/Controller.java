package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Random;

public class Controller {
    /**
     * Note This Game Can be Easily Cheated
     * I Didn't Give the Mechanics a Second Thought
     * TL;DR - The Game Sucks - Focused on GUI
     */

    // Public Fields
    public TextField textGetName;
    public Button btnSubmitName;
    public Label lbBalance;
    public Label lbTitle;
    public TextField textBetAmount;
    public VBox vboxBet;
    public Label lbResult1;
    public Label lbResult2;
    public Label lbResult3;
    public Label lbBetQuestion;
    public HBox hboxName;
    public Label lbWinResult;
    public Button btnResultsOK;
    public Button btnBetYes;
    public Button btnBetNo;

    // Private Fields
    private String userName;
    private int money = 100;
    private int threshold;
    private Boolean bigger; // Yes = True; No = False;
    private Boolean won = false;
    private Random r = new Random();
    private int[] results = new int[3];

    /**
     * Sets the player's name
     *
     * @param actionEvent Ignore
     */
    public void submitName(ActionEvent actionEvent) {

        userName = textGetName.getText();
        lbTitle.setText("Welcome, " + userName);

        if(!userName.isEmpty()) {
            // Name
            hboxName.setVisible(false);

            // Bet
            vboxBet.setVisible(true);

            // Sets Default Balance ($100) and Generates the Random Threshold
            lbBalance.setText("Balance: $" + money);
            threshold = r.nextInt(4) + 6; // Random number between 6 and 9
            lbBetQuestion.setText("Will the largest number be bigger than " + threshold + "?");
        }
    }

    /**
     * The User Bet that the Largest Number will be Bigger than the Threshold
     *
     * @param actionEvent Ignore
     */
    public void betYes(ActionEvent actionEvent) {
        bigger = true;
        bet();
    }

    /**
     * The User Bet that the Largest Number will be Smaller than the Threshold
     *
     * @param actionEvent Ignore
     */
    public void betNo(ActionEvent actionEvent) {
        bigger = false;
        bet();
    }

    /**
     * Create a New Bet (New Threshold)
     * Removes the Previous Round's Text
     * Enables The Bet Buttons
     */
    public void newBet() {
        threshold = r.nextInt(4) + 6; // Random number between 6 and 9
        lbBetQuestion.setText("Will the largest number be bigger than " + threshold + "?");
        btnResultsOK.setVisible(false);

        btnBetNo.setDisable(false);
        btnBetYes.setDisable(false);

        lbResult1.setText("");
        lbResult2.setText("");
        lbResult3.setText("");

        lbWinResult.setText("");
    }

    // Private Functions

    /**
     * Bet Using the Inputted Amount (Must be Integer)
     * Adds / Subtracts the Amount
     * Displays a Win / Lose Message
     */
    private void bet() {

        // Set / Reset Variables
        won = false;
        String amt = textBetAmount.getText();
        int parsedAmt;

        // Try to Parse the Input to Integer
        // Subtracts Amount from Balance
        // Catches Exception then Logs Invalid Number (Does Not Show On GUI)
        try {
            parsedAmt = Integer.parseInt(amt);
            if((money - parsedAmt < 0) || (parsedAmt <= 0)) return;
            money -= Integer.parseInt(amt);
        } catch(NumberFormatException e) {
            System.out.println("Invalid Number");
            return;
        }

        // Loops Three Time to Generate Three Numbers (For Dices)
        for(int i = 0; i < 3; i++) {
            results[i] = r.nextInt(11); // Number from 1-10
            // Checks if a Single Roll is Bigger than Threshold (If Bet Yes)
            if(bigger && results[i] > threshold) won = true;

            // Checks that ALL Rolls are Smaller than the Threshold
            if(i == 2 && !bigger)
                if(results[0] <= threshold && results[1] <= threshold && results[2] <= threshold)
                    won = true;
        }

        // Disable Buttons
        btnBetNo.setDisable(true);
        btnBetYes.setDisable(true);

        // Set the Roll Labels to their Values
        lbResult1.setText(String.valueOf(results[0]));
        lbResult2.setText(String.valueOf(results[1]));
        lbResult3.setText(String.valueOf(results[2]));

        // Make OK Button Visible
        btnResultsOK.setVisible(true);

        // Display Results
        // If Won: Doubles Bet
        // If Lost: Does Not Add nor Subtract (Lose Original Bet Money)
        if(won) {
            lbWinResult.setText("You won");
            money += Integer.parseInt(amt) * 2;
        }else{
            lbWinResult.setText("You lost");
        }

        lbBalance.setText("Balance: $" + money);
    }
}
