package chainOfResponsibility;

public class Bankomat {
    public static void main(String[] args) {
        NoteModule noteModule5000 = new NoteModule5000();
        NoteModule noteModule1000 = new NoteModule1000();
        NoteModule noteModule500 = new NoteModule500();
        NoteModule noteModule100 = new NoteModule100();
        noteModule5000.setNext(noteModule1000);
        noteModule1000.setNext(noteModule500);
        noteModule500.setNext(noteModule100);

        noteModule5000.takeMoney(new Money(193000));
    }
}
    class Note{
        public static final int P100 = 100;
        public static final int P500 = 500;
        public static final int P1000 = 1000;
        public static final int P5000 = 5000;
    }
    class Money{
        private int amt;

        public Money(int amt) {
            this.amt = amt;
        }

        public int getAmt() {
            return amt;
        }

        public void setAmt(int amt) {
            if (amt>0 && amt<=200_000 && amt%Note.P100 == 0 )
            this.amt = amt;
            else
                throw new RuntimeException("сумма должна быть кратной 100 и не больше 200000");
        }
    }
    abstract class NoteModule{
    protected NoteModule next;
    abstract void takeMoney(Money money);

        public void setNext(NoteModule next) {
            this.next = next;
        }
    }
    class NoteModule5000 extends NoteModule{

        @Override
        void takeMoney(Money money) {
            int countNote = money.getAmt()/Note.P5000;
            int remind = money.getAmt()%Note.P5000;
            if (countNote>0)
                System.out.println("Выдано " + countNote + " купюр по 5000 рублей");
            if (remind>0 && next!=null)
                next.takeMoney(new Money(remind));
        }
    }
class NoteModule1000 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.P1000;
        int remind = money.getAmt()%Note.P1000;
        if (countNote>0)
            System.out.println("Выдано " + countNote + " купюр по 1000 рублей");
        if (remind>0 && next!=null)
            next.takeMoney(new Money(remind));
    }
}
class NoteModule500 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.P500;
        int remind = money.getAmt()%Note.P500;
        if (countNote>0)
            System.out.println("Выдано " + countNote + " купюр по 500 рублей");
        if (remind>0 && next!=null)
            next.takeMoney(new Money(remind));
    }
}
class NoteModule100 extends NoteModule{

    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt()/Note.P100;
        int remind = money.getAmt()%Note.P100;
        if (countNote>0)
            System.out.println("Выдано " + countNote + " купюр по 100 рублей");
        if (remind>0 && next!=null)
            next.takeMoney(new Money(remind));
    }
}


