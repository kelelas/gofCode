package delegate;

public class DelegateApp {
    public static void main(String[] args) {
//    A a = new A();
//    a.f();
        Painter painter = new Painter();
        painter.setGraphic(new Square());
        painter.draw();
        painter.setGraphic(new Circle());
        painter.draw();
        painter.setGraphic(new Triangle());
        painter.draw();
    }
}
//
//class A{
//    void f(){
//        System.out.println("f");
//    }
//}
//class B{
//    A a = new A();
//    void f(){
//        a.f();
//    }
//}

interface Graphics{
    void draw();
}
class Triangle implements Graphics{

    @Override
    public void draw() {
        System.out.println("drawing triangle");
    }
}
class Square implements Graphics{

    @Override
    public void draw() {
        System.out.println("drawing square");
    }
}
class Circle implements Graphics{

    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}
class Painter{
    Graphics graphic;

    public void setGraphic(Graphics graphic) {
        this.graphic = graphic;
    }
    void draw(){
        graphic.draw();
    }
}