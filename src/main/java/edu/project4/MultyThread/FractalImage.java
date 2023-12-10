package edu.project4.MultyThread;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FractalImage {
    private static BufferedImage img;

    public static void draw(Pixel[][] data, int width, int height) throws IOException {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                img.setRGB(
                    j, i, data[i][j].getR() * 256 * 256 + data[i][j].getG() * 256 + data[i][j].getB()
                );
            }
        }
        ImageIO.write(img,"JPG",new File("src/main/java/edu/project4/MultyThread/image.jpg"));

    }
}
