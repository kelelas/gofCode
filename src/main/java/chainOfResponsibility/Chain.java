package chainOfResponsibility;

public class Chain {
    public static void main(String[] args) {
        Logger logger = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);
        logger.setNext(logger1);
        logger1.setNext(logger2);
        logger.writeMessage("error", Level.ERROR);
        logger.writeMessage("debug", Level.DEBUG);
        logger.writeMessage("info", Level.INFO);
    }
}
class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}
abstract class Logger{
    int priority;
    public Logger(int priority) {
        this.priority = priority;
    }

    Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }
    public void writeMessage(String message, int level) {
        if (level<=priority){
            write(message);
        }
        if (next!=null){
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}
class SMSLogger extends Logger {
    public SMSLogger(int priority){super(priority);
    }

    void write(String message) {
        System.out.println("SMS: " + message);
    }
}
class FileLogger extends Logger {
    public FileLogger(int priority) {
        super(priority);
    }

    void write(String message) {
        System.out.println("File: " + message);
    }
}
class EmailLogger extends Logger {
    public EmailLogger(int priority){super(priority);
    }

    void write(String message) {
        System.out.println("Email: " + message);
    }
}


