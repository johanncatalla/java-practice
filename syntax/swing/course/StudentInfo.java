public class StudentInfo {
    private String name, address, course;
    public StudentInfo(String name, String address, String course) {
        this.name = name;
        this.address = address;
        this.course = course;
    }
    public String getName() { return this.name; }
    public String getAddress() {
        return this.address;
    }
    public String getCourse() {
        return course;
    }
}
