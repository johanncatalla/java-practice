public class Hellow {
    public String msg;
    public void hello() {
        System.out.println("bye");
    }
}

class Second {
    public static void main(String[] args) {
        
        Hellow obj = new Hellow();
        obj.hello();
        
        obj.msg = "I hate java";
        System.out.println(obj.msg);
        
    }
}

