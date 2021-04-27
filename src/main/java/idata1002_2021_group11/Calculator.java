package idata1002_2021_group11;


/**
 * This class is responsible for making training related calculations.
 */
public class Calculator {

    /**
     * Calculates and returns the max lift based on the weight and repetitions performed.
     * Uses the Epley formula, and is most accurate in low rep ranges (1-6 repetitions).
     *
     * @param weight The weight lifted.
     * @param repetitions The repetitions performed.
     */
    public float calculateAndSetMaxLift(float weight, int repetitions) {
        float maxLift;
        if (weight < 0) {
            throw new IllegalArgumentException("Failed to calculate max lift, weight must be a positive number...");
        } else if (repetitions <= 0) {
            throw new IllegalArgumentException("Failed to calculate max lift, repetitions must be a positive number...");
        } else {
            if (repetitions == 1) {
                maxLift = weight;
            } else {
                // Epley formula
                maxLift = weight * (1 + (repetitions / 30f));
            }
            return maxLift;
        }
    }
}
