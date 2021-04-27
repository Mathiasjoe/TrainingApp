package idata1002_2021_group11;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class Exercise represents a single exercise. Initially,
 * the exercise has no sets, these will be added later once the user creates a workout.
 * The exercise also has a field maxLift, that is initially 0, but can be set later.
 */
public class Exercise implements java.io.Serializable
{
    // Fields...
    private String workoutName; // The name of the workout exercise
    private int sets; // The number of sets in a workout
    private int reps; // The number of repetitions in a set
    private float weight; // The weight to be lifted in the workout exercise
    private boolean isCompleted;


    private ArrayList<Set> setse = new ArrayList<>(); // The list of sets
    private float maxLift = 0; // The maximum lift for a exercise/workout
    private int order; // The number to order

    /**
     * Instantiates a new Exercise.
     * The name of the exercise will be set.
     *
     * @param workoutName The name of the exercise.
     * @param sets The number of sets.
     * @param reps The number of repetitions in a set
     * @param weight The weight to be lifted
     */
    public Exercise(String workoutName, int sets, int reps, float weight)
    { // Constructor...
        this.workoutName = workoutName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        isCompleted = false;

    }

    /**
     * Gets the number of sets in an workout.
     *
     * @return The number of sets to be returned.
     */
    public int getSets()
    {
        return this.sets;
    }

    /**
     * Sets the number of sets in a workout.
     *
     * @param sets The number of sets, to be set in a workout.
     */
    public void setSets(int sets)
    {
        this.sets = sets;
    }

    /**
     * Gets the number of repetitions in a workout.
     *
     * @return The number of repetitions to be returned.
     */
    public int getReps()
    {
        return this.reps;
    }

    /**
     * Sets the name of the workout, aka the workout's name.
     *
     * @param workoutName The name of the workout to be set.
     */
    public void setWorkoutName(String workoutName)
    {
        this.workoutName = workoutName;
    }

    /**
     * Sets the number of repetitions in a workout.
     *
     * @param reps sets the number of repetitions in a set.
     */
    public void setReps(int reps)
    {
        this.reps = reps;
    }

    /**
     * Gets the weight to be lifted in a workout.
     *
     * @return The weight lifted to be returned.
     */
    public float getWeight()
    {
        return this.weight;
    }

    /**
     * Sets the weight to be lifted in a workout.
     *
     * @param weight The weight to be lifted.
     */
    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    /**
     * Gets name the name of the exercise.
     *
     * @return the name
     */
    public String getWorkoutName()
    {
        return this.workoutName;
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
     * Edits the exercise name. if no name is set or the name is blank an
     * exception will be thrown
     *
     * @param name The new name of the exercise.
     */
    public void editExercise(String name) {
        if(name == null) {
            throw new IllegalArgumentException(("Name can't be null"));
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        } else {
            this.workoutName = workoutName;
        }
    }


    /**
     * Adds a set to the exercise. if the object set is null, an exception will be thrown.
     *
     * @param set The new set to be added to the exercise.
     */
    public void addSet(Set set) {
        if(set == null) {
            throw new IllegalArgumentException("Set can't be null");
        } else {
            this.setse.add(set);
        }
    }
    /**
     * Sets exercise to completed.
     *
     */
    public void setCompleted(boolean value) {
        this.isCompleted = value;
    }

    /**
     *
     * @return isCompleted
     */
    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    /**
     * Removes a set of the exercise. if a set is null or a set is not found
     * an exception will be thrown.
     *
     * @param set The set to be removed.
     */
    public void removeSet(Set set) {
        if(set == null) {
            throw new IllegalArgumentException("Set cannot be null.");
        } else if(this.setse.contains(set)) {
            this.setse.remove(set);
        } else {
            throw new IllegalArgumentException("Set does not exist");
        }
    }

    /**
     * Edits a set in the exercise.
     *
     * @param set         The set to be edited.
     * @param weight      The new weight (lifted) of the set.
     * @param repetitions The new repetitions of the set.
     */
    public void editSet(Set set, float weight, int repetitions) {
        boolean isRunning = true;

        if (set == null)  {
            throw new IllegalArgumentException("Set cannot be null.");
        } else if (repetitions <= 0)
        {
            throw new IllegalArgumentException("Repetitions of a set cannot be lesser or equal to 0.");
        } else if (this.setse.contains(set))
        {
            Iterator<Set> it = setse.iterator();
            while (isRunning && it.hasNext() )
            {
                Set element = it.next();
                element.setRepetitions(repetitions);
                element.setWeight(weight);
                isRunning = false;
            }
        } else
        {
            throw new IllegalArgumentException("The set does not exist in this exercise.");
        }
    }

    /**
     * Sets order. if the order is a negative number an exception will be thrown
     *
     * @param order the order
     */
    public void setOrder(int order) {
        if (order > 0) {
            this.order = order;
        } else {
            throw new IllegalArgumentException("Order cannot be a negative number");
        }
    }

    /**
     * Sets the max lift of the exercise. if the max lift is a negative number an
     * exception will be thrown.
     *
     * @param maxLift The max lift.
     */
    public void setMaxLift(float maxLift) {
        if (maxLift > 0) {
            this.maxLift = maxLift;
        } else {
            throw new IllegalArgumentException("maxLift must be a positive number...");

        }

    }
}
