package idata1002_2021_group11;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Workout.
 */
public class Workout {

    private String name;
    private String description;
    private ArrayList<Exercise> exercises;
    private int rating;
    private LocalDate date;

    /**
     * Instantiates a new Workout.
     *
     * @param name        the name
     * @param description the description
     * @param date        the date
     */
    public Workout(String name, String description, LocalDate date) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.exercises = new ArrayList<>();
    }

    /**
     * Gets exercises.
     *
     * @return the exercises
     */
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    /**
     * Add a new exercise to the Workout register.
     *
     * @param exercise the exercise
     */
    public void newExercise(Exercise exercise){
        if(exercise != null){
            this.exercises.add(exercise);
        }
    }

    /**
     * Remove exercise from the Workout register.
     *
     * @param exercise the exercise
     */
    public void removeExercise(Exercise exercise) {
        if (this.exercises.contains(exercise)) {
            this.exercises.remove(exercise);
        } else {
            System.out.println("This exercise does not exist");
        }
    }


    /**
     * Sets rating to the workout.
     * The rating have to be between (or equal to) one and six to be a valid input.
     *
     * @param rating the rating
     */
    public void setRating(int rating) {
        if(this.rating >= 1 && this.rating <= 6){
            this.rating = rating;
        }else{
            System.out.println("Invalid input");
        }
    }

    /**
     * Sets date for the workout.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
