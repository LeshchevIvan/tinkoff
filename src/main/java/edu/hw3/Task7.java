package edu.hw3;


import java.util.Comparator;
import java.util.TreeMap;

public class Task7 {

    static class nullComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2==null) {
                return 0;
            } else if (o2 == null) {
                return -1;
            } else if (o1==null) {
                return 1;
            }
            else {
                return Integer.compare(o1.length(), o2.length());

            }
        }
    }

    public static void main(String[] args) {
        TreeMap<String, String> tree = new TreeMap<>(new nullComparator());
        tree.put(null, "test");

        System.out.println(tree.containsKey(null));

    }
}
