package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static Map<Object, Integer> freqDict(Object[] input) {
        Map<Object, Integer> dict = new HashMap<>();
        for (var object : input) {
            if (dict.containsKey(object)) {
                dict.put(object, dict.get(object) + 1);
            } else {
                dict.put(object, 1);
            }
        }


        return dict;
    }

}
