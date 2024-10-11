package org.example.bmicalculator;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
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
    public void initialize() {
        unitChoice.setItems(FXCollections.observableArrayList("Metric (kg/m)", " English (lb/in)"));
        unitChoice.setValue("Metric (kg/m)");
    }
    @FXML
    protected void onButtonClick() {
        double weightValue = Double.parseDouble(weight.getText());
        double heightValue = Double.parseDouble(height.getText());
        String unit = unitChoice.getValue();
        double bmi=0;
        if ("Metric (kg/m)".equals(unit)) {
            bmi = weightValue / Math.pow(heightValue, 2);
        } else if ("English (lb/in)".equals(unit)) {
            bmi = (weightValue * 703) / Math.pow(heightValue, 2);
        }
        String status = " ";

        if(bmi<18.5) {
            status="Underweight:";
        }
        if(bmi>=18.5 && bmi<=24.9) {
            status="Normal:";
        }
        if(bmi>=25 && bmi<=29.9) {
            status="Overweight:";
        }
        if(bmi>=30) {
            status="Obese:";
        }
        result.setText(String.format("%s: %.2f", status, bmi));

    }
}
