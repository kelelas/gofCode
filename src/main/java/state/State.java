package state;

public class State {
    public static void main(String[] args) {
        Station station = new RadioFM();
        Radio radio = new Radio();
        radio.setStation(station);
        for (int i =0; i<10; i++){
            radio.play();
            radio.nextStation();
        }
        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i<10; i++)
        human.doSomething();

    }
}

//                 Human:

//Context
class Human{
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }
    public void doSomething(){
        state.doSomething(this);
    }

}
//State
interface Activity{
    void doSomething(Human context);
}

class Work implements Activity{

    @Override
    public void doSomething(Human context) {
        System.out.println("Working");
        context.setState(new Weekend());
    }
}

class Weekend implements Activity{
    int count = 0;
    @Override
    public void doSomething(Human context) {

        if (count<3) {
            System.out.println("Weekend");
            count++ ;
        }else {
            context.setState(new Work());

        }
    }
}

//                 Station:

interface Station{
    void play();
}
class Radio7 implements Station{

    @Override
    public void play() {
        System.out.println("play Radio7");
    }
}
class RadioFM implements Station{

    @Override
    public void play() {
        System.out.println("play RadioFM");
    }
}
class VestiFm implements Station{

    @Override
    public void play() {
        System.out.println("play VestiFM");
    }
}
class Radio{
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }
    void nextStation(){
        if (station instanceof Radio7)
            setStation(new RadioFM());
        else if (station instanceof  RadioFM)
            setStation(new VestiFm());
        else
            setStation(new Radio7());
    }
    void play(){
        station.play();
    }
}
