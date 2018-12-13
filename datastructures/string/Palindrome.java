package datastructures.string;

import java.util.stream.IntStream;

/**
 * Created by Krishna on 5/22/16.
 *
 * If reverse of string is same as original one,
 * than our string is palindrome
 * or palindrome is a string which reads the same backward or forward.
 *
 */
public class Palindrome {

    /**
     * solution: s[] == s[::-1]
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        return IntStream.range(0, s.length()/2)
                .allMatch(i -> s.charAt(i) == s.charAt(s.length()-i-1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aqprtshncdcnhstrpqa"));
    }

}
