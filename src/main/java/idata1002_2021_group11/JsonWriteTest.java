package idata1002_2021_group11;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The class Json write test.
 */
class JsonWriteTest {
    /**
     * Write json simple demo.
     *
     * @param filename the filename
     * @throws Exception the exception
     */
    static void writeJsonSimpleDemo(String filename) throws Exception {
        // array that contains all workouts, add a new workout into here
        JSONArray workouts = new JSONArray();
        // One workout
        JSONObject workoutObject = new JSONObject();
        // Antoher workout
        JSONObject workoutObject2 = new JSONObject();

        // name of the workout
        workoutObject.put("workoutName", "Legs");

        // all excercises in one workout
        JSONArray exerciseArraray = new JSONArray();

        // a single excercise
        JSONObject excerciseObject = new JSONObject();

        // a single excercise
        JSONObject excerciseObject2 = new JSONObject();

        // all sets in that excercise
        JSONArray sets = new JSONArray();

        // one set
        JSONObject setObject = new JSONObject();

        // add relevant info into the excercise
        excerciseObject.put("excerciseName", "Squats");
        excerciseObject.put("description", "hardcore leg workout");
        excerciseObject.put("order", "1");

        excerciseObject2.put("excerciseName", "Leg extencion");
        excerciseObject2.put("description", "big legs");
        excerciseObject2.put("order", "2");

        // add the excercise into the array
        exerciseArraray.add(excerciseObject);
        exerciseArraray.add(excerciseObject2);

        // relevant info for the set
        setObject.put("weight", "50");
        setObject.put("repititions", "8");

        JSONObject setObject2 = new JSONObject();

        // relevant info for the set
        setObject2.put("weight", "90");
        setObject2.put("repititions", "6");

        // add set to the set array
        sets.add(setObject);
        sets.add(setObject2);

        // add the sets into the excercise
        excerciseObject.put("sets", sets);
        excerciseObject2.put("sets", sets);

        // att excercises into the workout
        workoutObject.put("excercises", exerciseArraray);

        // add the workouts into the workouts array
        workouts.add(workoutObject);
        workouts.add(workoutObject2);


        // write to file
        Files.write(Paths.get(filename), workouts.toJSONString().getBytes());
    }
}
