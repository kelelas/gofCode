package template;

public class TemplateMethod {
    public static void main(String[] args) {
//    A a = new A();
//        a.method();
//    B b = new B();
//        b.method();
        C a = new A();
        a.templateMethod();
        C b = new B();
        b.templateMethod();
}
}
abstract class C{
    void templateMethod(){
        System.out.print("1");
        differ();
        System.out.println("3");
        differ2();
    }
    abstract void differ();
    abstract void differ2();
}
class A extends C{
//    void method(){
//        System.out.print("1");
//        System.out.print("2");
//        System.out.println("3");
//    }

    void differ() {
        System.out.print("2");
    }

    void differ2() {
        System.out.print("5");
    }
}
class B extends C{
//    void method(){
//        System.out.print("1");
//        System.out.print("4");
//        System.out.println("3");
//    }

    void differ() {
        System.out.print("4");
    }

    void differ2() {

    }
}