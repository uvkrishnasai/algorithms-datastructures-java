package org.practice.programs.beginner;

/**
 * Created by Krishna on 6/12/16.
 */
public class ReplaceVowelWithCaps {

    public static String replace(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'a' :
                    chars[i] = 'A';
                    continue;
                case 'e' :
                    chars[i] = 'E';
                    continue;
                case 'i' :
                    chars[i] = 'I';
                    continue;
                case 'o' :
                    chars[i] = 'O';
                    continue;
                case 'u' :
                    chars[i] = 'U';
                    continue;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(ReplaceVowelWithCaps.replace("venkata krishna"));
    }

}
