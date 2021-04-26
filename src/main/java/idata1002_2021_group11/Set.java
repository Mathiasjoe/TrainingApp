package idata1002_2021_group11;

/**
 * The class Set represents a single set of an exercise.
 * It consists of weight and repetitions.
 */
public class Set implements java.io.Serializable {
    private double weight;
    private int repetitions;


    /**
     * Instantiates a new Set.
     *
     * @param weight     The weight used in a set.
     *                   Weight can be negative in case the user uses an assisted machine?
     * @param repetitions The repetitions of the set.
     */
    public Set(double weight, int repetitions) {
        if(repetitions < 0) {
           throw new IllegalArgumentException("Repetitions must be greater than 0");
        }
        this.repetitions = repetitions;
        this.weight = weight;
    }

    /**
     * Returns the weight used in the set.
     *
     * @return Returns the weight used in the set.
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Returns the repetitions of the set.
     *
     * @return Returns the repetitions of the set.
     */
    public int getRepetitions() {
        return this.repetitions;
    }

    /**
     * Sets the repetitions of the set.
     *
     * @param repetitions The new repetitions of the set.
     */
    public void setRepetitions(int repetitions) {
        if(repetitions >= 0) {
            this.repetitions = repetitions;
        } else {
            this.repetitions = 1;
        }
    }

    /**
     * Sets the weight of the set.
     *
     * @param weight The new weight of the set.
     */
    public void setWeight(double weight) {
        if(weight >= 0 ) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }
}
