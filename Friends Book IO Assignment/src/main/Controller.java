package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Controller {
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
    public Button btnLoad;
    public Button btnSave;

    /**
     * Requires: Nothing
     * Modifies: listFriends
     * Effects: Updates the ListView to include new Friends
     *          Moves all starred Friends to the top
     */
    private void updateList() {
        // Reset List
        listFriends.getItems().clear();

        // Add all the starred Friends to the top
        for (Friend item : IOHandler.getAllFriends())
            if (item.isStarred())
                listFriends.getItems().add(item);

        // 2nd Iteration to add the rest of the people
        for (Friend item : IOHandler.getAllFriends())
            if (!item.isStarred())
                listFriends.getItems().add(item);

        // Hide Screen if not selecting anything
        Friend selected = listFriends.getSelectionModel().getSelectedItem();
        if (selected == null) vboxFriendInfo.setVisible(false);
    }

    /**
     * Requires: Nothing
     * Modifies: IOHandler.allFriends
     * Effects: Adds Friend to the list and updates UI
     */
    public void addNewFriend() {

        // Check if the name fields are empty
        if (fieldFName.getText().isEmpty() || fieldLName.getText().isEmpty()) {
            System.out.println("Did not input name");
            return;
        }

        // Add a friend to the list
        IOHandler.addItemAllFriends(new Friend(
                fieldFName.getText(),
                fieldLName.getText(),
                fieldEmail.getText().isEmpty() ? "none" : fieldEmail.getText(),
                fieldPhone.getText().isEmpty() ? "none" : fieldPhone.getText(),
                false
        ));

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
        IOHandler.removeItemAllFriends(selected);
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

    // IO

    /**
     * Saves the Friends
     *
     * @param actionEvent
     */
    public void saveList(ActionEvent actionEvent) {
        IOHandler.writeOut();
    }

    /**
     * Loads all saved Friends
     *
     * @param actionEvent
     */
    public void loadList(ActionEvent actionEvent) {
        IOHandler.readIn();
        updateList();
    }
}