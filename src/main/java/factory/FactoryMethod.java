package factory;

import java.util.Date;

public class FactoryMethod {
    public static void main(String[] args) {
//        WatchMaker watchMaker = new DigitalWatchMaker();
        WatchMaker watchMaker = getMakerByName("Digital");
        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }
    public static WatchMaker getMakerByName(String s){
        if (s.equals("Digital"))
            return new DigitalWatchMaker();
        else if (s.equals("Rome"))
            return new RomeWatchMaker();
        throw new RuntimeException("Error with name of WatchMaker: " + s);
    }
}
interface Watch{
    void showTime();
}
class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println("VII");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}