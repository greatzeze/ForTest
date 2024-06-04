package org.example;

import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Elimination {

    public static String backwardElimination(String value) {
        if (value == null || Objects.equals(value, "") || value.length() < 3) {
            return value;
        }
        LinkedList<Character> linkedList = new LinkedList<>();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            if (linkedList.size() < 2) {
                linkedList.addLast(c);
            } else {
                if (linkedList.peekLast().equals(c)) {
                    if (linkedList.get(linkedList.size() - 2).equals(c)) {
                        Character c2 = linkedList.pollLast();
                        Character c1 = linkedList.pollLast();
                        if (c != 'a'){
                            linkedList.addLast((char)((int)c - 1));
                        }
                        queueElimination(linkedList);
                        continue;
                    }
                }
                linkedList.addLast(c);
            }
        }
        return linkedList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static String elimination(String value) {
        if (value == null || Objects.equals(value, "") || value.length() < 3) {
            return value;
        }
        LinkedList<Character> linkedList = new LinkedList<>();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            if (linkedList.size() < 2) {
                linkedList.addLast(c);
            } else {
                if (linkedList.peekLast().equals(c)) {
                    if (linkedList.get(linkedList.size() - 2).equals(c)) {
                        Character c2 = linkedList.pollLast();
                        Character c1 = linkedList.pollLast();
                        continue;
                    }
                }
                linkedList.addLast(c);
            }
        }
        return linkedList.stream().map(String::valueOf).collect(Collectors.joining());
    }


    private static LinkedList<Character> queueElimination(LinkedList<Character> linkedList) {
        if (linkedList.size() >= 3){
            int size = linkedList.size();
            if (linkedList.get(size - 1).equals(linkedList.get(size - 2)) && linkedList.get(size - 2).equals(linkedList.get(size - 3))){
                Character c3 = linkedList.pollLast();
                Character c2 = linkedList.pollLast();
                Character c1 = linkedList.pollLast();
                if (c1 != 'a'){
                    linkedList.addLast((char)((int)c1 - 1));
                }
                queueElimination(linkedList);
            }
        }
        return linkedList;
    }

}



