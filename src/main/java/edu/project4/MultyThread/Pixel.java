package edu.project4.MultyThread;

public class Pixel {
    private int r;
    private int g;
    private  int b;
    private Integer hitCount;
    private double normal;

    public int getR(){
        return this.r;
    }
    public void setR(int newR){
        this.r=newR;
    }

    public int getG(){
        return this.g;
    }
    public void setG(int newG){
        this.g=newG;
    }

    public int getB(){
        return this.b;
    }
    public void setB(int newB){
        this.b=newB;
    }

    public Integer getHitCount(){
        return this.hitCount;
    }
    public void setHitCount(int newHitCount){
        this.hitCount=newHitCount;
    }
    public void incrementHitCount(){
        ++this.hitCount;
    }
    public double getNormal(){
        return this.normal;
    }
    public void setNormal(double newNormal){
        this.normal=newNormal;
    }

    public Pixel(){
        this.r=0;
        this.g=0;
        this.b=0;
        this.hitCount=0;
        this.normal=0;
    }
    public static Pixel[][] createImage(int xRes, int yRes){
        Pixel[][] image = new Pixel[yRes][xRes];
        for (int i = 0; i < yRes; i++) {
            for (int j = 0; j < xRes; j++) {
                image[i][j] = new Pixel();
            }
        }
        return image;
    }

}
