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
        if(repetitions >= 0) {
            this.repetitions = repetitions;
        } else {
            this.repetitions = 1;
        }

        this.weight = weight;
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
    public void setWeight(float weight) {
        if(weight >= 0 ) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }
}
