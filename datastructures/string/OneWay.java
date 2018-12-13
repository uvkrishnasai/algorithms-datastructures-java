package datastructures.string;

import java.util.stream.IntStream;

/**
 * Cracking the coding interview: 1.5
 *
 * One Way: Three types of edit
 * Insert a char
 * Remove a char
 * Replace a char
 */
public class OneWay {

    public static void main(String[] args) {

        String s1 = "pale";
        String s2 = "pae";

        boolean result = false;
        if(s1.length() == s2.length()) {
            result = onewayInsert(s1, s2);
        } else {
            if(s1.length() + 1 == s2.length()) {
                result = onewayReplace(s2, s1);
            } else if(s2.length() + 1 == s1.length()) {
                result = onewayReplace(s1, s2);
            } else {
                System.out.println("None found");
            }
        }

        if(!result)
            System.out.println("None found");

    }

    /**
     * Check for one char replace / remove
     * @param s1 String 1
     * @param s2 String 2
     * @return true/false
     */
    private static boolean onewayReplace(String s1, String s2) {
        boolean diffFound = false;
        int j = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if (diffFound) {
                    return false;
                }
                diffFound = true;
                continue;
            }
            j++;
        }
        System.out.println("One way replace/remove found");
        return true;
    }

    /**
     * Check for one char insert
     * @param s1 String 1
     * @param s2 String 2
     * @return true/false
     */
    private static boolean onewayInsert(String s1, String s2) {
        long count = IntStream.range(0, s1.length()).
                filter(i-> s1.charAt(i) != s2.charAt(i)).count();

        if(count <= 1) {
            System.out.println("one way insert found");
            return true;
        }

        return false;
    }


}
