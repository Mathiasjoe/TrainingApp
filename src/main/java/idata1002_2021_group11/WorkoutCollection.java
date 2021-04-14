package idata1002_2021_group11;

import java.util.ArrayList;

/**
 * The class WorkoutCollection represents a collection of workouts.
 */
public class WorkoutCollection {
    private ArrayList<Workout> workouts;


    /**
     * Instantiates a new Workout collection.
     */
    public WorkoutCollection() {
        this.workouts = new ArrayList<>();
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
    }

    /**
     * Removes a workout from the collection.
     *
     * @param workout The workout to be removed from the collection.
     */
    public void removeWorkout(Workout workout) {
        if(this.workouts.contains(workout)) {
            this.workouts.remove(workout);
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
