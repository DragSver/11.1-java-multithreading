package multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Lucky.LuckyThread();
        Thread t2 = new Lucky.LuckyThread();
        Thread t3 = new Lucky.LuckyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + Lucky.count);
    }
}