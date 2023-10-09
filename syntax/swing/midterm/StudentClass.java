
public class StudentClass {
    private String name = "", course, subject;
    private int year, prelim, midterm, finals;

    public StudentClass(String lastName, String firstName, String middle, String course, int year) {
        this.name = concatenate(lastName, firstName, middle);
        this.course = course;
        this.year = year;
    }
    public void setGrades(String subject, int prelim, int midterm, int finals) {
        this.prelim = prelim;
        this.midterm = midterm;
        this.finals = finals;
        this.subject = subject;
    }
    public String concatenate(String lastName, String firstName, String middle) {
        return lastName.toUpperCase() + ", " + firstName.toUpperCase() + " " + middle.toUpperCase()+".";
    }
    public String getName() {
        return this.name;
    }
    public String getCourse() {
        return this.course;
    }
    public int getYear() {
        return this.year;
    }

    public float getAvg() {
        return (float) (prelim + midterm + finals) / 3;
    }

    public static double convert(float grade) {
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

     public String checkGrade(float grade) {
        if (grade >= 75) {
            return "Passed";
        } else {
            return "Failed";
        }
     }

}
