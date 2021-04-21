package idata1002_2021_group11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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


    /**
     * Initialize the tables.
     *
     * @param url the url
     * @param rb  the rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("WorkoutName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));


        tableView.setItems(getExercises());
    }

    /**
     * Create an observable list of workouts
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
     * Return to main scene.
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
