package idata1002_2021_group11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * The type Premade workout controller.
 */
public class PremadeWorkoutController implements Initializable {

    @FXML private TableView<Workout> tableView;
    @FXML private TableColumn<Workout, String> exerciseColumn;
    @FXML private TableColumn<Workout, String> descriptionColumn;

    private Controller controller;

    /**
     * Initialize the tables.
     *
     * @param url the url
     * @param rb  the rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        controller = new Controller();
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("WorkoutName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));


        tableView.setItems(getExercises());
    }

    /**
     * Create an observable list of premade workouts
     *
     * @return the observable list
     */
    public ObservableList<Workout> getExercises(){

        ObservableList<Workout> exercises = FXCollections.observableArrayList();
        exercises.add(new Workout("Benchpress", "A Push-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Flies", "A Push-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Triceps Extension", "A Push-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Pull ups", "A Pull-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Deadlift", "A Pull-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Barbel row", "A Pull-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Squats", "A Leg-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Calf raises", "A Leg-workout Exercise", LocalDate.now()));
        exercises.add(new Workout("Leg extension", "A Leg-workout Exercise", LocalDate.now()));

        return exercises;
    }

    /**
     * Returns to the main menu scene.
     *
     * @param event the event that happens when the button is pressed
     * @throws IOException the io exception
     */
    @FXML public void returnToMainScene(ActionEvent event) throws IOException
    {
        controller.returnToMainScene(event);
    }
}
