package edu.hw3;


import java.util.ArrayList;

public class Task2 {
    public static ArrayList<String> clusterize(String brackets) {
        ArrayList<String> clusterizeBrackets = new ArrayList<>();
        String buf = "";
        char[] bracketsToCharString = brackets.toCharArray();
        Integer leftBracket = 0;
        Integer rightBracket = 0;
        for (char bracket : bracketsToCharString) {
            if (bracket == ')') {
                rightBracket++;
                buf += ")";
            } else if (bracket == '(') {
                leftBracket++;
                buf += "(";
            } else {
                clusterizeBrackets.addLast("Wrong input string!");
                return clusterizeBrackets;
            }
            if (rightBracket.equals(leftBracket)) {
                clusterizeBrackets.addLast(buf);
                buf = "";
            }


        }

        return clusterizeBrackets;
    }

    public static void main(String[] args) {
        System.out.println(clusterize("((()"));
    }
}
