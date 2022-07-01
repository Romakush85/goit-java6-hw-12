import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int index = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (index <= n) {
            if (index % 15 == 0) {
                printFizzBuzz.run();
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (index <= n) {
            if (index % 3 == 0 && index % 5 != 0) {
                printFizz.run();
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (index <= n) {
            if (index % 3 != 0 && index % 5 == 0) {
                printBuzz.run();
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (index <= n) {
            if (index % 3 != 0 && index % 5 != 0) {
                printNumber.accept(index);
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}

