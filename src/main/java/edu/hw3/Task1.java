package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public   static Map<Character, Character> fillEncryption(){
        Map<Character, Character> encryption = new HashMap<>();
        int reverseIterator=25;
        Character[] capitalAlphabet={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < 13; i++) {
            encryption.put(capitalAlphabet[i],capitalAlphabet[reverseIterator]);
            encryption.put(capitalAlphabet[reverseIterator],capitalAlphabet[i]);
            reverseIterator--;
        }
        reverseIterator=25;
        Character[] alphabet=new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i]=Character.toLowerCase(capitalAlphabet[i]);
        }

        for (int i = 0; i < 13; i++) {
            encryption.put(alphabet[i],alphabet[reverseIterator]);
            encryption.put(alphabet[reverseIterator],alphabet[i]);
            reverseIterator--;
        }
        return encryption;
    }

    public static String encode(String string) {
        Map<Character, Character> encryption =fillEncryption();
        char[] charString = string.toCharArray();
        for (int i = 0; i < charString.length; i++) {
            if (encryption.containsKey(charString[i])){
                charString[i]=encryption.get(charString[i]);
            }
        }

        return String.valueOf(charString);
    }


    public static void main(String[] args) {
        System.out.println(encode("Hello World!"));
        System.nanoTime();
    }
}
