package multithreading;
/**
 * один из потоков не заканчивает работу с общим ресурсом,
 * а система переключается на другой поток, использующий этот же ресурс
 * Как решить проблему:
 * нужно сделать так, чтобы ресурс использовался одним потоком одновременно
 */
public class Lucky {
    static int x = 0;
    static int count = 0;

    static class LuckyThread extends Thread {

        int copyX; //создание копии эл-та для обеспечения ее целостности

        @Override
        public void run() {
            while (true) {
                synchronized (Lucky.class) {
                    if (x < 999999) copyX = x++;
                    else break;
                }
                if ((copyX % 10) + (copyX / 10) % 10 + (copyX / 100) % 10 == (copyX / 1000)
                        % 10 + (copyX / 10000) % 10 + (copyX / 100000) % 10) {
                    System.out.println(copyX);
                    synchronized (Lucky.class) {
                        count++;
                    }
                }
            }
        }
    }
}