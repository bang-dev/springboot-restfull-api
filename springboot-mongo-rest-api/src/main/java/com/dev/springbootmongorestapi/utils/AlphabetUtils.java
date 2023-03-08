package com.dev.springbootmongorestapi.utils;

public class AlphabetUtils {
    public static char generateNewAlphabetRandom() {
        int rand = (int) (Math.random() * 52);
        char base = (rand < 26) ? 'A' : 'a';
        return (char) ((base + rand) % 26);
    }

    public static char convertCharLowercaseToUppercase(char s) {
        char rs = Character.toUpperCase(s);
        return rs;
    }

    public static char convertCharUppercaseToLowercase(char s) {
        char rs = Character.toLowerCase(s);
        return rs;
    }

    public static String convertToCharUpperAll(String val) {
        StringBuffer sb = new StringBuffer(val);
        for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        }
        return sb.toString();
    }

}
