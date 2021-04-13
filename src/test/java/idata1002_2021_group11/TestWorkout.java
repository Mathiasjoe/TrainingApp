package idata1002_2021_group11;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.time.LocalDate;

public class TestWorkout {


    @DisplayName("Test the creation of an Workout object with valid argument.")
    @Test
    public void successfullyAddWorkoutTest() {
        LocalDate date = LocalDate.now();
        try {
            new Workout("Legs", "Badass workout", date);
            assert true;
        } catch (IllegalArgumentException e) {
            fail(" Failed to create workout. Exception not expected");
        }



    }
    @DisplayName("Test to add rating ut with valid arguments")
    @Test
    public void successfullyAddRating() {
        LocalDate date = LocalDate.now();

        try {
            Workout workout =  new Workout("Legs", "Badass workout", date);
            workout.setRating(5);
            assertEquals(5, workout.getRating());

        } catch (IllegalArgumentException e) {
            fail("Failed to set rating");
        }

    }

    @DisplayName("Test to add exercise with valid arguments")
    @Test
    public void successfullyAddExercise() {
        LocalDate date = LocalDate.now();
        try {
            Workout workout =  new Workout("Legs", "Badass workout", date);
            Exercise excercise = new Exercise("Legs");
            workout.addExercise(excercise);
            assertEquals(1, workout.getExercises().size());
        } catch (IllegalArgumentException e) {
            fail("Failed to add exercise");
        }

    }

    @DisplayName("Tests the getters in the workout class")
    @Test
    public void successfullyGetWorkoutTest() {
        LocalDate date = LocalDate.now();

        try {
            Workout workout = new Workout("Legs", "Badass workout", date);
            workout.setRating(5);

            assertEquals("Legs", workout.getWorkoutName());
            assertEquals("Badass workout", workout.getDescription());
            assertEquals(date, workout.getDate());
            assertEquals(5, workout.getRating());
        } catch (IllegalArgumentException e) {
            fail("Failed to get all values");
        }
    }
}
