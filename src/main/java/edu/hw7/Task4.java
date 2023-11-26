package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task4 {

    volatile long circleCount=0;
    volatile long totalCount=0;
    public static double singleThread(long nIteration) {
        double totalCount = 0;
        double circleCount = 0;
        double x;
        double y;

        for (int i = 0; i < nIteration; i++) {
            x = Math.random();
            y = Math.random();
            if (x * x + y * y <= 1) {
                circleCount++;
            }
            totalCount++;
        }
        return 4 * (circleCount / totalCount);
    }

    public double multiThread(long nIteration, int nThreads) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        Runnable pi = () -> {
            long cCount=0;
            long tCount=0;
            double x;
            double y;
            for (int i = 0; i < nIteration; i++) {
                x = Math.random();
                y = Math.random();

                if (x * x + y * y <= 1) {
                    cCount++;
                }
                tCount++;

            }
            synchronized (this){
                totalCount+=tCount;
                circleCount+=cCount;
            }

        };

        Stream.generate(() -> new Thread(pi)).limit(nThreads).forEach(t -> {
            t.start();
            threads.addLast(t);
        });

        for (Thread t : threads) {
            t.join();
        }

        return (double) 4 * circleCount / totalCount;
    }

    public static void main(String[] args) throws InterruptedException {
        var t0 = System.nanoTime();
        System.out.println(singleThread(1000000));
        System.out.println("time is: " + (System.nanoTime() - t0));

        Task4 pi = new Task4();
        var t1 = System.nanoTime();
        System.out.println(pi.multiThread(1000000, 1));
        System.out.println("time is: " + (System.nanoTime() - t1));

        Task4 pi1 = new Task4();
        var t2 = System.nanoTime();
        System.out.println(pi1.multiThread(1000000, 6));
        System.out.println("time is: " + (System.nanoTime() - t2));
    }

}


