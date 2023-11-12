package edu.hw3;

import java.util.*;

public class Task4 {
    private static Integer findFirstBigger(Integer arabicValue, Map<Integer, Character> dict) {
        ArrayList<Integer> keys = new ArrayList<>(dict.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) >= arabicValue) {
                return keys.get(i);
            }
        }
        return 0;
    }

    private static Integer findFirstLesser(Integer arabicValue, Map<Integer, Character> dict) {
        ArrayList<Integer> keys = new ArrayList<>(dict.keySet());
        Collections.sort(keys);
        Collections.reverse(keys);
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) <= arabicValue) {
                return keys.get(i);
            }
        }

        return 0;
    }

    private static Integer findFirstLesser(Map<Character, Integer> dict, Integer arabicValue) {
        ArrayList<Integer> keys = new ArrayList<>(dict.values());
        Collections.sort(keys);
        Collections.reverse(keys);
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) < arabicValue) {
                return keys.get(i);
            }
        }

        return 0;
    }

    public static String convertToRoman(Integer arabicValue) {
        if (arabicValue > 3999 || arabicValue < 0)
            return "Warning! \nThis function works with Integer values from 1 to 3999.";
        Map<Integer, Character> dict = new HashMap<>();
        dict.put(1, 'I');
        dict.put(5, 'V');
        dict.put(10, 'X');
        dict.put(50, 'L');
        dict.put(100, 'C');
        dict.put(500, 'D');
        dict.put(1000, 'M');

        Map<Integer, Character> dictOnly10X = new HashMap<>();
        dictOnly10X.put(1, 'I');
        dictOnly10X.put(10, 'X');
        dictOnly10X.put(100, 'C');
        dictOnly10X.put(1000, 'M');

        Map<Character, Integer> reverseDictOnly10X = new HashMap<>();
        reverseDictOnly10X.put('I', 1);
        reverseDictOnly10X.put('X', 10);
        reverseDictOnly10X.put('C', 100);
        reverseDictOnly10X.put('M', 1000);


        Integer key;
        StringBuilder romanValue = new StringBuilder();
        String buf;
        while (arabicValue != 0) {
            if (arabicValue.toString().charAt(0) == '9' || arabicValue.toString().charAt(0) == '4') {
                {
                    key = findFirstBigger(arabicValue, dict);
                    arabicValue -= key;
                    romanValue.append(dict.get(key));

                    key = findFirstLesser(reverseDictOnly10X, key);
                    arabicValue += key;
                    buf = romanValue.substring(romanValue.length() - 1);
                    romanValue = new StringBuilder(romanValue.substring(0, romanValue.length() - 1));
                    romanValue.append(dict.get(key)).append(buf);
                }
            } else {
                key = findFirstLesser(arabicValue, dict);
                arabicValue -= key;
                romanValue.append(dict.get(key));
            }
        }
        return romanValue.toString();
    }

}
