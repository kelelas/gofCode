package decorator;

public class DecoratorWrapper {
    public static void main(String[] args) {
        PrinterInterface printerInterface = new QuoteDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello"))));
        printerInterface.print();
    }
}
interface PrinterInterface{
    void print();
}

abstract class Decorator implements PrinterInterface{
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }
    public void print(){
        component.print();
    }
}
class Printer implements PrinterInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
class QuoteDecorator extends Decorator{
    public QuoteDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
class LeftBracketDecorator extends Decorator{
    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}
class RightBracketDecorator extends Decorator{
    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {

        super.print();
        System.out.print("]");
    }
}