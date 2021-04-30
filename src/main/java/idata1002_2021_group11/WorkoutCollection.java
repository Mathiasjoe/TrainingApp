package idata1002_2021_group11;

import java.io.*;
import java.util.ArrayList;

/**
 * The class WorkoutCollection represents a collection of workouts.
 */
public class WorkoutCollection implements java.io.Serializable {
    private ArrayList<Workout> workouts;

    /**
     * Instantiates a new Workout collection.
     */
    public WorkoutCollection() {

        /// Read from file
        this.workouts = new ArrayList<>();

        ArrayList<Workout> e = null;
        try {
          FileInputStream fileIn = new FileInputStream("workoutCollection.ser");
          ObjectInputStream in = new ObjectInputStream(fileIn);
          e = (ArrayList<Workout>) in.readObject();
          in.close();
          fileIn.close();
        } catch (IOException i) {
          i.printStackTrace();
          return;
        } catch (ClassNotFoundException c) {
          System.out.println("Employee class not found");
          c.printStackTrace();
          return;
        }
        this.workouts.addAll(e);

    }

    /**
     * Adds a new workout to the collection.
     *
     * @param workout The new workout to be added.
     */
    public void newWorkout(Workout workout) {
        if(workout == null) {
            throw new IllegalArgumentException("workout can't be null");
        }
        workouts.add(workout);
        updateFile();
    }

    public void updateFile() {
        try {
          FileOutputStream fileOut = new FileOutputStream("workoutCollection.ser");
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(this.workouts);
          out.close();
          fileOut.close();
          System.out.print("Serialized data is saved in workoutCollection.ser");
        } catch (IOException i) {
          i.printStackTrace();
        }

    }

    /**
     * Removes a workout from the collection.
     *
     * @param workout The workout to be removed from the collection.
     */
    public void removeWorkout(Workout workout) {
        if(this.workouts.contains(workout)) {
            this.workouts.remove(workout);
            updateFile();
        } else {
            throw new IllegalArgumentException("Workout does not exist");
        }
    }

    /**
     * Returns an ArrayList of all the workouts in the collection.
     *
     * @return All the workouts in the collection.
     */
    public ArrayList<Workout> getWorkouts() {
       return this.workouts;
    }
}
