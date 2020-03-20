package visitor;

public class VisitorApp {
    public static void main(String[] args) {
//        Element body = new BodyElement();
//        Element engine = new EngineElement();
        Visitor hooligan = new HooliganVisitor();
//
//        body.accept(hooligan);
//        engine.accept(hooligan);

        Element car = new CarElement();
        car.accept(hooligan);
    }
}
//visitor
interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(CarElement car);
    void visit(WheelElement wheel);
}

//part of car
interface Element{
    void accept(Visitor visitor);
}

//engine of car
class EngineElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//body of car
class BodyElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element{
    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{new WheelElement("front right wheel"),
                new WheelElement("front left wheel"),
                new WheelElement("back right wheel"),
                new WheelElement("back left wheel"),
                new BodyElement(),
                new EngineElement()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element: elements)
            element.accept(visitor);
        visitor.visit(this);
    }
}
class WheelElement implements Element{
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{

    @Override
    public void visit(EngineElement element) {
        System.out.println("Started engine");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("knocked the body");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("smoked inside car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("pushed " + wheel.getName());
    }
}

class MechanicVisitor implements Visitor{

    @Override
    public void visit(EngineElement element) {
        System.out.println("Checked engine");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("polished the body");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("checked how car look like");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("repair " +wheel.getName());
    }
}