package edu.utsa.cs3443.qxj545_lab4.model;// Utility that keeps track of group of AidShips

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nicholas Brown
 * DESC: Handels the ArrayList of Aidships and defines all
 *       of its functions to modify data.
 *
 * */

public class AidShipManager {
    private ArrayList<AidShip> aidShips;

    // CONSTRUCTORS
    public AidShipManager(){
        this.aidShips = new ArrayList<>();
    }

    // METHODS
    public void addAidShip(AidShip pAidShip){
        aidShips.add(pAidShip);
    }

    // Reads from files and adds aid ships.
    public void loadAidShips() throws IOException{
        try {
            File file = new File("data/aid_ships.csv");
            Scanner scan = new Scanner(file);

            // Skips the header.
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                // Scans and writes strings separated by commas.
                String line = scan.nextLine();
                String[] tokens = line.split(",");

                String name = tokens[0];
                String registrationNum = tokens[1];
                double tonnage = Double.parseDouble(tokens[2]);
                int crewSize = Integer.parseInt(tokens[3]);
                String currentPort = tokens[4];
                String aidType = tokens[5];
                int suppliesOnBoard = Integer.parseInt(tokens[6]);
                boolean helipad = Boolean.parseBoolean(tokens[7]);

                // Creates and adds new aid ship.
                AidShip aidShip = new AidShip(name, registrationNum, tonnage, crewSize, 0.0, currentPort, aidType, suppliesOnBoard, helipad);
                aidShips.add(aidShip);
            }
            scan.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Finds aid ship in array list of AidShip objects.
    public AidShip findAidShip(String pRegistrationNumber){
        for(int i =0;i<aidShips.size() ; i++){
            if(aidShips.get(i).getRegistrationNumber().equals(pRegistrationNumber)){
                return aidShips.get(i);
            }
        }
        return null;
    }

    // Check if ship exists in ArrayList via registration number.
    public boolean isAidShipExists(String pRegistrationNumber){

        for(AidShip aidShip : aidShips){
            if(aidShip.getRegistrationNumber().equals(pRegistrationNumber)){
                return true;
            }
        }
        return false;
    }

    // Replaces selected Aid Ship with users info.
    public boolean updateAidShip(AidShip pAidShip) throws IOException {
        for (int i = 0; i < aidShips.size(); i++) {
            if (aidShips.get(i).getRegistrationNumber().equals(pAidShip.getRegistrationNumber())) {

                aidShips.set(i, pAidShip);
                saveDataToFile();
                return true;
            }
        }
        return false;
    }

    // Deletes selected Aid Ship Obj from ArrayList.
    public boolean deleteAidShip(AidShip pAidShip) throws IOException {
        for(AidShip aidShip : aidShips){
            if(aidShip.equals(pAidShip)){
                aidShips.remove(aidShip);
                saveDataToFile();
                return true;
            }
        }
        return false;
    }

    // Saves data to data.csv.
    private void saveDataToFile() throws IOException{
        File outFile = new File("data/aid_ships.csv");
        FileWriter out = new FileWriter(outFile);

        // Writes to file so first line of data will never be skipped.
        out.write("name,registrationNumber,tonnage,crewSize,port,aidType,aidCapacity,hasHelipad\n");

        for(AidShip aidShip : aidShips){
            out.write(aidShip.toStringCSV());
        }
        out.close();
    }

    // Converts String into an AidShip Obj.
    public AidShip convertLineToAidShip(String pLine){
        String[] tokens = pLine.split(",");

        String name = tokens[0];
        String registrationNum = tokens[1];
        double tonnage = Double.parseDouble(tokens[2]);
        int crewSize = Integer.parseInt(tokens[3]);
        String currentPort = tokens[4];
        String aidType = tokens[5];
        int suppliesOnBoard = Integer.parseInt(tokens[6]);
        boolean helipad = Boolean.parseBoolean(tokens[7]);

        return new AidShip(name, registrationNum, tonnage, crewSize, 0.0, currentPort, aidType, suppliesOnBoard, helipad);
    }

    //  Returns a string representing the object as a line in the file.
    public String convertAidShipToLine(AidShip pAidShip){

        return pAidShip.getName() + "," + pAidShip.getRegistrationNumber() + "," + pAidShip.getTonnage() + "," +
                pAidShip.getCrewSize() +"," + pAidShip.getCurrentSpeed() + "," + pAidShip.getCurrentPort() +"," +
                pAidShip.getAidType() + "," + pAidShip.getSuppliesOnBoard() + "," + pAidShip.isHasHelipad();
    }

    // Sorts ship objects by name;
    public void sortByName(){
        aidShips.sort((a,b) -> a.getName().compareTo(b.getName()));
    }

    // Sorts ship objects by registration number.
    public void sortByRegistrationNo(){
        aidShips.sort((a,b) -> a.getRegistrationNumber().compareTo(b.getRegistrationNumber()));

    }

    // Prints info of every Aid Ship.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AidShipCoordinator List has " + aidShips.size() + " responders\n");
        sb.append("---------------------------------------------------------------------------------------------------------------------------------------------------\n");
        sb.append("|Name            |Registration Number  |Tonnage    |Crew Size   |Current Port          |Aid Type               |Supplies On Board      |Helipad\n");
        sb.append("---------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (AidShip aidship : aidShips) {
            sb.append(String.format("|%-16s|%-21s|%-11.2f|%-12d|%-22s|%-23s|%-23d|%s\n",
                    aidship.getName(),
                    aidship.getRegistrationNumber(),
                    aidship.getTonnage(),
                    aidship.getCrewSize(),
                    aidship.getCurrentPort(),
                    aidship.getAidType(),
                    aidship.getSuppliesOnBoard(),
                    aidship.isHasHelipad() ? "Yes" : "No"
            ));
        }
        return sb.toString();
    }

    // GETTERS AND SETTERS.
    public ArrayList<AidShip> getAidShipList() {
        return aidShips;
    }

    public void setAidShipList(ArrayList<AidShip> aidShips) {
        this.aidShips = aidShips;
    }
}
