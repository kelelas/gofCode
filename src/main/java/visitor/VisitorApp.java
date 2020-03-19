package visitor;

public class VisitorApp {
    public static void main(String[] args) {

    }
}
//visitor
interface Visitor{
    void visit(EngineElement element);
    void visit(BodyElement element);
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

class HooliganVisitor implements Visitor{

    @Override
    public void visit(EngineElement element) {
        System.out.println("Started engine");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("knocked the body");
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
}