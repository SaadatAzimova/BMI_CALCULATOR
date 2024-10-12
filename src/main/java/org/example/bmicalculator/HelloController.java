package org.example.bmicalculator;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField weight;
    @FXML private TextField height;
    @FXML
    private Label result;
    @FXML
    private ChoiceBox<String> unitChoice;
    @FXML
    //Add available unit options to the choice box
    public void initialize() {
        unitChoice.setItems(FXCollections.observableArrayList("Metric (kg/m)", "English (lb/in)"));
    }
    @FXML
    //Method for button click
    protected void onButtonClick() {
        double weightValue = Double.parseDouble(weight.getText());
        double heightValue = Double.parseDouble(height.getText());
        String unit = unitChoice.getValue();
        double bmi=0;
        if ("Metric (kg/m)".equals(unit)) {
            bmi = weightValue / Math.pow(heightValue, 2);
        } else if ("English (lb/in)".equals(unit)) {
            bmi = (weightValue * 703) /*converting lbs to kg*/ / Math.pow(heightValue, 2);
        }
        String status ="";
        //Checking bmi and setting status
        if(bmi<18.5) {
            status="Underweight";
        }
        else if(bmi>=18.5 && bmi<=24.9) {
            status="Normal";
        }
        else if(bmi>=25 && bmi<=29.9) {
            status="Overweight";
        }
        else if(bmi>=30) {
            status="Obese:";
        }
        result.setText(String.format("%s: %.2f", status, bmi));
    }
    //Method for Exit menu item
    @FXML
    protected void handleExit() {
        Platform.exit();  //Exits the application
    }

    //Method for Clear menu item
    @FXML
    protected void handleClear() {
        weight.clear();//Clears the weight text field
        height.clear();// Clears the height text field
        unitChoice.setValue("Metric (kg/m)");// Resets the choice box
        result.setText("");// Clears the result label
    }

    //Method for About menu item
    @FXML
    protected void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About BMI Calculator");
        alert.setHeaderText(null);// removes the header text from the Alert dialog
        alert.setContentText("This is a simple BMI calculator. Enter your weight and height, "
                + "choose the unit system (Metric or English), and press the 'Calculate' button "
                + "to get your BMI and category (Underweight, Normal, Overweight, or Obese).");
        alert.showAndWait();//displays the alert and waits for the user to respond
    }
}
