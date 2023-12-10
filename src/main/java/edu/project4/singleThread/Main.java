package edu.project4.singleThread;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var t1= System.nanoTime();
        Render.render(5,20,1000_000_00,1920,1080, new Transformation.NonLinearFunction[]{Transformation.NonLinearFunction.SPHERICAL});
        System.out.println("runningg time is: "+(System.nanoTime()-t1)/1000000000);
    }
}
