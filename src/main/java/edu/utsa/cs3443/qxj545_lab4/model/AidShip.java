package edu.utsa.cs3443.qxj545_lab4.model;


/**
 * @author Nicholas Brown
 * DESC: Contains the AidShip logic, holds all of its attributes
 *       and essentials to make this an object.
 *
 * */
public class AidShip extends Ship implements EmergencySupport {
    private String aidType;
    private int suppliesOnBoard;
    private boolean helipad;

    // CONSTRUCTORS
    // Default constructor
    public AidShip(){
        this.aidType = "None";
        this.suppliesOnBoard = 0;
        this.helipad = false;
    }
    // Parameterized constructor
//    public Ship(String name, String reg_num, double tonnage, int crewSize, double pCurrentSpeed, String curr_port) {

    public AidShip(String pName, String pRegistrationNumber, double pTonnage, int pCrewSize, double pCurrentSpeed, String pCurrentPort, String pAidType, int pSuppliesOnBoard, boolean pHeliPad){
        super(pName, pRegistrationNumber, pTonnage, pCrewSize, pCurrentSpeed, pCurrentPort);

        this.aidType = pAidType;
        this.suppliesOnBoard = pSuppliesOnBoard;
        this.helipad = pHeliPad;
    }

    // GETTERS AND SETTERS
    public String getAidType(){return aidType;}

    public int getSuppliesOnBoard() {return suppliesOnBoard;}

    public boolean isHasHelipad() {return helipad;}

    public void setAidType(String pAidType){this.aidType = pAidType;}

    public void setSuppliesOnBoard(int suppliesOnBoard) {this.suppliesOnBoard = suppliesOnBoard;}

    public void setHasHelipad(boolean helipad) {this.helipad = helipad;}

    // METHODS

    // Simulates AidShip providing aid.
    public void deployAid(){
        System.out.println("Ship is providing aid.");
        setSuppliesOnBoard(0);
    }

    // Simulates AidShip's supplies being used.
    private void unloadSupplies(){
        System.out.println("Unloads supplies on board?");
        setSuppliesOnBoard(0);
    }

    // Simulates AidShip docking.
    @Override
    public void dock(String pCurrentPort){
        unloadSupplies();
        setCurrentPort(pCurrentPort);
        setCurrentSpeed(0.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aid Ship Card:\n");
        sb.append("-----------------------------------------\n");
        sb.append("Name:                  " + getName());
        sb.append("\nRegistration Number:   " + getRegistrationNumber());
        sb.append("\nTonnage:               " + getTonnage());
        sb.append("\nCrew Size:             " + getCrewSize());
        sb.append("\nCurrent Port:          " + getCurrentPort());
        sb.append("\nAid Type:              " + getAidType());
        sb.append("\nSupplies On Board:     " + getSuppliesOnBoard());
        sb.append("\nHelipad:               " + (isHasHelipad() ? "Available\n" : "Unavailable\n"));

        sb.append("-----------------------------------------\n");
        return sb.toString();
    }

    @Override
    public String toStringCSV(){
        return getName() + "," +getRegistrationNumber() + "," +getTonnage() + "," +getCrewSize() + "," +
                getCurrentPort() + "," +getAidType() + "," + getSuppliesOnBoard() + "," +isHasHelipad() +"\n";
    }



}
