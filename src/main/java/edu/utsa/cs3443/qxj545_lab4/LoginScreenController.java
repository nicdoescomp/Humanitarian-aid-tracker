package edu.utsa.cs3443.qxj545_lab4;

import edu.utsa.cs3443.qxj545_lab4.model.AidShip;
import edu.utsa.cs3443.qxj545_lab4.model.AidShipManager;
import edu.utsa.cs3443.qxj545_lab4.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * @author Nicholas Brown
 * The controller contains all the logic (Buttons, Labels, text areas) for the login-screen.fxml.
 * Allows transfer to main-screen.fxml upon access of user credentials.
 *
 * */

public class LoginScreenController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginIndicatorLabel;
    @FXML
    private Button loginButton;
    private Stage stage;
    private AidShipManager aidShipManager;
    private AidShip aidShip;
    private User user;

    public void setStage(Stage stage){
        this.stage=stage;
    }

    // Needed for up-to-date data.
    @FXML
    private void initialize() throws IOException{
        try {
            aidShip = new AidShip();
            aidShipManager = new AidShipManager();
            aidShipManager.loadAidShips();
            //user.loadUsersDataFromFile();
            user = User.getNewUserObject("");

            // DEBUG: print working directory
            System.out.println("Working dir: " + System.getProperty("user.dir"));

            user = User.getNewUserObject("");
            System.out.println("Users loaded: " + user.getUsersList().size());
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    // Handles User Authentication and designated account login.
    @FXML
    public void onLoginButtonClick(ActionEvent event){
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if(username.isEmpty() || password.isEmpty()){
            loginIndicatorLabel.setText("Please enter a valid username and password.\n");
            return;
        }

        User pUser = user.findUser(username, password);

        if(pUser == null) {
            loginIndicatorLabel.setText("Invalid username and/or password!");
            return;
        }
        user.setCurrentUser(pUser);
        login(user);
    }

    // Screen switch logic on login.
    private void login(User user){
        System.out.println("Welcome " + user.getCurrentUser().getFullName() + "!");

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/utsa/cs3443/qxj545_lab4/layouts/main-screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            MainScreenController mainMenuController = fxmlLoader.getController();
            mainMenuController.setMainStage(stage);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e){
            loginIndicatorLabel.setText("Oops! There was an issue logging in, please try again.");
            e.printStackTrace();
        }
    }
}