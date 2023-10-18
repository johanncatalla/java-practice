
public class Student_Info {
    protected String name = "", course, subject;
    protected int year, prelim, midterm, finals;

    public Student_Info(String lastName, String firstName, String middle, String course, int year) {
        this.name = concatenate(lastName, firstName, middle);
        this.course = course;
        this.year = year;
    }
    public String concatenate(String lastName, String firstName, String middle) {
        return lastName.toUpperCase() + ", " + firstName.toUpperCase() + " " + middle.toUpperCase()+".";
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setSubject(String subject) {
        this.subject = subject;
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

}
