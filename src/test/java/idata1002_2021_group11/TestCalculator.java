package idata1002_2021_group11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {

    private Calculator calculator;

    @BeforeEach
    public void initTests() {
        calculator = new Calculator();
    }

    @DisplayName("Test the calculateAndSetMax method with correct arguments.")
    @Test
    public void testCalculateAndSetMaxLiftCorrectly() {
        try {
            assertEquals(105, calculator.calculateAndSetMaxLift( 90, 5));
        } catch (IllegalArgumentException iae) {
            fail("Exception not expected.");
        }
    }

    @DisplayName("Test the calculateAndSetMaxLift method with zero repetitions.")
    @Test
    public void testCalculateAndSetMaxLiftWithInvalidRepetitions() {
        try {
            calculator.calculateAndSetMaxLift(90,0);
            fail("Expected exception.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }

    @DisplayName("Test the calculateAndSetMaxLift method with negative weight.")
    @Test
    public void testCalculateAndSetMaxLiftWithInvalidWeight() {
        try {
            calculator.calculateAndSetMaxLift(-10,5);
            fail("Expected exception.");
        } catch (IllegalArgumentException iae) {
            assert true;
        }
    }
}
