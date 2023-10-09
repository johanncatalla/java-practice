public class Grade {

    private int grade;

    String Verify(int grade) {
        if (grade >= 50 && grade <=100) {
            if (grade >= 75) {
                return "PASSED";
            } else {
                return "FAILED";
            }
        } else {
            return "INVALID GRADE";
        }
    }
}
