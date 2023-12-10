package edu.project4.singleThread;

public class Transformation {

    public enum NonLinearFunction {
        SINUSOIDAL,
        SPHERICAL,
        DISC,
        POLAR,
        HYPERBOLIC,
        CASTOM
    }

    public static double[] function(NonLinearFunction type, double x, double y) {
        switch (type) {
            case SINUSOIDAL -> {
                return new double[] {Math.sin(x), Math.sin(y)};
            }
            case SPHERICAL -> {
                return new double[] {x / (Math.pow(x, 2) + Math.pow(y, 2)), y / (Math.pow(x, 2) + Math.pow(y, 2))};
            }
            case POLAR -> {
                return new double[] {Math.atan(y / x) / 3.14, Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5) - 1};
            }
            case DISC -> {
                return new double[] {
                    1 / 3.14 * Math.atan(y / x) * Math.sin(3.14 * Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5)),
                    1 / 3.14 * Math.atan(y / x) * Math.cos(3.14 * Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5))};
            }
            case CASTOM -> {
                return new double[]{Math.sin(x)*y, Math.sin(y)};
            }
            case HYPERBOLIC -> {
                return new double[]{Math.sinh(x),Math.sinh(y)};
            }
            default -> {
                return new double[]{};
            }
        }
    }
}
