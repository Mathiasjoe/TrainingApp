package idata1002_2021_group11;


/**
 * This class is responsible for making training related calculations.
 */
public class Calculator {

    /**
     * Calculates and sets the max lift of the given exercise based on the weight and repetitions performed.
     * Uses the Epley formula, and is most accurate in low rep ranges (1-6 repetitions).
     *
     * @param exercise The exercise for which the max lift will be changed.
     * @param weight The weight lifted.
     * @param repetitions The repetitions performed.
     */
    public void calculateAndSetMaxLift(Exercise exercise, float weight, int repetitions) {
        float maxLift;

        if (exercise == null) {
            throw new IllegalArgumentException("Failed to calculate max lift, exercise can not be null...");
        } else if (weight < 0) {
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
            exercise.setMaxLift(maxLift);
        }
    }
}
