package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    private AtomicInteger counter = new AtomicInteger(0);

    public void increaseCounter(){
        counter.incrementAndGet();
    }

    public static int oneThread() throws InterruptedException {
        Task1 num = new Task1();
        var incrementor1 = new Thread(() -> {num.increaseCounter();});

        incrementor1.start();

        try {
            incrementor1.join();
            return num.counter.get();
        }
        catch (InterruptedException e){
            System.out.println(e);
            return -1;
        }
    }

    public static int twoThreads(){
        Task1 num = new Task1();
        var incrementor1 = new Thread(() -> {num.increaseCounter();});
        var incrementor2 = new Thread(() -> {num.increaseCounter();});

        incrementor1.start();
        incrementor2.start();
        try {
            incrementor1.join();
            incrementor2.join();
            return num.counter.get();
        }
        catch (InterruptedException e){
            System.out.println(e);
            return -1;
        }
    }

    public static int threeThreads(){
        Task1 num = new Task1();
        var incrementor1 = new Thread(() -> {num.increaseCounter();});
        var incrementor2 = new Thread(() -> {num.increaseCounter();});
        var incrementor3 = new Thread(() -> {num.increaseCounter();});

        incrementor1.start();
        incrementor2.start();
        incrementor3.start();
        try {
            incrementor1.join();
            incrementor2.join();
            incrementor3.join();
            return num.counter.get();
        }
        catch (InterruptedException e){
            System.out.println(e);
            return -1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(oneThread());
        System.out.println(twoThreads());
        System.out.println(threeThreads());
    }
}
