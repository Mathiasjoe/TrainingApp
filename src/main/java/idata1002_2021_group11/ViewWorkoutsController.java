package idata1002_2021_group11;

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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ViewWorkoutsController implements Initializable {
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
    /**
     * The Main text box.
     */


    @FXML
    private TableColumn<Exercise, String> workoutColum;
    @FXML
    private TableColumn<Exercise, String> setsColum;
    @FXML
    private TableColumn<Exercise, String> repsColum;
    @FXML
    private TableColumn<Exercise, String> weightColum;
    @FXML
    private TableColumn<Exercise, String> isCompletedColumn;
    @FXML
    private TableView viewWorkout;


    @FXML
    private TextField enterRepsField;
    @FXML
    private TextField enterWeightField;
    @FXML
    private TextField enterSetsField;
    @FXML
    private TextField enterWorkoutField;

    private WorkoutCollection collection;

    private WarningDialogFactory warningDialogFactory;

    private Set set;
    private Exercise exercise;
    private Workout workout;
    private boolean isCompleted;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warningDialogFactory = WarningDialogFactory.getInstance();
        this.collection = new WorkoutCollection();

        this.workoutColum.setCellValueFactory(new PropertyValueFactory<>("workoutName"));
        this.setsColum.setCellValueFactory(new PropertyValueFactory<>("sets"));
        this.repsColum.setCellValueFactory(new PropertyValueFactory<>("reps"));
        this.weightColum.setCellValueFactory(new PropertyValueFactory<>("weight"));
        this.isCompletedColumn.setCellValueFactory(new PropertyValueFactory<>("isCompleted"));

        for (int i = 0; i < this.collection.getWorkouts().size(); i++) {
            viewWorkout.getItems().addAll(this.collection.getWorkouts().get(i).getExercises());
        }

        enterRepsField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Integer.parseInt(newValue);
                }
            } catch (NumberFormatException e) {
                enterRepsField.setText(oldValue);
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

        enterSetsField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Integer.parseInt(newValue);
                }
            } catch (NumberFormatException e) {
                enterSetsField.setText(oldValue);
            }
        });
    }

    /**
     * Returns to the main menu scene.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void returnToMainScene(ActionEvent event) throws IOException {
        URL createReturnMainMenu = getClass().getClassLoader().getResource("application.fxml");

        assert createReturnMainMenu != null;
        Parent root = FXMLLoader.load(createReturnMainMenu);

        Scene createReturnMainMenuScene = new Scene(root);
        Stage createReturnMainMenuWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        root.getStylesheets().add("trainingApp.css");
        createReturnMainMenuWindow.setScene(createReturnMainMenuScene);
        createReturnMainMenuWindow.show();
    }

    /**
     * Adds a workout session to the list of workouts
     * User enters a string for workout name, number for sets, reps and weight.
     * if incorrect values are entered, user gets an alert.
     */
    @FXML
    public void addWorkoutToList(ActionEvent event) {

        this.workoutColum.setCellValueFactory(new PropertyValueFactory<>("workoutName"));
        this.setsColum.setCellValueFactory(new PropertyValueFactory<>("sets"));
        this.repsColum.setCellValueFactory(new PropertyValueFactory<>("reps"));
        this.weightColum.setCellValueFactory(new PropertyValueFactory<>("weight"));

        try {
            Exercise exercise = new Exercise(enterWorkoutField.getText(),
                    Integer.parseInt(enterSetsField.getText()),
                    Integer.parseInt(enterRepsField.getText()),
                    Float.parseFloat(enterWeightField.getText()));

            viewWorkout.getItems().add(exercise);

            Workout workout = new Workout(enterWorkoutField.getText(), "", LocalDate.now());
            workout.addExercise(exercise);
            this.collection.newWorkout(workout);
        } catch (NumberFormatException numberFormatException) {
            Alert alert = warningDialogFactory.createWorkoutsInvalidInputDialog();

            alert.showAndWait();
        }


        enterWorkoutField.clear();
        enterSetsField.clear();
        enterRepsField.clear();
        enterWeightField.clear();

        viewWorkout.refresh();

    }

    /**
     * Removes a workout from the list of workouts.
     * If user does not select before pressing button, show alert.
     */
    @FXML
    public void removeWorkoutFromList(ActionEvent event) {
        var temp = viewWorkout.getSelectionModel().getSelectedItem();
        viewWorkout.getItems().removeAll(temp);

        viewWorkout.getSelectionModel().getFocusedIndex();

        Exercise e = (Exercise) temp;
        //TODO: deletion currently displays alert even if deleted correctly.
        for (int i = 0; i < this.collection.getWorkouts().size(); i++) {
            if (this.collection.getWorkouts().get(i).getExercises().contains(e)) {
                this.collection.removeWorkout(this.collection.getWorkouts().get(i));
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("No values selected");
                alert.setContentText("You need to select an item from the list before deleting.");

                //Styling
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add("trainingApp.css");;
                dialogPane.getStyleClass().add("customDialog");

                alert.showAndWait();
            }
        }

        viewWorkout.refresh();
    }

    /**
     * Toggles a workout from list as completed or not.
     * If user does not select before pressing button, show alert.
     */
    @FXML
    public void setCompleted(ActionEvent event) {
        try {
            var temp = viewWorkout.getSelectionModel().getSelectedItem();
            Exercise e = (Exercise) temp;
            e.setCompleted(!e.getIsCompleted());
            this.collection.updateFile();
            viewWorkout.refresh();
        } catch (NullPointerException nullPointerException) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No values selected");
            alert.setContentText("You need to select an item from the list before \ntoggling completion");

            //Styling
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("trainingApp.css");;
            dialogPane.getStyleClass().add("customDialog");

            alert.showAndWait();
        }
    }



}
