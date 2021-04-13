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

        if(name.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank");
        }
        if(description.isBlank()) {
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

    public String getWorkoutName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public int getRating() {
        return this.rating;
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
    public void addExercise(Exercise exercise) {
        if (exercise == null) {
           throw new IllegalArgumentException("Excercise can't be null");
        }
        this.exercises.add(exercise);
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
            throw new IllegalArgumentException("Excercise does not excist");
        }
    }


    /**
     * Sets rating to the workout.
     * The rating have to be between (or equal to) one and six to be a valid input.
     *
     * @param rating the rating
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
     * @param date the date
     */
    public void setDate(LocalDate date) {
        if(date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

}
