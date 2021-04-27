package idata1002_2021_group11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewCalculatorController implements Initializable {


    @FXML
    private TextField enterRepetitionsField;

    @FXML
    private TextField enterWeightField;

    @FXML
    private TextField resultField;

    private Calculator calculator;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calculator = new Calculator();
    }

    public void calculateMaxLift() {
        try {
            float result = calculator.calculateAndSetMaxLift(Float.parseFloat(enterWeightField.getText()),
                    Integer.parseInt(enterRepetitionsField.getText()));
            String stringResult = String.valueOf(result);
            resultField.setText(stringResult);
        } catch (NumberFormatException numberFormatException) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.showAndWait();
        }
    }

    /**
     * Returns to the main menu scene.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML public void returnToMainScene(ActionEvent event) throws IOException
    {
        URL createReturnMainMenu = getClass().getClassLoader().getResource("application.fxml");

        assert createReturnMainMenu != null;
        Parent root = FXMLLoader.load(createReturnMainMenu);

        Scene createReturnMainMenuScene = new Scene(root);
        Stage createReturnMainMenuWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.getStylesheets().add("trainingApp.css");
        createReturnMainMenuWindow.setScene(createReturnMainMenuScene);
        createReturnMainMenuWindow.show();

    }

}
