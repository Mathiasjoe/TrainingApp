package idata1002_2021_group11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestExercise {

    private Set set;
    private Exercise testExercise;

    @BeforeEach
    public void initTests() {
        set = new Set(50, 10);
        testExercise = new Exercise("bench");
        testExercise.addSet(set);
    }

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

    @DisplayName("Tests the creation of an Exercise object with null as argument.")
    @Test
    public void testUnsuccessfulCreationOfExercise() {
        try {
            Exercise exercise = new Exercise(null);
            fail("Expected exception.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

    @DisplayName("Test editExercise method with valid arguments.")
    @Test
    public void testEditExerciseSuccessfully() {
        try {
            testExercise.editExercise("squat");
            assertEquals("squat", testExercise.getName());
        } catch (IllegalArgumentException iae) {
            fail("Exception not expected.");
        }
    }

    @DisplayName("Test editExercise method with null argument.")
    @Test
    public void testEditExerciseUnsuccessfully() {
        try {
            testExercise.editExercise(null);
            fail("Exception expected.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

    @DisplayName("Test removeSet method with null argument.")
    @Test
    public void testRemoveSetUnsuccessfully() {
        try {
            testExercise.removeSet(null);
            fail("Exception expected");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

    @DisplayName("Tests the editSet method with valid arguments.")
    @Test
    public void testEditSetSuccessfully() {
        try {
            testExercise.editSet(set, 60, 8);
            assertEquals(60, set.getWeight());
        } catch (IllegalArgumentException iae) {
            fail("Exception not expected.");
        }
    }

    @DisplayName("Tests the editSet method with null set.")
    @Test
    public void testEditSetWithNullSet() {
        try {
            testExercise.editSet(null, 60, 8);
            fail("Exception expected");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

    @DisplayName("Tests the editSet method with negative repetitions.")
    @Test
    public void testEditSetWithNegativeReps() {
        try {
            testExercise.editSet(set, 60, -1);
            fail("Exception expected.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

}
