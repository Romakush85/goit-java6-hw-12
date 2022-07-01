import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Runnable printFizz = () -> System.out.print(" fizz ");
        Runnable printBuzz = () -> System.out.print(" buzz ");
        Runnable printFizzBuzz = () -> System.out.print(" fizzbuzz ");
        IntConsumer printNumber = number -> System.out.print(" " + number + " ");

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
