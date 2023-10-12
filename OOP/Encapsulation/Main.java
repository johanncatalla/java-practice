public class Main {
    public static void main(String[] args) {
        Encapsulation encapsulate = new Encapsulation();
        String name = "Ryan Gosling";
        double grade = 99;

        encapsulate.setName(name);
        encapsulate.setGrade(grade);

        System.out.println("Name: "+encapsulate.getName()+"\nGrade: "+encapsulate.getGrade());
    }
}
