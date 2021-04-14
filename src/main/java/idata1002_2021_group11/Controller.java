package idata1002_2021_group11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller  {
  public Button createWorkoutButton;
  public Button premadeWorkoutButton;
  public Button calculatorButton;
  public TextArea mainTextBox;

  private Set set;
  private Exercise exercise;
  private Workout workout;


 public Controller()
 {
   this.set = new Set(80, 1);
   this.exercise = new Exercise("Ultimate workout edition");
   this.workout = new Workout("Nice", "Nice", LocalDate.now());
 }


  /**
   * Switches to the create workout scene
   *
   * @param event
   * @throws IOException
   */


  @FXML
  public void switchToCreateWorkoutButton(ActionEvent event) throws IOException {
    URL createWorkOut = getClass().getClassLoader()
        .getResource("createWorkout.fxml");

    assert createWorkOut != null;
    Parent root = FXMLLoader.load(createWorkOut);

    Scene createWorkOutScene = new Scene(root);

    Stage createWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    createWindow.setScene(createWorkOutScene);
    createWindow.show();
  }

  /**
   * Switches to the Premade workout scene.
   *
   * @param event
   * @throws IOException
   */
  @FXML
  public void switchToPremadeWorkoutButton(ActionEvent event) throws IOException {

    URL createPremadeWorkout = getClass().getClassLoader().getResource("premadeWorkout.fxml");

    assert createPremadeWorkout != null;
    Parent root = FXMLLoader.load(createPremadeWorkout);

    Scene createPremadeWorkoutScene = new Scene(root);
    Stage createPremadeWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    createPremadeWindow.setScene(createPremadeWorkoutScene);
    createPremadeWindow.show();
  }

  /**
   * Switches to the calculator scene.
   *
   * @param event
   * @throws IOException
   */
  @FXML
  public void openCalculatorButton(ActionEvent event) throws IOException {

    URL createCalculator = getClass().getClassLoader().getResource("calculateWorkout.fxml");

    assert createCalculator != null;
    Parent root = FXMLLoader.load(createCalculator);

    Scene createCalculatorScene = new Scene(root);
    Stage createCalculatorWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    createCalculatorWindow.setScene(createCalculatorScene);
    createCalculatorWindow.show();
  }

  /**
   * Switches to the calculate bench press scene.
   *
   * @param event
   * @throws IOException
   */
  @FXML
  public void switchToCalculateBenchPress(ActionEvent event) throws IOException {
    URL createCalculateBenchPress = getClass().getClassLoader().getResource("legg til her Framtidig FXML scene navn.fxml");

    assert createCalculateBenchPress != null;
    Parent root = FXMLLoader.load(createCalculateBenchPress);

    Scene createCalculatorBenchPressScene = new Scene(root);
    Stage createCalculateBenchPressWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    createCalculateBenchPressWindow.setScene(createCalculatorBenchPressScene);
    createCalculateBenchPressWindow.show();
  }

  /**
   * Returns to the main menu scene.
   *
   * @param event
   * @throws IOException
   */
  @FXML public void returnToMainScene(ActionEvent event) throws IOException
  {
    URL createReturnMainMenu = getClass().getClassLoader().getResource("application.fxml");

    assert createReturnMainMenu != null;
    Parent root = FXMLLoader.load(createReturnMainMenu);

    Scene createReturnMainMenuScene = new Scene(root);
    Stage createReturnMainMenuWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

    root.getStylesheets().add("TrainingApp.css");
    createReturnMainMenuWindow.setScene(createReturnMainMenuScene);
    createReturnMainMenuWindow.show();

  }


}