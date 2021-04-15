package idata1002_2021_group11;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class Exercise represents a single exercise. Initially,
 * the exercise has no sets, these will be added later once the user creates a workout.
 * The exercise also has a field maxLift, that is initially 0, but can be set later.
 */
public class Exercise {

    private String name;

    private ArrayList<Set> sets = new ArrayList<>();

    private float maxLift = 0;

    private int order;

    /**
     * Instantiates a new Exercise.
     * The name of the exercise will be set.
     *
     * @param name The name of the exercise.
     */
    public Exercise(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        } else if(name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        } else {
            this.name = name;
        }

    }


    /**
     * Gets name the name of the exercise.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the max lift of the exercise. Returns 0 if max lift has not been set.
     *
     * @return The max lift
     */
    public float getMaxLift() {
        return maxLift;
    }

    /**
     * Edits the exercise name.
     *
     * @param name The new name of the exercise.
     */
    public void editExercise(String name) {
        if(name == null) {
            throw new IllegalArgumentException(("Name can't be null"));
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        } else {
            this.name = name;
        }
    }


    /**
     * Adds a set to the exercise.
     *
     * @param set The new set to be added to the exercise.
     */
    public void addSet(Set set) {
        if(set == null) {
            throw new IllegalArgumentException("Set can't be null");
        } else {
            this.sets.add(set);
        }
    }

    /**
     * Removes a set of the exercise.
     *
     * @param set The set to be removed.
     */
    public void removeSet(Set set) {
        if(set == null) {
            throw new IllegalArgumentException("Set cannot be null.");
        } else if(this.sets.contains(set)) {
            this.sets.remove(set);
        } else {
            throw new IllegalArgumentException("Set does not exist");
        }
    }

    /**
     * Edits a set in the exercise.
     *
     * @param set         The set to be edited.
     * @param weight      The new weight of the set.
     * @param repetitions The new repetitions of the set.
     */
    public void editSet(Set set, float weight, int repetitions) {
        boolean isRunning = true;

        if (set == null) {
            throw new IllegalArgumentException("Set cannot be null.");
        } else if (repetitions <= 0) {
            throw new IllegalArgumentException("Repetitions of a set cannot be lesser or equal to 0.");
        } else if (this.sets.contains(set)) {
            Iterator<Set> it = sets.iterator();
            while(isRunning && it.hasNext() ) {
                Set element = it.next();
                if(element.equals(set)) {
                    element.setRepetitions(repetitions);
                    element.setWeight(weight);
                    isRunning = false;
                }

            }
        } else {
            throw new IllegalArgumentException("The set does not exist in this exercise.");
        }
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(int order) {
        if(order > 0) {
            this.order = order;
        } else {
            throw new IllegalArgumentException("Order cannot be a negative number");
        }
    }

    /**
     * Sets the max lift of the exercise.
     *
     * @param maxLift The max lift
     */
    public void setMaxLift(float maxLift) {
        if (maxLift > 0) {
            this.maxLift = maxLift;
        } else {
            throw new IllegalArgumentException("maxLift must be a positive number...");
        }
    }
}
