package abstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory deviceFactory = getDeviceFactoryVyCountryCode("EN");
        Mouse m = deviceFactory.getMouse();
        Keyboard k = deviceFactory.getKeyboard();
        Touchpad t = deviceFactory.getTouchpad();
        m.click();
        k.print();
        t.track(20,50);
    }
    private static DeviceFactory getDeviceFactoryVyCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EngDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code " + lang);
        }
    }
}

interface Mouse{
    void click();
    void doubleClick();
    void scroll(int direction);
}
interface Keyboard{
    void print();
    void println();
}
interface Touchpad{
    void track(int deltaX, int deltaY);
}
interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class RuMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("ru mouse click");
    }

    @Override
    public void doubleClick() {
        System.out.println("ru mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction>0)
        System.out.println("ru mouse scroll up");
        else if (direction<0)
            System.out.println("ru mouse scroll down");
        else
            System.out.println("ru mouse no scroll");
    }
}
class RuKeyboard implements Keyboard{

    @Override
    public void print() {
        System.out.println("ru keyboard print");
    }

    @Override
    public void println() {
        System.out.println("ru keyboard println");
    }
}
class RuTouchpad implements Touchpad{

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("eng touchpad move on "+ s + " pixels");
    }
}
class EngMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("eng mouse click");
    }

    @Override
    public void doubleClick() {
        System.out.println("eng mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("eng mouse scroll up");
        else if (direction < 0)
            System.out.println("eng mouse scroll down");
        else
            System.out.println("eng mouse no scroll");
    }
}
class EngKeyboard implements Keyboard{

    @Override
    public void print() {
        System.out.println("eng keyboard print");
    }

    @Override
    public void println() {
        System.out.println("eng keyboard println");
    }
}
class EngTouchpad implements Touchpad{

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("eng touchpad moved on "+ s + " pixels");
    }
}

class EngDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new EngMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EngKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EngTouchpad();
    }
}
class RuDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}