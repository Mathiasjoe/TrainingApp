package idata1002_2021_group11;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.fail;

public class TestExercise {

    @DisplayName("Test the creation of an Exercise object with valid argument.")
    @Test
    public void testSuccessfulCreationOfExercise() {
        try {
            Exercise exercise = new Exercise("squat");
            assert true;
        } catch (IllegalArgumentException iae) {
            fail("Exception not expected.");
        }
    }

    @Test
    public void testUnsuccessfulCreationOfExercise() {
        try {
            Exercise exercise = new Exercise(null);
            fail("Expected exception.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

}
