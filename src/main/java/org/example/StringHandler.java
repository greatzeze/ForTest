package org.example;

import java.util.HashMap;

public class StringHandler {

    /**
     * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting besides each other.
     * Input: aabcccbbad
     * Output:
     * -> aabbbad
     * -> aaad
     * -> d
     */
    public static String strHandler(String s) {
        if (s == null) {
            System.out.println("Please make sure your key is valid.");
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c) + 1;
                if (count == 3) {
                    String newS = s.substring(0, i - 2) + s.substring(i + 1);
                    System.out.println("-> " + newS);
                    return strHandler(newS);
                }
                map.put(c, count);
            } else {
                map = new HashMap<>();
                map.put(c, 1);
            }
        }
        return s;
    }


    /**
     * #Stage 2 - advanced requirement
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     */
    public static String strAdvancedHandler(String s) {
        if (s == null) {
            System.out.println("Please make sure your key is valid.");
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c) + 1;
                if (count == 3) {
                    String replace = i - 3 < 0 ? "" : String.valueOf(s.charAt(i - 3));
                    String newS = s.substring(0, i - 2) + replace + s.substring(i + 1);
                    if (!"".equals(replace)) {
                        System.out.println("-> " + newS + ", " + c + c + c + " is replaced by " + replace);
                    } else {
                        System.out.println("-> " + newS);
                    }
                    return strAdvancedHandler(newS);
                }
                map.put(c, count);
            } else {
                map = new HashMap<>();
                map.put(c, 1);
            }
        }
        return s;
    }
}