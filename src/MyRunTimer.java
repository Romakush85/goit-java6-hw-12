import java.util.Timer;
import java.util.TimerTask;

public class MyRunTimer extends TimerTask {
    public long runTime = 0;


    TimerTask per1SecPrinter = new TimerTask() {
        @Override
        public void run() {
            System.out.println("Время работы программы: " + runTime / 1000 + " сек.");
            runTime += 1000;
            if (runTime % 5000 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                per5SecPrinter.run();
            }
        }
    };

    TimerTask per5SecPrinter = new TimerTask() {
        @Override
        public void run() {
            System.out.println("Прошло 5 секунд");
        }

    };

    @Override
    public void run() {
        Timer runTimer = new Timer();
        runTimer.scheduleAtFixedRate(per1SecPrinter, 0, 1000);
    }
}