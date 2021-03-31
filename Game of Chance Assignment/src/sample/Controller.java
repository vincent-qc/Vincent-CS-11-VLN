package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Controller {
    public TextField textGetName;
    public Button btnSubmitName;
    public Label lbBalance;
    public Label lbTitle;
    public TextField textBetAmount;
    public Button btnBetSubmit;

    private String userName;
    private int money = 100;

    public void submitName(ActionEvent actionEvent) {
        userName = textGetName.getText();
        lbTitle.setText("Welcome, " + userName);

        if(!userName.isEmpty()) {
            // Name
            textGetName.setVisible(false);
            btnSubmitName.setVisible(false);

            // Bet
            lbBalance.setVisible(true);
            textBetAmount.setVisible(true);
            btnBetSubmit.setVisible(true);

            updateUI();
        }
    }

    public void bet(ActionEvent actionEvent) {
        String amt = textBetAmount.getText();

        try {
            if(money - Integer.parseInt(amt) >= 0) money -= Integer.parseInt(amt);
        } catch(NumberFormatException e) {
            System.out.println("Invalid Number");
        }

        System.out.println(textBetAmount.getText());
        updateUI();
    }

    private void updateUI() {
        lbBalance.setText("Balance: $" + money);
    }
}
