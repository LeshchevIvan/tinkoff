package edu.hw3;

import java.util.ArrayList;


public class Task5 {

    private static String findLastName(String name) {
        String[] FLName = name.split(" ");
        if (FLName.length == 1) {
            return FLName[0];
        }
        return FLName[1];
    }

    private static int compareLastName(String sortedName, String unsortedName) {
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        String sortedNameLow=sortedName.toLowerCase();
        String unsortedNameLow=unsortedName.toLowerCase();


        int length = Math.min(sortedName.length(), unsortedName.length());
        int shift = 0;
        int sortedCharIndex;
        int unsortedCharIndex;
        for (int i = 0; i < length; i++) {
            sortedCharIndex=alphabet.indexOf(sortedNameLow.charAt(i));
            unsortedCharIndex=alphabet.indexOf(unsortedNameLow.charAt(i));
            if(sortedCharIndex<unsortedCharIndex){
                shift=1;
                return shift;
            } else if (sortedCharIndex>unsortedCharIndex) {
                shift=-1;
                return shift;
            }
        }
        if (shift==0) shift=1;
        return shift;
    }

    public static Object[] parseContacts(String[] nameList, String sortMode) {
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addFirst(nameList[0]);

        int shift;
        String sortedName;
        String unsortedName;
        if (sortMode.equals("ASC")) {
            for (int i = 1; i < nameList.length; i++) {
                unsortedName=findLastName(nameList[i]);
                for (int j = 0; j < sortedList.size(); j++) {
                    sortedName=findLastName(sortedList.get(j));
                    shift=compareLastName(sortedName,unsortedName);
                    if (shift==-1){
                        sortedList.add(j,nameList[i]);
                        break;
                    } else if (j==sortedList.size()-1) {
                        sortedList.add(nameList[i]);
                        break;
                    }
                }
            }
        } else if (sortMode.equals("DESC")) {
            for (int i = 1; i < nameList.length; i++) {
                unsortedName=findLastName(nameList[i]);
                for (int j = 0; j < sortedList.size(); j++) {
                    sortedName=findLastName(sortedList.get(j));
                    shift=compareLastName(sortedName,unsortedName);
                    if (shift==1){
                        sortedList.add(j,nameList[i]);
                        break;
                    } else if (j==sortedList.size()-1) {
                        sortedList.add(nameList[i]);
                        break;
                    }
                }
            }

        } else return new Object[]{"Wrong sortMode!"};

        return sortedList.toArray();
    }

    public static void main(String[] args) {
        System.out.println(parseContacts(new String[]{ "Paul", "Leonhard Euler", "Carl Gauss" }, "ASC"));
    }
}
