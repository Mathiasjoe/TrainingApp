package idata1002_2021_group11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;

/**
 * Represents the start up function of the application
 */
public class App extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    URL url = getClass().getClassLoader().getResource("application.fxml");

    Parent root = FXMLLoader.load(url);

    Scene scene = new Scene(root);

    stage.setTitle("Training app");
    //stage.initStyle(StageStyle.UNDECORATED);
    stage.getIcons().add(new Image("whiteposing.png"));
    scene.getStylesheets().add("trainingApp.css");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args)
    {
      launch();
    }
}