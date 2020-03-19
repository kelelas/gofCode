package builder;

public class Builder {
    public static void main(String[] args) {
//        Car car = new CarBuilder()
//                .buildMake("BMV")
//                .buildTransmission(Transmission.MANUAL)
//                .buildMaxSpeed(300)
//                .build();
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}
class Car{
String make;
Transmission transmission;
int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
enum Transmission{
    MANUAL,AUTO
}
//class CarBuilder{
//    String m = "Default";
//    Transmission t = Transmission.MANUAL;
//    int s = 120;
//
//    CarBuilder buildMake(String m){
//        this.m = m;
//        return this;
//    }
//    CarBuilder buildTransmission(Transmission t){
//        this.t = t;
//        return this;
//    }
//    CarBuilder buildMaxSpeed(int s){
//        this.s = s;
//        return this;
//    }
//    Car build(){
//        Car car = new Car();
//        car.setMake(m);
//        car.setMaxSpeed(s);
//        car.setTransmission(t);
//        return car;
//    }
//}
abstract class CarBuilder{
    Car car;
    void createCar(){car = new Car();}
    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    public Car getCar() {
        return car;
    }
}
class FordMondeoBuilder extends CarBuilder{

    @Override
    void buildMake() {
        car.setMake("Ford Mondeo");

    }

    @Override
    void buildTransmission() {

        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(280);
    }
}

class SubaruBuilder extends CarBuilder{

    @Override
    void buildMake() {
        car.setMake("Subaru");

    }

    @Override
    void buildTransmission() {

        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(320);
    }
}
class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder builder){this.builder=builder;}
    Car buildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildMaxSpeed();
        builder.buildTransmission();
        Car car = builder.getCar();
        return car;
    }
}