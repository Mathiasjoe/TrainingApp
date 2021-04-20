package idata1002_2021_group11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {

    private Exercise exercise = new Exercise("Benkpress");
    private Calculator calculator = new Calculator();

    @DisplayName("Test the calculateAndSetMax method with correct arguments.")
    @Test
    public void testCalculateAndSetMaxLiftCorrectly() {
        try {
            calculator.calculateAndSetMaxLift(exercise, 90, 5);
            assertEquals(105, exercise.getMaxLift());
        } catch (IllegalArgumentException iae) {
            fail("Exception not expected.");
        }
    }

    @DisplayName("Test the calculateAndSetMaxLift method with zero repetitions.")
    @Test
    public void testCalculateAndSetMaxLiftWithInvalidRepetitions() {
        try {
            calculator.calculateAndSetMaxLift(exercise,90,0);
            fail("Expected exception.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

    @DisplayName("Test the calculateAndSetMaxLift method with negative weight.")
    @Test
    public void testCalculateAndSetMaxLiftWithInvalidWeight() {
        try {
            calculator.calculateAndSetMaxLift(exercise,-10,5);
            fail("Expected exception.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

    @DisplayName("Test the calculateAndSetMaxLift method with null exercise.")
    @Test
    public void testCalculateAndSetMaxLiftWithInvalidExercise() {
        try {
            calculator.calculateAndSetMaxLift(null,90,5);
            fail("Expected exception.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }
}
