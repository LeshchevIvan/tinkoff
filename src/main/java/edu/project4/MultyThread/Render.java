package edu.project4.MultyThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class Render {

    private static final double XMIN = -1.777;
    private static final double XMAX = 1.777;
    private static final double YMIN = -1;
    private static final double YMAX = 1;
    //private static volatile Pixel[][] image;
    private static volatile List<Pixel[][]> imageCollector = new ArrayList<>();

    public static void render(int n, int eqCount, int it, int xRes, int yRes, Transformation.NonLinearFunction[] type)
        throws IOException, InterruptedException, ExecutionException {
        //создаем изображение
        Callable<Long> callable = () -> {
            var t1 = System.nanoTime();
            var image = Pixel.createImage(xRes, yRes);
            double newX = 0;
            double newY = 0;
            int x1 = 0;
            int y1 = 0;
            for (int num = 0; num < n; num++) {
                ///Генерация афинных преобразований
                double[][] affineTransformation;
                List<double[][]> affineTransformations = new ArrayList<>(eqCount);
                for (int i = 0; i < eqCount; i++) {
                    affineTransformations.addLast(AffineTransformation.generate(-1.5, 1.5, -3, 3));
                }

                newX = ((Math.random() * (XMAX - XMIN)) + XMIN);
                newY = ((Math.random() * (YMAX - YMIN)) + YMIN);

                for (int step = -20; step < it; step++) {
                    //выбор афинного преобразования
                    affineTransformation = affineTransformations.get((int) (Math.random() * (eqCount - 1)));
                    //применение афинного преобразования
                    newX =
                        affineTransformation[0][0] * newX + affineTransformation[0][1] * newY +
                            affineTransformation[0][2];
                    newY =
                        affineTransformation[1][0] * newX + affineTransformation[1][1] * newY +
                            affineTransformation[1][2];
                    //применение нелинейного преобразования
                    var newCoordinates =
                        Transformation.function(type[(int) (Math.random() * type.length - 1)], newX, newY);
                    newX = newCoordinates[0];
                    newY = newCoordinates[1];

                    if (step >= 0 && newX >= XMIN && newX <= XMAX && newY >= YMIN && newY <= YMAX) {
                        //вычисление координаты точки на экране
                        x1 = xRes - (int) (((XMAX - newX) / (XMAX - XMIN)) * xRes);
                        y1 = yRes - (int) (((YMAX - newY) / (YMAX - YMIN)) * yRes);
                        //System.out.println(Thread.currentThread().getName()+" "+ x1+ " "+ y1);
                        if (x1 >= 0 && x1 < xRes && y1 >= 0 && y1 < yRes) {
                            if (image[y1][x1].getHitCount().equals(0)) {
                                image[y1][x1].setR((int) affineTransformation[2][0]);
                                image[y1][x1].setG((int) affineTransformation[2][1]);
                                image[y1][x1].setB((int) affineTransformation[2][2]);
                            } else {
                                image[y1][x1].setR((image[y1][x1].getR() + (int) affineTransformation[2][0]) / 2);
                                image[y1][x1].setG((image[y1][x1].getG() + (int) affineTransformation[2][1]) / 2);
                                image[y1][x1].setB((image[y1][x1].getB() + (int) affineTransformation[2][2]) / 2);
                            }
                            image[y1][x1].incrementHitCount();
                        }

                    }

                }

            }
            var t2 = System.nanoTime();
            imageCollector.addLast(image);
            return (t2 - t1) / 1000000000;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        var tasks = Stream.generate(() -> callable).limit(6).toList();
        List<Future<Long>> futures = executorService.invokeAll(tasks);
        for (var future : futures) {

            System.out.println(future.get());
        }
        executorService.shutdown();

        var image = Pixel.createImage(xRes, yRes);
        for (Pixel[][] threadImage : imageCollector) {
            for (int i = 0; i < yRes; i++) {
                for (int j = 0; j < xRes; j++) {
                    if (Math.random() > 0.4) {
                        image[i][j].setR(threadImage[i][j].getR());
                    }
                    if (Math.random() > 0.42) {
                        image[i][j].setG(threadImage[i][j].getG());
                    }
                    if (Math.random() > 0.43) {
                        image[i][j].setB(threadImage[i][j].getB());
                    }
                    image[i][j].setHitCount(image[i][j].getHitCount() + threadImage[i][j].getHitCount());
                }
            }
        }
        image = Correction.logCorrection(image, xRes, yRes);
        FractalImage.draw(image, xRes, yRes);
    }
}
