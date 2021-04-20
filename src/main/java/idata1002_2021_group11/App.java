package idata1002_2021_group11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
 */
import java.net.URL;
//import static idata1002_2021_group11.JsonWriteTest.writeJsonSimpleDemo;

public class App extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    URL url = getClass().getClassLoader()
        .getResource("application.fxml");

    Parent root = FXMLLoader.load(url);

    Scene scene = new Scene(root);

    stage.setTitle("Training app");
    //stage.initStyle(StageStyle.UNDECORATED);
    stage.getIcons().add(new Image("posing.png"));
    scene.getStylesheets().add("TrainingApp.css");
    stage.setScene(scene);
    stage.show();
  }



    /**
     * Writing to the file example

    public static void main(String[] args) throws Exception {
        // test to write to file
        writeJsonSimpleDemo("example2.json");
    }
    */


    /**
     * Reading from the file example
     * @param args
     * @throws Exception
     */
//    public static void main(String[] args) throws Exception {
//        JSONArray jsonArray = (JSONArray) readJsonSimpleDemo("example2.json");
//
//        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
//
//        System.out.println(jsonObject);
//    }
//
//    public static Object readJsonSimpleDemo(String filename) throws Exception {
//        FileReader reader = new FileReader(filename);
//        JSONParser jsonParser = new JSONParser();
//        return jsonParser.parse(reader);
//    }


    public static void main(String[] args)
    {
      launch();
    }







}