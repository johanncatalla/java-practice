package Inheritance;
class Shape {
    protected int width, height;

    public void setWidth(int w) {
        width = w;
    }
    public void setHeight(int h) {
        height = h;
    }
}

public class Rectangle extends Shape {
    public int getArea() {
        return (width * height);
    }
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.setHeight(10);
        r1.setWidth(6);
        int area = r1.getArea();
        System.out.println(area);
    }
}