module edu.utsa.cs3443.qxj545_lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3443.qxj545_lab4 to javafx.fxml;
    exports edu.utsa.cs3443.qxj545_lab4;
    exports edu.utsa.cs3443.qxj545_lab4.model;
    opens edu.utsa.cs3443.qxj545_lab4.model to javafx.fxml;
}