import java.lang.Math;

public class Compute_Grades extends Student_Info {
    public Compute_Grades(String lastName, String firstName, String middle, String course, int year) {
        super(lastName, firstName, middle, course, year);
    }

    public void setGrades(String subject, int prelim, int midterm, int finals) {
        this.prelim = prelim;
        this.midterm = midterm;
        this.finals = finals;
        this.subject = subject;
    }

    public static double convert(float grade) {
        grade = Math.round(grade);
        if (grade >= 97 && grade <= 100) {
            return 1.00;
        } else if (grade >= 94 && grade <= 96) {
            return 1.25;
        } else if (grade >= 91 && grade <= 93) {
            return 1.50;
        } else if (grade >= 88 && grade <= 90) {
            return 1.75;
        } else if (grade >= 85 && grade <= 87) {
            return 2.00;
        } else if (grade >= 82 && grade <= 84) {
            return 2.25;
        } else if (grade >= 79 && grade <= 81) {
            return 2.50;
        } else if (grade >= 77 && grade <= 78) {
            return 2.75;
        } else if (grade >= 75 && grade <= 76) {
            return 3.00;
        } else {
            return 5.00;
        }
    }

    public float getAvg() {
        return (float) (prelim + midterm + finals) / 3;
    }

    public String checkGrade(float grade) {
        if (grade >= 75) {
            return "Passed";
        } else {
            return "Failed";
        }
    }
}
