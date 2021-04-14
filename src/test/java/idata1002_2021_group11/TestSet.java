package idata1002_2021_group11;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestSet {

    @DisplayName("Test the creation of an Set object with valid argument.")
    @Test
    public void successfullyAddSetTest() {
        try {
            Set set = new Set( 25.8, 8);
            assertEquals(8, set.getRepetitions());
            assertEquals(25.8, set.getWeight());

        } catch (IllegalArgumentException e) {
            fail("Exception not expected");
        }
    }
    @DisplayName("Test the creation of an Exercise object with invalid argument.")
    @Test
    public void unSuccessfullyAddSetTest() {
        try {
            Set set = new Set(-102,-12);
            // repetitions should not be able to be a negative number
            assertEquals(-12, set.getRepetitions());
            assertEquals(-102, set.getWeight());
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
}
