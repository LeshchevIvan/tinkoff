package edu.project4.singleThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Render {

    private static double newX, newY;
    private static double[][] affineTransformation;
    private static final double XMIN = -1.777;
    private static final double XMAX = 1.777;
    private static final double YMIN = -1;
    private static final double YMAX = 1;
    private static int x1,y1;

    public static void render(int n, int eqCount, int it, int xRes, int yRes, Transformation.NonLinearFunction[] type) throws IOException {
        //создаем изображение
        var image = Pixel.createImage(xRes,yRes);
        for (int num = 0; num < n; num++) {
            ///Генерация афинных преобразований
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
                    affineTransformation[0][0] * newX + affineTransformation[0][1] * newY + affineTransformation[0][2];
                newY =
                    affineTransformation[1][0] * newX + affineTransformation[1][1] * newY + affineTransformation[1][2];
                //применение нелинейного преобразования
                var newCoordinates = Transformation.function(type[(int)(Math.random()*type.length-1)],newX,newY);
                newX=newCoordinates[0];
                newY=newCoordinates[1];


                if(step>=0 && newX>=XMIN&&newX<=XMAX&&newY>=YMIN&&newY<=YMAX){
                    //вычисление координаты точки на экране
                    x1=xRes-(int)(((XMAX-newX)/(XMAX-XMIN))*xRes);
                    y1=yRes-(int)(((YMAX-newY)/(YMAX-YMIN))*yRes);
                    if(x1<xRes && y1<yRes){
                        if (image[y1][x1].getHitCount().equals(0)){
                            image[y1][x1].setR((int)affineTransformation[2][0]);
                            image[y1][x1].setG((int)affineTransformation[2][1]);
                            image[y1][x1].setB((int)affineTransformation[2][2]);
                        }
                        else {
                            image[y1][x1].setR((image[y1][x1].getR()+(int)affineTransformation[2][0])/2);
                            image[y1][x1].setG((image[y1][x1].getG()+(int)affineTransformation[2][1])/2);
                            image[y1][x1].setB((image[y1][x1].getB()+(int)affineTransformation[2][2])/2);
                        }
                        image[y1][x1].incrementHitCount();
                    }

                }

            }

        }
        image=Correction.logCorrection(image,xRes,yRes);
        FractalImage.draw(image,xRes,yRes);

    }

}
