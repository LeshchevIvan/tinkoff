package edu.hw3;


import java.util.ArrayList;

public class Task2 {
    public static ArrayList<String> clusterize(String brackets) {
        ArrayList<String> clusterizeBrackets = new ArrayList<>();
        StringBuilder buf = new StringBuilder();
        char[] bracketsToCharString = brackets.toCharArray();
        Integer leftBracket = 0;
        Integer rightBracket = 0;
        for (char bracket : bracketsToCharString) {
            if (bracket == ')') {
                rightBracket++;
                buf.append(")");
            } else if (bracket == '(') {
                leftBracket++;
                buf.append("(");
            } else {
                clusterizeBrackets.addLast("Wrong input string!");
                return clusterizeBrackets;
            }
            if (rightBracket.equals(leftBracket)) {
                clusterizeBrackets.addLast(buf.toString());
                buf = new StringBuilder();
            }


        }

        return clusterizeBrackets;
    }

}
