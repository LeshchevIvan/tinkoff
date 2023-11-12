package edu.hw1;
public class Task2 {
    public static int countDigits(Integer number) {
        number=Math.abs(number);
        int n=9;
        int nDigit=0;
        while (number>0){
            number-=n;
            n=9+n*10;
            nDigit++;
        }
        return nDigit;
    }
}
