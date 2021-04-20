package idata1002_2021_group11;

import org.junit.jupiter.api.Test;
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
            fail("Failed to create workout. Exception not expected");
        }
    }
    @DisplayName("Test the creation of an Workout object with invalid argument.")
    @Test
    public void unSuccessfullyAddWorkoutTest() {
        LocalDate date = LocalDate.now();
        try {
            new Workout( null, "null", null);
            fail("Expected an exception to be thrown");
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }

    @DisplayName("Test to add rating ut with valid arguments")
    @Test
    public void successfullyAddRating() {
        LocalDate date = LocalDate.now();

        try {
            Workout workout =  new Workout("Legs", "Badass workout", date);
            workout.setRating(2);
            assert true;
        } catch (IllegalArgumentException e) {
            fail("Not expecting an exception here");
        }

    }

    @DisplayName("Test to add rating ut with invalid arguments")
    @Test
    public void unSuccessfullyAddRating() {
        LocalDate date = LocalDate.now();

        try {
            Workout workout =  new Workout("Legs", "Badass workout", date);
            workout.setRating(-1);
            fail("Should not be possible to set a negative rating");
        } catch (IllegalArgumentException e) {
            assert true;
        }

    }

    @DisplayName("Test to add exercise with valid arguments")
    @Test
    public void successfullyAddExercise() {
        LocalDate date = LocalDate.now();
        try {
            Workout workout =  new Workout("Legs", "Badass workout", date);
            workout.addExercise(new Exercise("Legs"));

            assertEquals(1, workout.getExercises().size());
        } catch (IllegalArgumentException e) {
            fail("Failed to add exercise");
        }

    }

    @DisplayName("Test to add exercise with invalid arguments")
    @Test
    public void unSuccessfullyAddExercise() {
        LocalDate date = LocalDate.now();
        try {
            Workout workout =  new Workout("Legs", "Badass workout", date);
            workout.addExercise(null);

            fail("Exception was expected");
        } catch (IllegalArgumentException e) {
            assert true;
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
