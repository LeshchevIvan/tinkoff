package edu.project4.MultyThread;

public class AffineTransformation {

    public static double[][] generate(double abdeMin, double abdeMax, double cfMin, double cfMax) {
        double a, b, c, d, e, f;
        while (true) {
            a = ((Math.random() * (abdeMax - abdeMin)) + abdeMin);
            b = ((Math.random() * (abdeMax - abdeMin)) + abdeMin);
            d = ((Math.random() * (abdeMax - abdeMin)) + abdeMin);
            e = ((Math.random() * (abdeMax - abdeMin)) + abdeMin);

            if ((a * a + d * d) < 1 && (b * b + e * e) < 1 &&
                (a * a + b * b + d * d + e * e) < (1 + (a * e - b * d) * (a * e - b * d))) {
                c = ((Math.random() * (cfMax - cfMin)) + cfMin);
                f = ((Math.random() * (cfMax - cfMin)) + cfMin);
                var initialColorR = (int) (Math.random() * 255);
                var initialColorG = (int) (Math.random() * 255);
                var initialColorB = (int) (Math.random() * 255);

                return new double[][] {{a, b, c}, {d, e, f}, {initialColorR, initialColorG, initialColorB}};

            }
        }
    }

}
