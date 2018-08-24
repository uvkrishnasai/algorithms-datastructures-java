package org.practice.programs.beginner;

/**
 * Created by Krishna on 5/22/16.
 *
 * Best case: O(n/2)- (1/2), when we have odd number of characters in string.
 * Average case: O(n/2) , generally when we have even number of characters in string.
 * Worst case: O(n/2).
 *
 */
public class ReverseString {

    // My code
    public String reverse(String s) {
        char[] sChar = s.toCharArray();
        char[] reverseString = new char[sChar.length];
        int j = 0;
        for (int i = sChar.length-1; i >=0 ; i--) {
            reverseString[j++] = sChar[i];
        }
        return new String(reverseString);
    }

    // JMSE Code
    public String reverseBestPractice(String s) {
        char[] sChar = s.toCharArray();
        char temp = 0;
        for (int i = 0; i < sChar.length/2 ; i++) {
            temp = sChar[i];
            sChar[i] = sChar[sChar.length-i-1];
            sChar[sChar.length-i-1] = temp;
        }
        return new String(sChar);
    }

    // JMSE Code
    public String reverseUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverse("abcde"));
        System.out.println(rs.reverseBestPractice("abcde"));
        System.out.println(rs.reverseUsingStringBuilder("abcde"));
    }

}