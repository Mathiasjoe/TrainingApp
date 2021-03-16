package idata1002_2021_group11;

/**
 * The class Set.
 */
public class Set {
    private float weight;
    private int repetitions;


    /**
     * Instantiates a new Set.
     *
     * @param weight      the weight
     * @param repetitions the repetitions
     */
    public Set(float weight, int repetitions) {
        this.repetitions = repetitions;
        this.weight = weight;
    }

    /**
     * Sets repetitions.
     *
     * @param repetitions the repetitions
     */
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }
}
