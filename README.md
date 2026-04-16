# qxj545_lab4 — Aid Ship Management System

A JavaFX desktop application for managing humanitarian aid ships, built with Maven and following an MVC architecture.

---

## Project Structure

```
qxj545_lab4/
├── .idea/                          # IDE configuration files
├── .mvn/                           # Maven wrapper files
├── data/                           # Persistent data storage
│   ├── aid_ships.csv               # Ship database
│   └── users.csv                   # User credentials
├── src/
│   └── main/
│       ├── java/
│       │   └── edu.utsa.cs3443.qxj545_lab4/
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
│       │       └── module-info.java
│       └── resources/
│           └── edu.utsa.cs3443.qxj545_lab4/
│               ├── images/
│               │   └── logo.png
│               └── layouts/
│                   ├── login-screen.fxml
│                   └── main-screen.fxml
├── target/                         # Compiled bytecode and build artifacts
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

---

## Architecture Overview

This project follows the **MVC (Model-View-Controller)** pattern.

| Layer | Location | Responsibility |
|---|---|---|
| **Model** | `model/` | Business logic, data structures, interfaces |
| **View** | `resources/layouts/` | UI layout defined in FXML |
| **Controller** | `*Controller.java` | Handles user interaction and binds View to Model |

---

## Key Components

### Models (`model/`)

| File | Description |
|---|---|
| `Ship.java` | Base class representing a generic ship |
| `AidShip.java` | Extends `Ship`; represents a humanitarian aid vessel |
| `AidShipManager.java` | Manages the collection of `AidShip` objects; handles CSV I/O |
| `AidShipApplication.java` | Application entry point / JavaFX `Application` subclass |
| `Person.java` | Represents a person entity |
| `User.java` | Extends `Person`; handles authentication data |
| `Navigable.java` | Interface defining navigation behavior for ships |
| `EmergencySupport.java` | Interface defining emergency support capabilities |

### Controllers

| File | Description |
|---|---|
| `LoginScreenController.java` | Manages login form input, validates credentials against `users.csv` |
| `MainScreenController.java` | Drives the main dashboard; loads and displays ship data |

### Data Files (`data/`)

| File | Description |
|---|---|
| `aid_ships.csv` | Stores ship records loaded and saved by `AidShipManager` |
| `users.csv` | Stores user credentials used for login authentication |

### Resources (`resources/`)

| File | Description |
|---|---|
| `login-screen.fxml` | FXML layout for the login screen |
| `main-screen.fxml` | FXML layout for the main application screen |
| `images/logo.png` | Application logo used in the UI |

---

## Prerequisites

- **Java 17+**
- **JavaFX SDK** (included via Maven dependencies in `pom.xml`)
- **Maven 3.8+** (or use the included `mvnw` wrapper)

---

## Getting Started

### 1. Clone the repository

```bash
git clone <repository-url>
cd qxj545_lab4
```

### 2. Build the project

```bash
./mvnw clean install
```

> On Windows, use `mvnw.cmd clean install`

### 3. Run the application

```bash
./mvnw javafx:run
```

---

## Usage

1. Launch the application — the **Login Screen** appears first.
2. Enter valid credentials (stored in `data/users.csv`).
3. On successful login, the **Main Screen** loads the aid ship dashboard.
4. Ship data is read from and written back to `data/aid_ships.csv`.

---

## Dependencies

All dependencies are managed via **Maven** in `pom.xml`. Key dependencies include:

- `javafx-controls` — UI controls
- `javafx-fxml` — FXML support for view loading

---

## Notes

- The `module-info.java` file configures the Java module system to expose the correct packages to JavaFX.
- CSV files in `data/` must remain in the project root at runtime for the application to read/write data correctly.
- Do not commit credentials or sensitive data to `users.csv` in a production environment.
