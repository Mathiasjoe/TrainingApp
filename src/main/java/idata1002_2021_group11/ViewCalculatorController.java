package idata1002_2021_group11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
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

    @FXML
    private TextArea aboutText;

    private Calculator calculator;

    private WarningDialogFactory warningDialogFactory;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warningDialogFactory = WarningDialogFactory.getInstance();
        calculator = new Calculator();
        aboutText.setText("This calculator takes two inputs to calculate your one repetition maximum on\n" +
                "any given exercise. Your one-rep max is the max weight you can lift for a single\n" +
                "repetition for a given exercise. This calculator uses the epley-formula and is\n" +
                "most accurate when performing 2 - 6 repetitions. \n \n" +
                "It can be useful to know your one-rep max on a given exercise so that you can\n" +
                "intelligently choose which weight to work with for the best progression.\n" +
                "For example, if you want to do 5 repetitions for 3 sets, you might want to\n" +
                "use about 80 - 85 ‰ of your one-rep max if you want optimal strength\n" +
                        "progression.");

        enterRepetitionsField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Integer.parseInt(newValue);
                }
            } catch (NumberFormatException e) {
                enterRepetitionsField.setText(oldValue);
            }
        });

        enterWeightField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Float.parseFloat(newValue);
                }
            } catch (NumberFormatException e) {
                enterWeightField.setText(oldValue);
            }
        });

    }

    /**
     * Takes two inputs from the user, weight and repetitions, and uses them to calculate and display the one-rep
     * max lift.
     */
    public void calculateMaxLift() {
        try {
            float result = calculator.calculateAndSetMaxLift(Float.parseFloat(enterWeightField.getText()),
                    Integer.parseInt(enterRepetitionsField.getText()));
            String stringResult = String.valueOf(result);
            resultField.setText(stringResult);
        } catch (NumberFormatException numberFormatException) {
            Alert alert = warningDialogFactory.createCalculatorEmptyFieldsDialog();
            alert.showAndWait();
        } catch (IllegalArgumentException illegalArgumentException) {
            Alert alert = warningDialogFactory.createCalculatorInvalidInputDialog();
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
