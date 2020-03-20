package observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());
        meteoStation.setMeasurements(25, 760);
    }
}
interface Observed{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
interface Observer{
    void handleEvent(int temp, int presser);
}


class MeteoStation implements Observed{
    int temperature;
    int pressure;

    public  void setMeasurements(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }
    List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.handleEvent(temperature,pressure);
    }
}

class ConsoleObserver implements Observer{

    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("weather changed! Temperature = " + temp + " and presser = " + presser);
    }
}

class FileObserver implements Observer{

    @Override
    public void handleEvent(int temp, int presser) {
        File file;
        try {
            file = File.createTempFile("TempPressure", "_txt");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print("weather changed! Temperature = " + temp + " and presser = " + presser);
            printWriter.println();
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}