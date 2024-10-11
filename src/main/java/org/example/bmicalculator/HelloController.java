package org.example.bmicalculator;

import javafx.fxml.FXML;
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
    protected void onButtonClick() {
        double weigt_kg = Double.parseDouble(weight.getText());
        double h = Double.parseDouble(height.getText());
        double metric = weigt_kg / Math.pow(h, 2);
        if(metric<18.5) {
            result.setText("Underweight:"+String.valueOf(metric));
        }
        if(metric>=18.5 && metric<=24.9) {
            result.setText("Normal:"+String.valueOf(metric));
        }
        if(metric>=25 && metric<=29.9) {
            result.setText("Overweight:"+String.valueOf(metric));
        }
        if(metric>=30) {
            result.setText("Obese:"+String.valueOf(metric));
        }

    }
}
