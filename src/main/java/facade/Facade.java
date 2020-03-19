package facade;

public class Facade {
    public static void main(String[] args) {

       Computer computer = new Computer();
       computer.copy();
    }
}
class Computer{
    Power power = new Power();
    DVDRoom dvdRoom = new DVDRoom();
    HDD hdd = new HDD();
    void copy(){
        power.on();

        dvdRoom.load();

        hdd.copeFromDVD(dvdRoom);
    }
}
class Power{
    void on(){
        System.out.println("On");
    }
    void off(){
        System.out.println("Off");
    }
}

class DVDRoom{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        System.out.println("Load");
        data = true;
    }
    void unload(){
        System.out.println("Unload");
        data = false;
    }
}
class HDD{
    void copeFromDVD(DVDRoom dvd){
        if (dvd.hasData())
            System.out.println("Copy");
        else
            System.out.println("DVDRoom is ");
    }
}
