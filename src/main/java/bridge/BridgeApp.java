package bridge;

public class BridgeApp {
    public static void main(String[] args) {
        Car car = new Sedan(new Kia());
        car.showDetails();
    }
}

abstract class Car{
    Make make;
    public Car(Make make){
        this.make = make;
    }
    abstract void showDetails();
}
class Sedan extends Car{

    public Sedan(Make make) {
        super(make);
    }

    @Override
    void showDetails() {
        System.out.println("Sedan");
        make.setMake();
    }
}
class Hatchback extends Car{

    public Hatchback(Make make) {
        super(make);
    }

    @Override
    void showDetails() {
        System.out.println("Hatchback");
        make.setMake();
    }
}

interface Make{
    void setMake();
}

class Kia implements Make{

    @Override
    public void setMake() {
        System.out.println("Kia");
    }
}
class Skoda implements Make{

    @Override
    public void setMake() {
        System.out.println("Skoda");
    }
}