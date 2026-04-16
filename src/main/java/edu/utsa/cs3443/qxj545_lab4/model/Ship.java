package edu.utsa.cs3443.qxj545_lab4.model;

public abstract class Ship implements Navigable{
    // ATTRIBUTES
    private String name, registrationNumber, currentPort;
    private double tonnage, currentSpeed;
    private int crewSize;

    // CONSTRUCTORS
    // Default constructor
    public Ship(){
        name = "None";
        registrationNumber = "None";
        tonnage = 0.00;
        crewSize = 0;
        currentSpeed = 0.00;
        currentPort = "None";
    }

    // Parameterized Constructor
    public Ship(String pName, String pRegistrationNumber, double pTonnage, int pCrewSize, double pCurrentSpeed, String pCurrentPort){
        this.name = pName;
        this.registrationNumber = pRegistrationNumber;
        this.tonnage=pTonnage;
        this.crewSize=pCrewSize;
        this.currentSpeed = pCurrentSpeed;
        this.currentPort = pCurrentPort;
    }

    // GETTERS AND SETTERS.
    public String getName(){return name;}

    public String getRegistrationNumber(){return registrationNumber;}

    public double getTonnage(){return tonnage;}

    public int getCrewSize(){return crewSize;}

    public double getCurrentSpeed(){return currentSpeed;}

    public String getCurrentPort(){return currentPort;}

    public void setName(String pName){
        this.name = pName;
    }

    public void setRegistrationNumber(String pRegistrationNumber){this.registrationNumber = pRegistrationNumber;}

    public void setTonnage(double pTonnage){this.tonnage = pTonnage;}

    public void setCrewSize(int pCrewSize){this.crewSize = pCrewSize;}

    public void setCurrentSpeed(double  pCurrentSpeed){this.currentSpeed = pCurrentSpeed;}

    public void setCurrentPort(String pCurrentPort){this.currentPort = pCurrentPort;}

    // METHODS
    // Represents ship docking simulation.
    public void navigateTo(String pDestination, double pNavSpeed){
        System.out.println("Ship " + getName() + " Destination: " + pDestination);
        setCurrentSpeed(pNavSpeed);
    }

    // Simulates a ship docking.
    public void dock(String pPortName){
        // Update ship's current port
        setCurrentPort(pPortName);
        setCurrentSpeed(0.0);
    }

    @Override
    public String toString(){
        return "name: " + name + ", registrationNumber: " + registrationNumber +
                ", tonnage: " + tonnage + ", crewSize: " + crewSize +
                ", currentSpeed: " + currentSpeed + ", currentPort: " + currentPort;
    }

    public  String toStringCSV(){
        return name + "," + registrationNumber +
                "," + tonnage + "," + crewSize +
                "," + currentSpeed + "," + currentPort;
    }

}
