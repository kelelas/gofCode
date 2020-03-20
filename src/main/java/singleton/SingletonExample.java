package singleton;

public class SingletonExample {
    public static void main(String[] args) throws InterruptedException{
       // Singleton singleton = new Singleton();
        int arraySize = 1000;
        Thread[] thread = new Thread[arraySize];
       // Singleton[] singletons = new Singleton[arraySize];
        for (int i = 0; i<arraySize; i++) {
            thread[i] = new Thread(new R());
            thread[i].start();
            //singletons[i] = Singleton.getInstance();
        }
        for (int i = 0; i<arraySize; i++) {
            thread[i].join();
        }
        System.out.println(Singleton.counter);
    }
}
class R implements Runnable{

    @Override
    public void run() {
        Singleton.getInstance();
    }
}
class Singleton{
    public static int counter;
//    private static Singleton instance;
   // private static Singleton instance = new Singleton();
    private volatile static Singleton instance;
    private Singleton() {
        counter++;
    }
//    public static Singleton getInstance(){
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }
//    public static Singleton getInstance(){
//        return instance;
//    }
//    public static synchronized Singleton getInstance(){
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }
        public static  Singleton getInstance(){
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null)
                    instance = new Singleton();
                }
            }
            return instance;
        }
}