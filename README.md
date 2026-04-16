qxj545_lab4
├── .idea/                          # IDE configuration files
├── .mvn/                           # Maven wrapper files
├── data/                           # Persistent data storage
│   ├── aid_ships.csv               # Ship database
│   └── users.csv                   # User credentials
├── src
│   └── main
│       ├── java
│       │   └── edu.utsa.cs3443.qxj545_lab4
│       │       ├── model/          # Business logic (Models & Interfaces)
│       │       │   ├── AidShip.java
│       │       │   ├── AidShipApplication.java
│       │       │   ├── AidShipManager.java
│       │       │   ├── EmergencySupport.java
│       │       │   ├── Navigable.java
│       │       │   ├── Person.java
│       │       │   ├── Ship.java
│       │       │   └── User.java
│       │       ├── LoginScreenController.java
│       │       ├── MainScreenController.java
│       │       └── module-info.java # Module descriptor for JavaFX
│       └── resources
│           └── edu.utsa.cs3443.qxj545_lab4
│               ├── images/         # UI Assets
│               │   └── logo.png
│               └── layouts/        # View Layer (FXML)
│                   ├── login-screen.fxml
│                   └── main-screen.fxml
├── target/                         # Compiled bytecode and build artifacts
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml                         # Project dependencies and build config
