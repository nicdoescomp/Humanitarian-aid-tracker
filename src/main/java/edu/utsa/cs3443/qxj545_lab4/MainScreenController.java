package edu.utsa.cs3443.qxj545_lab4;

import edu.utsa.cs3443.qxj545_lab4.model.AidShip;
import edu.utsa.cs3443.qxj545_lab4.model.AidShipManager;
import edu.utsa.cs3443.qxj545_lab4.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * @author Nicholas Brown
 * The controller contains all the logic (Buttons, Labels, text areas) for the main-screen.fxml.
 * Allows transfer to login-screen.fxml.
 *
 * */

public class MainScreenController {

    @FXML
    private Button listShipsButton;
    @FXML
    private TextArea registrationTextArea;
    @FXML
    private RadioButton findShipButton;
    @FXML
    private RadioButton deleteShipButton;
    @FXML
    private RadioButton sortByNameButton;
    @FXML
    private RadioButton sortByRegNumberButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button goButton;
    @FXML
    private Label infoOutput;
    private Stage mainStage;


    private AidShipManager aidShipManager;
    private AidShip aidShip;
    private User user;

    // Needed for up-to-date data.
    @FXML
    private void initialize() throws IOException {
        aidShipManager = new AidShipManager();
        aidShip = new AidShip();
        aidShipManager.loadAidShips();
    }

    // Needed for User data organization.
    @FXML
    protected void listShipsButtonClick(ActionEvent pEvent){
        if(sortByNameButton.isSelected()){
            aidShipManager.sortByName();
        }else if(sortByRegNumberButton.isSelected()){
            aidShipManager.sortByRegistrationNo();
        }
        infoOutput.setText(aidShipManager.toString());

    }

    // Handles the main logic for data file manipulation.
    @FXML
    protected void goButtonClick(ActionEvent pEvent){
        if(registrationTextArea.getText().isBlank()){
            infoOutput.setText("Enter a valid aid ship registration number.");
        }else{
            // NOTE for me: Find ship button.
            if(findShipButton.isSelected()) {
                if (aidShipManager.findAidShip(registrationTextArea.getText()) == null){
                    infoOutput.setText("Registration Number does not exist.\n");
                }
                infoOutput.setText(aidShipManager.findAidShip(registrationTextArea.getText()).toString());}

            // NOTE for me: Delete ship button.
            if(deleteShipButton.isSelected()) {
                if (aidShipManager.findAidShip(registrationTextArea.getText()) == null) {
                    infoOutput.setText("Registration Number does not exist.\n");
                }else try {
                    aidShipManager.deleteAidShip(aidShipManager.findAidShip(registrationTextArea.getText()));
                } catch (IOException e) {
                    infoOutput.setText("Uh oh! There was an issue deleting the ship.");
                    throw new RuntimeException(e);
                }

            }

            if(!deleteShipButton.isSelected() && !findShipButton.isSelected()){
                infoOutput.setText("Select an option.");
            }
        }

    }

    @FXML
    public void onLogoutButtonClick(ActionEvent event){
        logout();
    }

    private void logout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/utsa/cs3443/qxj545_lab4/layouts/login-screen.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the controller and set the stage
            LoginScreenController loginController = fxmlLoader.getController();
            loginController.setStage(mainStage);

            mainStage.setScene(loginScene);

            user.setCurrentUser(null);

        } catch (IOException e) {
            infoOutput.setText("Oops! There was an issue logging out, please try again.");
            e.printStackTrace();
        }
    }

    // Needed for switching in between scenes.
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

}