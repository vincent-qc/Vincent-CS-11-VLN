package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Controller {
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

    private String userName;
    private int money = 100;
    private int threshold;
    private Boolean bigger; // Yes = True; No = False;
    private Boolean won = false;
    private Random r = new Random();
    private int[] results = new int[3];

    public void submitName(ActionEvent actionEvent) {
        userName = textGetName.getText();
        lbTitle.setText("Welcome, " + userName);

        if(!userName.isEmpty()) {
            // Name
            hboxName.setVisible(false);

            // Bet
            vboxBet.setVisible(true);

            updateUI();
            threshold = r.nextInt(4) + 6; // Random number between 6 and 9
            lbBetQuestion.setText("Will the largest number be bigger than " + threshold + "?");
        }
    }

    public void betYes(ActionEvent actionEvent) {
        bigger = true;
        bet();
    }

    public void betNo(ActionEvent actionEvent) {
        bigger = false;
        bet();
    }

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

    private void bet() {
        won = false;

        String amt = textBetAmount.getText();
        int parsedAmt;

        try {
            parsedAmt = Integer.parseInt(amt);
            if((money - parsedAmt >= 0) && (parsedAmt > 0)) money -= Integer.parseInt(amt);
        } catch(NumberFormatException e) {
            System.out.println("Invalid Number");
            return;
        }

        for(int i = 0; i < 3; i++) {
            results[i] = r.nextInt(11); // Number from 1-10
            if(bigger && results[i] > threshold) won = true;
            if(i == 2 && !bigger)
                if(results[0] <= threshold && results[1] <= threshold && results[2] <= threshold) // Works but not efficient - Might change later
                    won = true;
        }

        btnBetNo.setDisable(true);
        btnBetYes.setDisable(true);

        lbResult1.setText(String.valueOf(results[0]));
        lbResult2.setText(String.valueOf(results[1]));
        lbResult3.setText(String.valueOf(results[2]));

        btnResultsOK.setVisible(true);

        System.out.println(threshold + " " + won);

        if(won) {
            lbWinResult.setText("You won");
            money += Integer.parseInt(amt) * 2;
        }else{
            lbWinResult.setText("You lost");
        }

        updateUI();
    }

    private void updateUI() {
        lbBalance.setText("Balance: $" + money);
    }
}
