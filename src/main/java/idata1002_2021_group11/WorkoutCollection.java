package idata1002_2021_group11;

import java.util.ArrayList;

/**
 * The class Workout collection.
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
     * New workout.
     *
     * @param workout the workout
     */
    public void newWorkout(Workout workout) {
        workouts.add(workout);
    }

    /**
     * Remove workout.
     *
     * @param workout the workout
     */
    public void removeWorkout(Workout workout) {
        if(this.workouts.contains(workout)) {
            this.workouts.remove(workout);
        }
    }

    /**
     * Gets workouts.
     *
     * @return the workouts
     */
    public ArrayList<Workout> getWorkouts() {
       return this.workouts;
    }
}
