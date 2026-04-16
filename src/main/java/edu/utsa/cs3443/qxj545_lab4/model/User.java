package edu.utsa.cs3443.qxj545_lab4.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nicholas Brown
 *
 * User class contains an ArrayList of User objects loaded from the users.csv file.
 * User class also does the conversion from data to objects.
 * */

public class User extends Person {

    private String username;
    private String password;
    private int permissions;
    private String profilePictureFilePath;
    private ArrayList<User> users;
    private final String usersDataFilename = "data/users.csv";
    private User currentUser;


    public User(String firstName, String lastName, String email, String phoneNumber, String userName, String password, int permissions) {
        super(firstName, lastName, email, phoneNumber);
        this.username = userName;
        this.password = password;
        this.permissions = permissions;
        users = new ArrayList<>();
        loadUsersDataFromFile();
    }

    //
    public User(String firstName, String lastName, String email, String phoneNumber, String userName, String password, int permissions, String profilePictureFilePath) {
        super(firstName, lastName, email, phoneNumber);
        this.username = userName;
        this.password = password;
        this.permissions = permissions;
        this.profilePictureFilePath = profilePictureFilePath;
        users = new ArrayList<>();
        loadUsersDataFromFile();
    }

    // Private constructor for creating User objects FROM the file (no recursive load)
    private User(String firstName, String lastName, String email, String phoneNumber,
                 String userName, String password, int permissions, String profilePictureFilePath, boolean skipLoad) {
        super(firstName, lastName, email, phoneNumber);
        this.username = userName;
        this.password = password;
        this.permissions = permissions;
        this.profilePictureFilePath = profilePictureFilePath;
        if (!skipLoad) {
            users = new ArrayList<>();
            loadUsersDataFromFile();
        }
    }

    // GETTERS AND SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public static User getNewUserObject(String username) {
        return new User("", "", "", "", username, "", 0);
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(User user){
        if(user != null){
            currentUser = user;
        }
    }

    public ArrayList<User> getUsersList() {
        return users;
    }
    public String getProfilePictureFilePath() {
        if (profilePictureFilePath == null || profilePictureFilePath.isEmpty())
            return "";
        return profilePictureFilePath;
    }

    public void setProfilePictureFilePath(String profilePictureFilePath) {
        this.profilePictureFilePath = profilePictureFilePath;
    }

    public void loadUsersDataFromFile() {
        Scanner scanner = null;
        try {
            String line;
            User user;
            scanner = new Scanner(new File(usersDataFilename));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                user = convertLinetoUserObject(line, ",");
                if(user != null){
                    users.add(user);
                }else{
                    System.out.println("Failed to parse line: " + line); // DEBUG
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users file: " + e.getMessage());
        } finally {
            if(scanner != null)scanner.close();
        }
    }

    private User convertLinetoUserObject(String line, String delimiter) {
        String[] userData = line.split(delimiter);

        if (userData.length == 6) {
            return new User(userData[0], userData[1], userData[2], userData[3],
                    userData[4], userData[5], 0, "", true);
        }
        if (userData.length == 7) {
            return new User(userData[0], userData[1], userData[2], userData[3],
                    userData[4], userData[5], Integer.parseInt(userData[6]), "", true);
        }
        if (userData.length == 8) {
            return new User(userData[0], userData[1], userData[2], userData[3],
                    userData[4], userData[5], Integer.parseInt(userData[6]), userData[7], true);
        }
        return null;
    }

    public User findUser(String username, String password) {
        for(User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}