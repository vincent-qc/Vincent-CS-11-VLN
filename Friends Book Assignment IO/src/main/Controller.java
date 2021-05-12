package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller {
    private static final ArrayList<Friend> allFriends = new ArrayList<>();

    // JavaFX Items
    public ListView<Friend> listFriends = new ListView<>();
    public Label lbName;
    public TextField fieldFName;
    public TextField fieldLName;
    public TextField fieldEmail;
    public TextField fieldPhone;
    public Button btnSubmit;
    public Label lbPhoneValue;
    public Label lbEmailValue;
    public VBox vboxFriendInfo;
    public Button btnDeleteFriend;
    public Button btnStar;

    /**
     * Updates the ListView to include new Friends
     * Moves all starred Friends to the top
     */
    private void updateList() {

        // Reset List
        listFriends.getItems().clear();

        // Add all the starred Friends to the top
        for (Friend item : allFriends)
            if (item.isStarred())
                listFriends.getItems().add(item);

        // 2nd Iteration to add the rest of the people
        for (Friend item : allFriends)
            if (!item.isStarred())
                listFriends.getItems().add(item);

        // Hide Screen if not selecting anything
        Friend selected = listFriends.getSelectionModel().getSelectedItem();
        if (selected == null) vboxFriendInfo.setVisible(false);
    }

    /**
     * Adds new Friend to the Friends List, and updates the UI
     * A First and Last name are required for creating a friend
     * An email or phone are optional
     */
    public void addNewFriend() {

        // Check if the name fields are empty
        if (fieldFName.getText().isEmpty() || fieldLName.getText().isEmpty()) {
            System.out.println("Did not input name");
            return;
        }

        // Add a friend to the list
        allFriends.add(new Friend(
                fieldFName.getText(),
                fieldLName.getText(),
                fieldEmail.getText().isEmpty() ? "none" : fieldEmail.getText(),
                fieldPhone.getText().isEmpty() ? "none" : fieldPhone.getText())
        );

        updateList();
    }

    /**
     * Displays the friend info including:
     * Full Name
     * Email (or 'none')
     * Phone (or 'none')
     *
     * @param mouseEvent When CLICKED on an item in the ListView, Displays the Friend's info
     */
    public void displayFriend(MouseEvent mouseEvent) {
        vboxFriendInfo.setVisible(true); // It was set Invisible since we don't want the user to see the default values when he hasn't selected anyone

        Friend selected = listFriends.getSelectionModel().getSelectedItem();

        // Set name, email and phone
        lbName.setText(selected.getfName().toUpperCase() + " " + selected.getlName().toUpperCase());
        lbEmailValue.setText(selected.getEmail());
        lbPhoneValue.setText(selected.getPhone());
    }

    /**
     * Deletes a Friend
     *
     * @param actionEvent
     */
    public void deleteFriend(ActionEvent actionEvent) {
        Friend selected = listFriends.getSelectionModel().getSelectedItem();
        allFriends.remove(selected);
        updateList();
    }

    /**
     * Stars a Friend
     *
     * @param actionEvent
     */
    public void starFriend(ActionEvent actionEvent) {
        Friend selected = listFriends.getSelectionModel().getSelectedItem();
        selected.star();
        updateList();
    }
}