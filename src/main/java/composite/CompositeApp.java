package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape square3 = new Square();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();
        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();
        Shape triangle3 = new Triangle();

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(circle1);
        composite1.addComponent(triangle1);
        composite2.addComponent(square2);
        composite2.addComponent(circle2);
        composite2.addComponent(triangle2);
        composite3.addComponent(square3);
        composite3.addComponent(circle3);
        composite3.addComponent(triangle3);
        composite2.addComponent(composite3);
        composite1.addComponent(composite2);

        composite1.draw();

    }
}
interface Shape{
    void draw();
}
class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Hi, I'm triangle");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Hi, I'm square");
    }
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Hi, I'm circle");
    }
}

class Composite implements Shape{
    List<Shape> components = new ArrayList<>();
    void addComponent(Shape shape){
        components.add(shape);
    }
    void removeComponent(Shape shape){
        components.remove(shape);
    }
    @Override
    public void draw() {
        for (Shape component: components){
            component.draw();
        }
    }
}