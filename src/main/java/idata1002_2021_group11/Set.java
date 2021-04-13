package idata1002_2021_group11;

/**
 * The class Set.
 */
public class Set {
    private double weight;
    private int repetitions;


    /**
     * Instantiates a new Set.
     *
     * @param weight      the weight. weight can be negative incase the user uses an assisted machine?
     * @param repetitions the repetitions
     */
    public Set(double weight, int repetitions) {
        if(repetitions < 0) {
           throw new IllegalArgumentException("Repetitions must be greater than 0");
        }
        this.repetitions = repetitions;
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }
    public int getRepetitions() {
        return this.repetitions;
    }

    /**
     * Sets repetitions.
     *
     * @param repetitions the repetitions
     */
    public void setRepetitions(int repetitions) {
        if(repetitions >= 0) {
            this.repetitions = repetitions;
        } else {
            this.repetitions = 1;
        }
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        if(weight >= 0 ) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }
}
