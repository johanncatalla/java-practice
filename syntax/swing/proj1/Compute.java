public class Compute {

    private float prelim, midterm, semifinals, finals;

    public Compute(float prelim, float midterm, float semifinals, float finals) {
        this.prelim = prelim;
        this.midterm = midterm;
        this.semifinals = semifinals;
        this.finals = finals;
    }

    public float getAverageGrade() {
        float avg = (prelim + midterm + semifinals + finals) / 4;
        return avg;
    }
}