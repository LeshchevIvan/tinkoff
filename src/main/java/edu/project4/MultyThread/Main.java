package edu.project4.MultyThread;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        var t1 = System.nanoTime();
        Render.render(5,20,1_000_000_00/6,1920,1080, new Transformation.NonLinearFunction[]{Transformation.NonLinearFunction.SPHERICAL});
        System.out.println("running time is: "+ (System.nanoTime()-t1)/1000000000);
    }
}
