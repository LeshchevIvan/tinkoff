package edu.project4.singleThread;

public class Correction {
    public static Pixel[][] logCorrection(Pixel[][] image, int xRes, int yRes){
        double max=0.0;
        double gamma=2.2;
        for (int row=0; row<yRes; row++)
            for (int col=0; col<xRes; col++)
                if (image[row][col].getHitCount() != 0)
                {
                    image[row][col].setNormal(Math.log10(image[row][col].getHitCount()));
                    if (image[row][col].getNormal()>max)
                        max = image[row][col].getNormal();
                }
        for (int row=0; row<yRes; row++)
            for (int col=0; col<xRes; col++)
            {
                image[row][col].setNormal(image[row][col].getNormal()/max);
                image[row][col].setR((int)(image[row][col].getR()*Math.pow(image[row][col].getNormal(),(1.0 / gamma))));
                image[row][col].setG((int)(image[row][col].getG()*Math.pow(image[row][col].getNormal(),(1.0 / gamma))));
                image[row][col].setB((int)(image[row][col].getB()*Math.pow(image[row][col].getNormal(),(1.0 / gamma))));

            }
        return image;
    }
}
