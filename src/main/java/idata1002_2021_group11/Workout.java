package idata1002_2021_group11;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Workout class represents a list of exercises.
 * The workout has a name, a description and a date.
 */
public class Workout implements java.io.Serializable {

    private String name;
    private String description;
    private ArrayList<Exercise> exercises;
    private int rating;
    private LocalDate date;

    /**
     * Instantiates a new Workout. Initially, the workout has no exercises,
     * these will be added later.
     *
     * @param name        The name of the workout.
     * @param description The description of the workout.
     * @param date        The date of the workout.
     */
    public Workout(String name, String description, LocalDate date) {

        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank");
        }
        if(description == null || description.isBlank()) {
            this.description = "";
        } else {
            this.description = description;
        }

        if(date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.name = name;
        this.date = date;

        this.exercises = new ArrayList<>();
    }

    /**
     * Returns the name of the workout.
     *
     * @return Returns the name of the workout.
     */
    public String getWorkoutName() {
        return this.name;
    }

    /**
     * Returns the description of the workout.
     *
     * @return Returns the description of the workout.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the date of the workout.
     *
     * @return Returns the date of the workout.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Returns the rating of the workout.
     *
     * @return Returns the rating of the workout.
     */
    public int getRating() {
        return this.rating;
    }


    /**
     * Returns all the exercises of the workout as an ArrayList.
     *
     * @return The exercises as an ArrayList.
     */
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    /**
     * Add a new exercise to the Workout register.
     *
     * @param exercise The new exercise to be added.
     */
    public void addExercise(Exercise exercise) {
        if (exercise == null) {
           throw new IllegalArgumentException("Excercise can't be null");
        }
        this.exercises.add(exercise);
    }

    /**
     * Removes an exercise from the Workout register.
     *
     * @param exercise The exercise to be removed.
     */
    public void removeExercise(Exercise exercise) {
        if (this.exercises.contains(exercise)) {
            this.exercises.remove(exercise);
        } else {
            throw new IllegalArgumentException("Excercise does not excist");
        }
    }


    /**
     * Sets rating to the workout.
     * The rating have to be between (or equal to) one and six to be a valid input.
     *
     * @param rating The rating to be set.
     */
    public void setRating(int rating) {
        if (rating >= 1 && rating <= 6) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("rating must be greater or equal to 1 and less or equal to 6");
        }
    }

    /**
     * Sets date for the workout.
     *
     * @param date The date to be set.
     */
    public void setDate(LocalDate date) {
        if(date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

}
