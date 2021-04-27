package idata1002_2021_group11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

/**
 * The type Controller.
 */
public class Controller  {
    /**
     * The Create workout button.
     */
    public Button createWorkoutButton;
    /**
     * The Premade workout button.
     */
    public Button premadeWorkoutButton;
    /**
     * The Calculator button.
     */
    public Button calculatorButton;
    public TextArea mainTextBox;
    public TextField usernameField;
    public Label usernameDetails;
    public Label dateDetails;
    public Label workoutDetails;
    public Button applybutton;


//    @Override
//    public void initialize(URL url, ResourceBundle rb){
//
//    }

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public void initialize()
    {
        // Skal det være sånn eller med pop up vindue som er lagt til i stede?

      // mainTextBox.setText("Hello, "+ System.getProperty("user.name") + "\n\n" + "Todays date: " + formatter.format(date));
    }

    /**
     * Switches to the create workout scene
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
  public void switchToCreateWorkoutButton(ActionEvent event) throws IOException {
    URL createWorkOut = getClass().getClassLoader()
        .getResource("createWorkout.fxml");

    assert createWorkOut != null;
    Parent root = FXMLLoader.load(createWorkOut);

    Scene createWorkOutScene = new Scene(root);

    Stage createWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    root.getStylesheets().add("trainingApp.css");
    createWindow.setScene(createWorkOutScene);
    createWindow.show();

    }

    /**
     * Switches to the Premade workout scene.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
  public void switchToPremadeWorkoutButton(ActionEvent event) throws IOException {

    URL createPremadeWorkout = getClass().getClassLoader().getResource("premadeWorkout.fxml");

    assert createPremadeWorkout != null;
    Parent root = FXMLLoader.load(createPremadeWorkout);

    Scene createPremadeWorkoutScene = new Scene(root);
    Stage createPremadeWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    root.getStylesheets().add("trainingApp.css");
    createPremadeWindow.setScene(createPremadeWorkoutScene);
    createPremadeWindow.show();
  }

  /**
     * Switches to the calculator scene.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
  public void openCalculatorButton(ActionEvent event) throws IOException {

    URL createCalculator = getClass().getClassLoader().getResource("calculateWorkout.fxml");

    assert createCalculator != null;
    Parent root = FXMLLoader.load(createCalculator);

    Scene createCalculatorScene = new Scene(root);
    Stage createCalculatorWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    root.getStylesheets().add("trainingApp.css");
    createCalculatorWindow.setScene(createCalculatorScene);
    createCalculatorWindow.show();
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

  @FXML
  public void usernamePopUp(ActionEvent event) throws IOException
  {
      Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DetailsPopUp.fxml"));

      Scene popUpScene = new Scene(root);

      Stage popUpStage = new Stage();
      popUpStage.setTitle("User Details ..");
      popUpStage.setScene(popUpScene);
      popUpStage.show();

  }

  @FXML public void addUsernameToApp(ActionEvent event)
  {
      //Ein måte å få navne lagra til brukeren kvargang applikasjonen blir slått på
      //tekstField-e blir nullpointexc? Om noen fikser det er det mulig å få ein forklarelse på kvifor?  - Joakim
      usernameDetails.setText(usernameField.getText());

      //Burde egentlig være i konstruktøren men får bare nullpointException
      dateDetails.setText(String.valueOf(LocalDate.now()));

      //Burde legge til ein måte for å vise fram sin "workout" som har blitt valgt fra ein av listene

      Stage exit = (Stage) applybutton.getScene().getWindow();
      exit.close();

  }



}